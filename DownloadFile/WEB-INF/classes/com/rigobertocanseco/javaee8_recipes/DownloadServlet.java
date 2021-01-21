package com.rigobertocanseco.javaee8_recipes;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name="DownloadServlet", urlPatterns = {"/DownloadServlet"})
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Read the parameter of form that contains te file name to download
        String file = req.getParameter("filename");
        // Call  the download method with the given file
        System.out.println("Downloading file now ...");
        doDownload(req, resp, file);
    }

    private void doDownload(HttpServletRequest request, HttpServletResponse response, String originalFile) throws IOException {
        final int Bytes = 1024;
        int length = 0;
        ServletOutputStream outputStream = response.getOutputStream();
        ServletContext context = request.getServletContext();

        response.setContentType(context.getMimeType(originalFile)!= null?context.getMimeType(originalFile):"text/plain");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFile + "\"");

        InputStream in = context.getResourceAsStream("/"+ originalFile);
        byte[] buffer = new byte[Bytes];
        while ((in!=null) && ((length = in.read(buffer)) != -1)) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.flush();
        outputStream.close();
    }
}