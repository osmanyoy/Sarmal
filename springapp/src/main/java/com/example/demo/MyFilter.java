package com.example.demo;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Osman on 1.08.2017.
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter INIT");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        System.out.println("DoFilter Called");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("After DoFilter Called");

    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
