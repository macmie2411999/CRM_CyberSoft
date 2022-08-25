package com.macmie.crm_cybersoft.Controller;

import com.macmie.crm_cybersoft.Constants.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {
        Constants.URL_ROLE,
        Constants.URL_ROLE_ADD})
public class RoleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_ROLE:
                request.getRequestDispatcher(Constants.ROLE_TABLE_JSP).forward(request, response);
                break;

            case Constants.URL_ROLE_ADD:
                request.getRequestDispatcher(Constants.ROLE_ADD_JSP).forward(request, response);
                break;

            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_ROLE:
                request.getRequestDispatcher(Constants.ROLE_TABLE_JSP).forward(request, response);
                break;

            case Constants.URL_ROLE_ADD:
                request.getRequestDispatcher(Constants.ROLE_ADD_JSP).forward(request, response);
                break;

            default:
                break;
        }
    }
}
