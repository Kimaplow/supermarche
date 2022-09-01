package magasin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/jsp/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//On récupère les champs du formulaire
		String id = (String) request.getParameter("id");
		String password = (String) request.getParameter("password");
		
		//Si les champs sont admin/secret alors c'est un admin
		Boolean isAdmin = false;
		if(id.equals("admin") && password.equals("secret")) {
			isAdmin = true;
		}
		
		//On crée la session et on lui passe la valeur de isAdmin
		HttpSession session = request.getSession(true);
		session.setAttribute("isAdmin", isAdmin);
		
		
		//Si c'est un admin, on le dirige vers Manage (page d'administration), sinon vers Home
		if(isAdmin) {
			response.sendRedirect(request.getContextPath() + "/Manage");
		}
		else {
			response.sendRedirect(request.getContextPath() + "/Home");
		}		
	}
}

