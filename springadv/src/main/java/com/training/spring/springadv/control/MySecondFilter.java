package com.training.spring.springadv.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// @Component
@WebFilter({"/hello/*","/test/*"})
public class MySecondFilter implements Filter{


    @Override
    public void init(FilterConfig filterConfig) throws
                                                ServletException {

        System.out.println(filterConfig.getInitParameter("osman"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws
                                                  IOException,
                                                  ServletException {
        System.out.println("My First Filter run");
        servletResponse.getOutputStream().print("Filter return ");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
