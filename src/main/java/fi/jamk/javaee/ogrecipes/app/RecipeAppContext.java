package fi.jamk.javaee.ogrecipes.app;
import javax.persistence.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class RecipeAppContext implements ServletContextListener {

    private static EntityManagerFactory emfactory;

    @Override
    public void contextInitialized(ServletContextEvent event) {
    	emfactory = Persistence.createEntityManagerFactory("ogrecipes-jpa");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    	emfactory.close();
    }

    public static EntityManager createEntityManager() throws Exception {
    	if (emfactory == null)
    		throw new Exception("Entity manager factory not initialized.");
        return emfactory.createEntityManager();
    }
}