package com.rigobertocanseco.javaee8_recipes;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class StartupShutdownListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Servlet startup ...");
        System.out.println(servletContextEvent.getServletContext().getServerInfo());
        System.out.println(System.currentTimeMillis());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Servlet shutdown ...");
        System.out.println(servletContextEvent.getServletContext().getServerInfo());
        System.out.println(System.currentTimeMillis());
    }
}
