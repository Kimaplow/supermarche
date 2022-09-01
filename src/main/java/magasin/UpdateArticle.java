package magasin;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Servlet implementation class ModifArticle
 */
public class UpdateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String ref = (String)request.getParameter("ref");
		
		ServletContext context = this.getServletContext();
		Supermarche sup = ((Supermarche)context.getAttribute("supermarche"));
		
		Article art = sup.getOneArticle(ref);
		
		request.setAttribute("article", art);
		
		this.getServletContext().getRequestDispatcher("/jsp/updateArticle.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//On récupère la référence de l'article dans l'url
		String ref = request.getParameter("ref");
		
		//On récupère le Supermarche
		ServletContext context = this.getServletContext();
		Supermarche sup = ((Supermarche)context.getAttribute("supermarche"));
		
		//On récupère l'article
		Article art = sup.getOneArticle(ref);

		//On récupère les champs
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()) {
			
			//On récupère le nom du champ et sa valeur
			String parameter = parameterNames.nextElement();
			String value = (String)request.getParameter(parameter);
			
			//Si sa valeur n'est pas vide
			if(value != "") {
				//On change l'attribut de l'Article selon le nom du champ
				switch(parameter) {
					case "codeBarre":
						long c = Long.parseLong(value);
						art.setCodeBarre(c);
						break;
					case "reference":
						art.setReference(value);
						break;
					case "libelle":
						art.setLibelle(value);
						break;
					case "prix":
						int p = Integer.parseInt(value);
						art.setPrixHT(p);
						break;
					case "tva":
						int t = Integer.parseInt(value);
						if(t != 3) { //3 est la valeur non changé du champ
							art.setTVA(t);
						}
						break;
					default:
						break;
				}
			}
		}
		
		//On update l'Article et on met à jour le Supermarche
		sup.replaceArticle(ref, art);
		context.setAttribute("supermarche", sup);
		
		response.sendRedirect("/Supermarche/Manage");
	}
}
