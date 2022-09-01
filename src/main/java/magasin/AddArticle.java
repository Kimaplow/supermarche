package magasin;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AddArticle
 */
public class AddArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/jsp/addArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//On récupère le Supermarche
		ServletContext context = this.getServletContext();
		Supermarche sup = ((Supermarche)context.getAttribute("supermarche"));
		
		//On récupère les champs du formulaire
		String codeBarre = request.getParameter("codeBarre");
		String ref = request.getParameter("reference");
		String libelle = request.getParameter("libelle");
		String prix = request.getParameter("prix");
		String tva = request.getParameter("tva");
		
		//On parse pour avoir le bon type
		long c = Long.parseLong(codeBarre);
		int p = Integer.parseInt(prix);
		int t = Integer.parseInt(tva);
		
		//On crée l'Article
		Article art = new Article(c, ref, libelle, p, t);
		
		//On ajoute l'Article au Supermarche et on envoie le Supermarche au context
		sup.addArticle(art);
		context.setAttribute("supermarche", sup);
		
		//On redirige vers la Servler Manage
		response.sendRedirect("/Supermarche/Manage");
	}
}
