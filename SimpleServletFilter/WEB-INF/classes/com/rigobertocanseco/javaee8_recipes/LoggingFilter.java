package com.rigobertocanseco.javaee8_recipes;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class LoggingFilter implements Filter {
    private FilterConfig filterConfig;
    public void init(FilterConfig filterConfig){
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String userAddy = servletRequest.getRemoteHost();
        filterConfig.getServletContext().log("Visitor User IP:" + userAddy);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        throw new UnsupportedOperationException("NOT SUPPORTED YET.");
    }

    public void doFilter(ServletRequest request) {

    }
}