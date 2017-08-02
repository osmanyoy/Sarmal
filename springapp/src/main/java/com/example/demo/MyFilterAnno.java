package com.example.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/hello")
public class MyFilterAnno implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter2 INIT");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DoFilter2 Called");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("After DoFilter2 Called");

    }

    @Override
    public void destroy() {
        System.out.println("Destroy2");
    }
}
