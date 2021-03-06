package com.rigobertocanseco.javaee8_recipes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddServlet", urlPatterns = "/AddServlet")
public class AddServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //store the input into strings
        String numA = request.getParameter("numa");
        String numB = request.getParameter("numb");
        System.out.println("numa:" + numA);
        System.out.println("numb:" + numB);
        int sum = Integer.parseInt(numA) + Integer.parseInt(numB);
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>The Sum of the Numbers</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Sum: " + sum + "</h1>");
            out.println("<br/>");
            out.println("<a href=index.html>Try Again</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return super.getServletInfo();
    }
}
