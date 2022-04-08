package pl.gda.pg.eti.kask.aui.servlet;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * All in one global all servlet events listener.
 * @author psysiu
 */
@WebListener()
public class ServletListener implements ServletContextListener, ServletContextAttributeListener,
        ServletRequestListener, ServletRequestAttributeListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private static final Logger log = Logger.getLogger(ServletListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.log(Level.INFO, "SERVLET: context initialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.log(Level.INFO, "SERVLET: context destroyed");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        log.log(Level.INFO, "SERVLET: context attribute added");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        log.log(Level.INFO, "SERVLET: context attribute removed");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        log.log(Level.INFO, "SERVLET: context attribute replaced");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.log(Level.INFO, "SERVLET: request destroyed");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.log(Level.INFO, "SERVLET: request initialized");
    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        log.log(Level.INFO, "SERVLET: request attribute added");
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        log.log(Level.INFO, "SERVLET: request attribute removed");
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        log.log(Level.INFO, "SERVLET: request attribute replaced");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        log.log(Level.INFO, "SERVLET: session created");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        log.log(Level.INFO, "SERVLET: session destroyed");
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        log.log(Level.INFO, "SERVLET: session attribute added");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        log.log(Level.INFO, "SERVLET: session attribute removed");
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        log.log(Level.INFO, "SERVLET: session attribute replaced");
    }
}
