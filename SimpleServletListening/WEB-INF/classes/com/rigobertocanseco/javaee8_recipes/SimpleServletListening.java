package com.rigobertocanseco.javaee8_recipes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SimpleServletListening", urlPatterns = {"/"},
        displayName = "SimpleServletListening")
public class SimpleServletListening extends HttpServlet  {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SimpleServletListening</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Servlet SimpleServletListening at " + request.getContextPath() + "</h2>");
            out.println("<br/>Welcome to Java EE Recipes!");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
	    }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "short description";
    }
}
