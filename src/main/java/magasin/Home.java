package magasin;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Enumeration;

/**
 * Servlet implementation class Home
 */
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//On récupère le name du bouton cliqué (et donc la référence du l'article)
		Enumeration<String> parameterNames = request.getParameterNames();
		String ref = parameterNames.nextElement();

		//On récupère l'article
		ServletContext context = this.getServletContext();
		Supermarche sup = (Supermarche)context.getAttribute("supermarche");
		Article art = sup.getOneArticle(ref);
				
		//On récupère le panier
		HttpSession session = request.getSession(true);
		Supermarche panier = (Supermarche)session.getAttribute("panier");
				
		//On ajoute l'article au panier
		if(panier == null) {
			panier = new Supermarche();
		}
		panier.addArticle(art);
		session.setAttribute("panier", panier);
				
		this.getServletContext().getRequestDispatcher("/jsp/home.jsp").forward(request, response);
	}

}
