package com.macmie.crm_cybersoft.Controller;

import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;
import com.macmie.crm_cybersoft.Repository.*;
import com.macmie.crm_cybersoft.Service.*;

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

    AssignmentRepositoryInterface assignmentRepositoryInterface;
    AssignmentServiceInterface assignmentServiceInterface;

    List<ProjectAssignmentUser> listPAUTemp1;
    List<Project_CRM> listProjects;
    List<Assignment_CRM> listAssignments;
    List<User_CRM> listUsers;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // New Obs
        listProjectAssignmentUser = new ArrayList<ProjectAssignmentUser>();
        pau_dto_repositoryInterface = (PAU_DTO_RepositoryInterface) new PAU_DTO_Repository(listProjectAssignmentUser);
        pau_dto_serviceInterface = (PAU_DTO_ServiceInterface) new PAU_DTO_Service(pau_dto_repositoryInterface);

        listAssignments = new ArrayList<Assignment_CRM>();
        assignmentRepositoryInterface = (AssignmentRepositoryInterface) new AssignmentRepository( listAssignments);
        assignmentServiceInterface = (AssignmentServiceInterface) new AssignmentService(assignmentRepositoryInterface);

        listProjects = new ArrayList<Project_CRM>();
        projectRepositoryInterface = (ProjectRepositoryInterface) new ProjectRepository(listProjects);
        projectServiceInterface = (ProjectServiceInterface) new ProjectService(projectRepositoryInterface);

        String projectID;

        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_PROJECT:

                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_PROJECTS, projectServiceInterface.getAllProjects());

                request.getRequestDispatcher(Constants.PROJECT_JSP).forward(request, response);
                break;

            case Constants.URL_PROJECT_ADD:
                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_PROJECTS, projectRepositoryInterface.getAllProjects());

                request.getRequestDispatcher(Constants.PROJECT_ADD_JSP).forward(request, response);
                break;

            case Constants.URL_PROJECT_DELETE:

                // Remove Assignment by ID using AssignmentServiceInterface
                projectServiceInterface.deleteProjectsByID(request.getParameter(Constants.JUST_ID));

//                int projectIDFlag = Integer.parseInt(request.getParameter("id"));
//                listProjectAssignmentUser = pau_dto_serviceInterface.getAllProjectAssignmentUser();
//                for(ProjectAssignmentUser element : listProjectAssignmentUser){
//                    if(element.getAssignment_Project_ID() == projectIDFlag){
//
//                        // Can't delete
//                        request.setAttribute(Constants.FLAG_UN_DELETABLE, "FALSE");
//                    } else{
//
//                        // Deletable
//                        request.setAttribute(Constants.FLAG_UN_DELETABLE, "TRUE");
//                        projectServiceInterface.deleteProjectsByID(request.getParameter("id"));
//                        break;
//                    }
//                }

                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_PROJECTS, projectServiceInterface.getAllProjects());

                response.sendRedirect(request.getContextPath() + Constants.URL_PROJECT);
//                request.getRequestDispatcher(Constants.PROJECT_JSP).forward(request, response);
                break;

            case Constants.URL_PROJECT_DETAILS:

                // Get Project ID from request
                projectID = request.getParameter(Constants.JUST_ID);
                System.out.println("ID Project: " + projectID);

                // Get all assignments of selected project
                List<ProjectAssignmentUser> list_PAU_Temp = pau_dto_serviceInterface.getAllProjectAssignmentUser();
                List<ProjectAssignmentUser> list_PAU_Final = pau_dto_serviceInterface.getAll_PAU_By_ProjectID(list_PAU_Temp, projectID);
                System.out.println("PAU of Project: " + list_PAU_Final.size());

                // Set attributes and forward to View
                // Check if user have any assignments
                if(list_PAU_Final.size()==0){
                    System.out.println("Project have no PAU/Assignment");
                    response.sendRedirect(request.getContextPath() + Constants.URL_PROJECT);
                } else{
                    request.setAttribute(Constants.SELECTED_PROJECT, projectServiceInterface.getProjectByID(String.valueOf(projectID)));
                    request.setAttribute(Constants.LIST_PAU_PROJECT, list_PAU_Final);
                    request.setAttribute(Constants.LIST_COMPLETED_ASSIGNMENTS, pau_dto_serviceInterface.getAll_PAU_By_statusAssignment(list_PAU_Final, Constants.ASSIGNMENT_COMPLETED));
                    request.setAttribute(Constants.LIST_PROCESSING_ASSIGNMENTS, pau_dto_serviceInterface.getAll_PAU_By_statusAssignment(list_PAU_Final, Constants.ASSIGNMENT_PROCESSING));
                    request.setAttribute(Constants.LIST_STILL_ASSIGNMENTS, pau_dto_serviceInterface.getAll_PAU_By_statusAssignment(list_PAU_Final, Constants.ASSIGNMENT_STILL));
                    request.getRequestDispatcher(Constants.PROJECT_DETAILS_JSP).forward(request, response);
//                    response.sendRedirect(request.getContextPath() + Constants.USER_DETAILS_JSP);
                }
                break;

            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // New Obs
        listProjects = new ArrayList<Project_CRM>();
        projectRepositoryInterface = (ProjectRepositoryInterface) new ProjectRepository(listProjects);
        projectServiceInterface = (ProjectServiceInterface) new ProjectService(projectRepositoryInterface);
        Project_CRM project;

        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_PROJECT_ADD:

                project = new Project_CRM();
                project.setProject_Name(request.getParameter(Constants.PROJECT_CRM_NAME));
                project.setProject_Start_Date(request.getParameter(Constants.PROJECT_CRM_START_DATE));
                project.setProject_End_Date(request.getParameter(Constants.PROJECT_CRM_END_DATE));

                // Execute add query;
                projectServiceInterface.addNewProject(project);

                response.sendRedirect(request.getContextPath() + Constants.URL_PROJECT);

                break;

            default:
                break;
        }
    }
}
