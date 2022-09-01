package magasin;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet Filter implementation class ManageFilter
 */
@SuppressWarnings("serial")
@WebFilter("/Manage/*")
public class FilterManage extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FilterManage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		//Pour accèder aux pages d'administration
		//On vérifie si l'utilisateur connecté est un admin, sinon on redirige vers la page de connexion
		
		HttpServletRequest hsr = (HttpServletRequest) request;
        HttpServletResponse hsresp = (HttpServletResponse) response;
        HttpSession session = hsr.getSession();

        Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");

        if(isAdmin == null || isAdmin == false) {
            hsresp.sendRedirect(hsr.getContextPath() + "/Login"); 
        }
        else {
            chain.doFilter(request, response);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
