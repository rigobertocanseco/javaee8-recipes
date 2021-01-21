package com.rigobertocanseco.javaee8_recipes;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    private int numberOfSessions;

    public int getNumberOfSessions() {
        return numberOfSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(60);
        session.setAttribute("testAttribute:", "testVal");
        synchronized (this) {
            numberOfSessions++;
        }
        System.out.println("Session created, current count:" + numberOfSessions);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        synchronized (this){
            numberOfSessions--;
        }
        System.out.println("Session destroyed, current count:" + numberOfSessions);
        System.out.println("The attribute value:" + session.getAttribute("testAttribute"));
    }
}
