package controller.listeners;


import model.dao.DaoFactory;
import model.dao.impl.JDBCEventFactory;
import model.service.EventService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext servletContext = servletContextEvent.getServletContext();

        EventService eventService = new EventService();
        servletContext.setAttribute("events", eventService.getUpcomingEvents());


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
