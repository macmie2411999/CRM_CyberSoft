package com.macmie.crm_cybersoft.Controller;

import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;
import com.macmie.crm_cybersoft.Repository.AssignmentRepositoryInterface;
import com.macmie.crm_cybersoft.Repository.PAU_DTO_Repository;
import com.macmie.crm_cybersoft.Repository.PAU_DTO_RepositoryInterface;
import com.macmie.crm_cybersoft.Repository.ProjectRepositoryInterface;
import com.macmie.crm_cybersoft.Service.AssignmentServiceInterface;
import com.macmie.crm_cybersoft.Service.PAU_DTO_Service;
import com.macmie.crm_cybersoft.Service.PAU_DTO_ServiceInterface;
import com.macmie.crm_cybersoft.Service.ProjectServiceInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {
        Constants.URL_PROJECT,
        Constants.URL_PROJECT_ADD,
        Constants.URL_PROJECT_DELETE,
        Constants.URL_PROJECT_DETAILS})
public class ProjectController extends HttpServlet {
    List<ProjectAssignmentUser> listProjectAssignmentUser;
    PAU_DTO_RepositoryInterface pau_dto_repositoryInterface;
    PAU_DTO_ServiceInterface pau_dto_serviceInterface;

    ProjectRepositoryInterface projectRepositoryInterface;
    ProjectServiceInterface projectServiceInterface;

    List<Project_CRM> listProjects;
    List<Assignment_CRM> listAssignments;
    List<User_CRM> listUsers;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // New Obs
        listProjectAssignmentUser = new ArrayList<ProjectAssignmentUser>();
        pau_dto_repositoryInterface = (PAU_DTO_RepositoryInterface) new PAU_DTO_Repository(listProjectAssignmentUser);
        pau_dto_serviceInterface = (PAU_DTO_ServiceInterface) new PAU_DTO_Service(pau_dto_repositoryInterface);

        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_PROJECT:

                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_PROJECTS, pau_dto_serviceInterface.getAllProjects());

                request.getRequestDispatcher(Constants.PROJECT_JSP).forward(request, response);
                break;

            case Constants.URL_PROJECT_ADD:
                request.getRequestDispatcher(Constants.PROJECT_ADD_JSP).forward(request, response);
                break;

            case Constants.URL_PROJECT_DELETE:
                request.getRequestDispatcher(Constants.PROJECT_DETAILS_JSP).forward(request, response);
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
