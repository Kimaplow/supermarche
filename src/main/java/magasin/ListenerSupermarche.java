package magasin;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class ListenerSupermarche
 *
 */
public class ListenerSupermarche implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ListenerSupermarche() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	// TODO Auto-generated method stub
    	//On cre des Articles
    	Article art1 = new Article(999999991, "001", "Saucisse", 241, 0);
		Article art2 = new Article(999999992, "002", "Carotte", 139, 0);
		Article art3 = new Article(999999993, "003", "Purée", 200, 0);
		Article art4 = new Article(999999994, "004", "Pâte", 399, 1);
		Article art5 = new Article(999999995, "005", "Steak", 1026, 1);
		Article art6 = new Article(999999996, "006", "Gâteau", 712, 1);
		
		//On les ajoute au Supermarche
		Supermarche sup = new Supermarche();
		sup.addArticle(art1);
		sup.addArticle(art2);
		sup.addArticle(art3);
		sup.addArticle(art4);
		sup.addArticle(art5);
		sup.addArticle(art6);
		
		//On ajoute le Supermarche au context
		ServletContext context = sce.getServletContext();
		context.setAttribute("supermarche", sup);
		
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
