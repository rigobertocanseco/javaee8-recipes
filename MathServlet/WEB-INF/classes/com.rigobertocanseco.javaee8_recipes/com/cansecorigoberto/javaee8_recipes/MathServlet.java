package  com.cansecorigoberto.javaee8_recipes;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;

@WebServlet(name="MathServlet", urlPatterns = {"/MathServlet"})
public class MathServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
        response.setContentType("text/html");
        //Store the input parameter values into Strings
        String numA = request.getParameter("numa");
        String numB = request.getParameter("numb");

        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<title>Test Math Servlet</title>");
        out.println("\t<style>body { font-family: 'Lucida Grande', "
                + "'Lucida Sans Unicode';font-size: 13px; }</style>");
        out.println("</head>");
        out.println("<body>");

        try {
            int solution = Integer.valueOf(numA) + Integer.valueOf(numB);
            out.println("<p>Solution: " +  numA + "+" + numB + "=" + solution + "</p>");
        } catch (NumberFormatException e) {
            out.println("<p>Please use numbers only .. try again. </p>");
        }
        out.println("<br/><br/>");
        out.println("<a href='index.html'>Add Two More Numbers</a>");
        out.println("</body></html>");
        out.close();
    }
}