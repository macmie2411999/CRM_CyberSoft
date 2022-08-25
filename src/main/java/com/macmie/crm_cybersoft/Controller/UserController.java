package com.macmie.crm_cybersoft.Controller;

import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.Repository.UserRepository;
import com.macmie.crm_cybersoft.Repository.UserRepositoryInterface;
import com.macmie.crm_cybersoft.Service.UserService;
import com.macmie.crm_cybersoft.Service.UserServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {
        Constants.URL_USER,
        Constants.URL_USER_ADD,
        Constants.URL_USER_DETAILS})
public class UserController extends HttpServlet {
    UserRepositoryInterface userRepositoryInterface = (UserRepositoryInterface) new UserRepository();
    UserServiceInterface userServiceInterface = (UserServiceInterface) new UserService(userRepositoryInterface);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_USER:
                request.getRequestDispatcher(Constants.USER_TABLE_JSP).forward(request, response);
                break;

            case Constants.URL_USER_ADD:
                request.getRequestDispatcher(Constants.USER_ADD_JSP).forward(request, response);
                break;

            case Constants.URL_USER_DETAILS:
                request.getRequestDispatcher(Constants.USER_DETAILS_JSP).forward(request, response);
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
            case Constants.URL_USER:
                request.getRequestDispatcher(Constants.USER_TABLE_JSP).forward(request, response);
                break;

            case Constants.URL_USER_ADD:
                request.getRequestDispatcher(Constants.USER_ADD_JSP).forward(request, response);
                break;

            case Constants.URL_USER_DETAILS:
                request.getRequestDispatcher(Constants.USER_DETAILS_JSP).forward(request, response);
                break;

            default:
                break;
        }
    }
}
