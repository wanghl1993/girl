package com.imooc.utils.factory;

import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class DispatcherFilter implements Filter {

    private static final String URL_SEPARATOR = "/";

    private static final String SERVLET_PREFIX = "servlet/";

    private String servletName;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        parseRequestURL((HttpServletRequest) servletRequest);
        //这里为了体现我们本节的重点，我们采用一个工厂来帮我们制造Action
        if(servletName != null){
            //这里使用的正式简单的工厂模式，创造出一个servlet，然后我们将请求转交给servlet处理
//            Servlet servlet = ServletFactory
//            Servlet servlet = ServletFactory.createServlet(servletName);
//            Servlet servlet = ServletWebServerApplicationContext.
//            servlet.service(servletRequest,servletResponse);
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void parseRequestURL(HttpServletRequest httpServletRequest){
        String validURL = httpServletRequest.getRequestURI().
                replaceFirst(httpServletRequest.getContextPath()
                        + URL_SEPARATOR,"");
        if(validURL.startsWith(SERVLET_PREFIX)){
            servletName = validURL.split(URL_SEPARATOR)[1];
        }
    }

    @Override
    public void destroy() {

    }
}
