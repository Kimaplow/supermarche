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
import java.util.Map;

/**
 * Servlet implementation class Manage
 */
public class Manage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//On récupère le Supermarche pour le passer à request
		ServletContext context = this.getServletContext();
		request.setAttribute("supermarche", context.getAttribute("supermarche"));
		
		this.getServletContext().getRequestDispatcher("/jsp/manage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//On récupère la référence de l'article que l'on veut supprimer
		Enumeration<String> parameterNames = request.getParameterNames();
		String ref = parameterNames.nextElement();
		
		//On récupère le Supermarche
		ServletContext context = this.getServletContext();
		Supermarche sup = (Supermarche)context.getAttribute("supermarche");
		
		//On supprime l'article du Supermarche et on met à jour le Supermarche dans le context
		sup.deleteArticles(ref);
		context.setAttribute("supermarche", sup);
		
		//On récupère le panier
		HttpSession session = request.getSession(true);
		sup = (Supermarche)session.getAttribute("panier");
		
		//Si l'article est dans le panier, on le supprime
		if(sup != null && sup.getOneArticle(ref) != null) {
			sup.deleteArticles(ref);
			request.setAttribute("supermarche", sup);
		}
		
		this.doGet(request, response);
		
	}

}