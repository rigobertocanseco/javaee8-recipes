package com.rigobertocanseco.javaee8_recipes;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public final class AttributeListener implements ServletContextListener, HttpSessionAttributeListener {
    private ServletContext servletContext;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        this.servletContext = servletContextEvent.getServletContext();
        log("contextInitialized()");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        HttpSession session = httpSessionBindingEvent.getSession();
        String id = session.getId();
        String name = httpSessionBindingEvent.getName();
        String value = (String) httpSessionBindingEvent.getValue();
        String message = new StringBuffer("New attribute has been added to session\n").append("Attribute name:")
                .append(name).append("\n").append("Attribute values:").append(value).toString();
        log(message);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        String name = httpSessionBindingEvent.getName();
        if(name == null) {
            name ="Unknown";
        }
        String value = (String) httpSessionBindingEvent.getValue();
        String message = new StringBuffer("Attribute has been replaced:\n").append(name).toString();
        log(message);
    }

    private void log(String message) {
        if (servletContext != null){
            servletContext.log("SessionListener:" + message);
        } else {
            System.out.println("SessionListener" +  message);
        }
    }
}
