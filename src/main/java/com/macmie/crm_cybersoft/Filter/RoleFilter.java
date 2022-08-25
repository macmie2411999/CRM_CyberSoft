package com.macmie.crm_cybersoft.Filter;

import com.macmie.crm_cybersoft.Constants.Constants;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// Filter for all
@WebFilter(urlPatterns = "/*")
public class RoleFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest requestHttp = (HttpServletRequest) request;
        HttpServletResponse responseHttp = (HttpServletResponse) response;
        HttpSession session = requestHttp.getSession();
        requestHttp.setCharacterEncoding("UTF-8");
        String servletPath = requestHttp.getServletPath();

        // vao link khac login
        if(!(servletPath.equals(Constants.URL_LOGIN)
                || servletPath.equals(Constants.URL_LOGIN_1)
                ||servletPath.equals(Constants.URL_LOGIN_2))){

            // da có id
            if(session.getAttribute(Constants.ID_CURRENT_USER) !=null){
                // Admin can access all
                if(session.getAttribute(Constants.ID_CURRENT_USER_ROLE).equals(Constants.ROLE_ADMIN)){
                    chain.doFilter(request, response);
                } else if(session.getAttribute(Constants.ID_CURRENT_USER_ROLE).equals(Constants.ROLE_LEADER)){
                    // Leader can't access links including "/role"
                    if(servletPath.startsWith(Constants.URL_ROLE)){
                        responseHttp.sendRedirect(requestHttp.getContextPath() + Constants.URL_PNG);
                    } else{
                        chain.doFilter(request, response);
                    }
                } else{
                    // Member can't access links including "/user" or "/assignment" or "/role"
                    if(servletPath.startsWith(Constants.URL_ASSIGNMENT)
                            || servletPath.startsWith(Constants.URL_USER)
                            || servletPath.startsWith(Constants.URL_ROLE)){
                        responseHttp.sendRedirect(requestHttp.getContextPath() + Constants.URL_PNG);
                    } else{
                        chain.doFilter(request, response);
                    }
                }
            } else{
                // chua co id
                responseHttp.sendRedirect(requestHttp.getContextPath() + Constants.URL_LOGIN);
            }
        } else{
            // link login

            // neu chua co id thi vao login
            if(session.getAttribute(Constants.ID_CURRENT_USER)==null){
                chain.doFilter(request, response);
            } else{
                // neu da co id thi huy tat ca sessions (de dang nhap lai, tuong tu nhu logout)
                session.invalidate();
                responseHttp.sendRedirect(requestHttp.getContextPath() + Constants.URL_LOGIN);
            }
        }


    }
}
