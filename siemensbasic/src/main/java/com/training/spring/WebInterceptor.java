package com.training.spring;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Component
public class WebInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object o) throws Exception {


//        Authentication authentication = SecurityContextHolder.getContext()
//                                                             .getAuthentication();
//        if (authentication == null) {
//            return true;
//        }
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//        for (GrantedAuthority grantedAuthority : authorities) {
//            if (grantedAuthority.getAuthority()
//                                .equals("ADMIN")) {
//                return true;
//            }
//        }
//        System.out.println("preHandle");
        //        httpServletResponse.setStatus(305);
        //        httpServletResponse.getOutputStream().println("Yanlis girdiniz");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o,
                           ModelAndView modelAndView) throws Exception {

        System.out.println("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o,
                                Exception e) throws Exception {
        System.out.println("afterComplete");

    }
}
