/** 
 * Edison J. Javier III
 * Nigel Haim N. Sebastian
 * Group 5 - 2CSC
 * MP3 - Web App
 */

package controller;

import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("Booting up FileXpress..."); // This will display when the web app starts
        
        ServletContext context = sce.getServletContext(); // Uses the ServletContextEvent to get the ServletContext
        context.setAttribute("date", new Date()); // Places a new date object in the ServletContext
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Shutting down FileXpress..."); // This will display when the web app closes
    }
}

