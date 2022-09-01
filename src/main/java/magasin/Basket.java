package magasin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Servlet implementation class Basket
 */
public class Basket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Basket() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//On récupère le panier et on le passe à request
		HttpSession session = request.getSession(true);
		Supermarche panier = (Supermarche)session.getAttribute("panier");
		request.setAttribute("supermarche", panier);		
		
		this.getServletContext().getRequestDispatcher("/jsp/basket.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//On récupère le name du bouton cliqué (et donc la référence du l'article)
		Enumeration<String> parameterNames = request.getParameterNames();
		String ref = parameterNames.nextElement();
		
		//On récupère le panier
		HttpSession session = request.getSession(true);
		Supermarche panier = (Supermarche)session.getAttribute("panier");
		
		//On supprime l'article du panier
		panier.deleteArticles(ref);
		session.setAttribute("panier", panier);
		
		this.doGet(request, response);
	}

}
