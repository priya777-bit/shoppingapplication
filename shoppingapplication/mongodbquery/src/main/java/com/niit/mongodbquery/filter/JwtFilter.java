package com.niit.mongodbquery.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response1 = (HttpServletResponse) response;
        HttpServletRequest request1 = (HttpServletRequest) request;

        String authHeader = ((HttpServletRequest) request).getHeader("authorization");

        if("OPTIONS".equals(((HttpServletRequest) request).getMethod()))
        {
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_OK);
            chain.doFilter(request,response);
        }
        else
        {
            if(authHeader==null || !authHeader.startsWith("Bearer "))
            {
                throw new ServletException("Missing Exception");
            }
        }

        String token = authHeader.substring(7);

        Claims claims = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody();

        request.setAttribute("Claims",claims);
        chain.doFilter(request,response);
    }
}
