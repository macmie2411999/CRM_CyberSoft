package com.macmie.crm_cybersoft.Controller;

import com.macmie.crm_cybersoft.Constants.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {
        Constants.URL_PROJECT,
        Constants.URL_PROJECT_ADD,
        Constants.URL_PROJECT_DETAILS})
public class ProjectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_PROJECT:
                request.getRequestDispatcher(Constants.PROJECT_JSP).forward(request, response);
                break;

            case Constants.URL_PROJECT_ADD:
                request.getRequestDispatcher(Constants.PROJECT_ADD_JSP).forward(request, response);
                break;

            case Constants.URL_PROJECT_DETAILS:
                request.getRequestDispatcher(Constants.PROJECT_DETAILS_JSP).forward(request, response);
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
            case Constants.URL_PROJECT:
                request.getRequestDispatcher(Constants.PROJECT_JSP).forward(request, response);
                break;

            case Constants.URL_PROJECT_ADD:
                request.getRequestDispatcher(Constants.PROJECT_ADD_JSP).forward(request, response);
                break;

            case Constants.URL_PROJECT_DETAILS:
                request.getRequestDispatcher(Constants.PROJECT_DETAILS_JSP).forward(request, response);
                break;

            default:
                break;
        }
    }
}
