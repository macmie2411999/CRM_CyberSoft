package com.macmie.crm_cybersoft.Controller;

import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.Pojo.User_CRM;
import com.macmie.crm_cybersoft.Repository.UserRepository;
import com.macmie.crm_cybersoft.Repository.UserRepositoryInterface;
import com.macmie.crm_cybersoft.Service.UserService;
import com.macmie.crm_cybersoft.Service.UserServiceInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = {
        Constants.URL_LOGIN,
        Constants.URL_LOGIN_1,
        Constants.URL_LOGIN_2})
public class LoginController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.LOGIN_JSP);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserRepositoryInterface userRepositoryInterface = (UserRepositoryInterface) new UserRepository();
        UserServiceInterface userServiceInterface = (UserServiceInterface) new UserService(userRepositoryInterface);

        String email = request.getParameter(Constants.LOGIN_JSP_EMAIL);
        String password = request.getParameter(Constants.LOGIN_JSP_PASSWORD);
        User_CRM userLogin = userServiceInterface.getUserLogin(email, password);

        if(userLogin==null){
            request.setAttribute(Constants.MESSAGE_LOGIN,Constants.SESSION_FAILED_LOGIN);
            request.getRequestDispatcher(Constants.LOGIN_JSP).forward(request, response);
        } else{
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(10000);

            // Save User's ID and Role in Session
            session.setAttribute(Constants.ID_CURRENT_USER, userLogin.getUser_ID() + "");
            session.setAttribute(Constants.ID_CURRENT_USER_ROLE, userLogin.getUser_Role_ID()+ "");
            response.sendRedirect(request.getContextPath() + Constants.URL_HOME);
        }
    }
}
