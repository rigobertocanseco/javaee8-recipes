package com.rigobertocanseco.javaee8_recipes;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="MathDispatcher", urlPatterns = {"/MathDispatcher"})
public class MathDispatcher extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("In the servlet ...");
        // store the input parameter values into string
        String eval = req.getParameter("matheval");

        ServletContext context = getServletConfig().getServletContext();
        RequestDispatcher requestDispatcher;

        int evaluate = 0;

        if(eval.equals("subtract")){
            evaluate = 1;
        }
        if(eval.equals("multiply")){
            evaluate = 2;
        }
        if(eval.equals("divide")){
            evaluate = 3;
        }

        switch (evaluate) {
            case 0:
                requestDispatcher = context.getRequestDispatcher("/AddServlet");
                requestDispatcher.forward(req, resp);
                break;
            case 1:
                requestDispatcher = context.getRequestDispatcher("/SubtractServlet");
                requestDispatcher.forward(req, resp);
                break;
            case 2:
                requestDispatcher = context.getRequestDispatcher("/MultiplyServlet");
                requestDispatcher.forward(req, resp);
                break;
            case 3:
                requestDispatcher = context.getRequestDispatcher("/DivideServlet");
                requestDispatcher.forward(req, resp);
                break;
        }
    }
}