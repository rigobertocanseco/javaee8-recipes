package com.rigobertocanseco.javaee8_recipes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"}, displayName = "SessionServlet")
public class SessionServlet extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        //Obtain the Session object
        HttpSession session = request.getSession(true);
        // set up  session attribute
        String email = (String) session.getAttribute("email");
        if (email == null) {
            email = request.getParameter("email");
            session.setAttribute("email", email);
        }

        String sessionId = session.getId();
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Working with sessions</title></head>");
        out.println("<body>");
        out.println("<h1>Session Test</h1>");
        out.println ("Your email address is: " + email + "<br/><br/>");
        out.println ("Your session id: " + sessionId);
        out.println("</body></html>");
    }
}
