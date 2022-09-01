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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = {
        Constants.URL_PROFILE,
        Constants.URL_PROFILE_EDIT})
public class ProfileController extends HttpServlet {

    List<ProjectAssignmentUser> listProjectAssignmentUser;
    PAU_DTO_RepositoryInterface pau_dto_repositoryInterface;
    PAU_DTO_ServiceInterface pau_dto_serviceInterface;

    UserRepositoryInterface userRepositoryInterface;
    UserServiceInterface userServiceInterface;

    ProjectRepositoryInterface projectRepositoryInterface;
    ProjectServiceInterface projectServiceInterface;

    AssignmentRepositoryInterface assignmentRepositoryInterface;
    AssignmentServiceInterface assignmentServiceInterface;

    List<ProjectAssignmentUser> listPAUTemp1;
    List<Project_CRM> listProjects;
    List<Assignment_CRM> listAssignments;
    List<User_CRM> listUsers;

    String idUpdateAssignment;

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

        listUsers = new ArrayList<User_CRM>();
        userRepositoryInterface = (UserRepositoryInterface) new UserRepository(listUsers);
        userServiceInterface = (UserServiceInterface) new UserService(userRepositoryInterface);

        HttpServletRequest requestHttp = (HttpServletRequest) request;
        String idCurrentUser = "" + requestHttp.getSession().getAttribute(Constants.ID_CURRENT_USER).toString();

        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_PROFILE:
                // Get all assignments of selected user
                List<ProjectAssignmentUser> list_PAU_Temp = pau_dto_serviceInterface.getAllProjectAssignmentUser();
                List<ProjectAssignmentUser> list_PAU_Final = pau_dto_serviceInterface.getAll_PAU_By_UserID(list_PAU_Temp, idCurrentUser);

                // Set attributes and forward to View
                // Check if user have any assignments
                if(list_PAU_Final.size()==0){
                    System.out.println("User have no PAU/Assignment");
                } else{
                    request.setAttribute(Constants.SELECTED_USE, userServiceInterface.getUserById(Integer.parseInt(idCurrentUser)));
                    request.setAttribute(Constants.LIST_PAU_PROJECT, list_PAU_Final);
                    request.setAttribute(Constants.LIST_COMPLETED_ASSIGNMENTS, pau_dto_serviceInterface.getAll_PAU_By_statusAssignment(list_PAU_Final, Constants.ASSIGNMENT_COMPLETED));
                    request.setAttribute(Constants.LIST_PROCESSING_ASSIGNMENTS, pau_dto_serviceInterface.getAll_PAU_By_statusAssignment(list_PAU_Final, Constants.ASSIGNMENT_PROCESSING));
                    request.setAttribute(Constants.LIST_STILL_ASSIGNMENTS, pau_dto_serviceInterface.getAll_PAU_By_statusAssignment(list_PAU_Final, Constants.ASSIGNMENT_STILL));
//                    request.getRequestDispatcher(Constants.PROFILE_JSP).forward(request, response);
//                    response.sendRedirect(request.getContextPath() + Constants.USER_DETAILS_JSP);
                }
                request.getRequestDispatcher(Constants.PROFILE_JSP).forward(request, response);

                break;

            case Constants.URL_PROFILE_EDIT:

                // Get ID Assignment from request
                HttpSession session = request.getSession();
                session.setAttribute(Constants.SELECTED_ASSIGNMENT_ID, request.getParameter(Constants.JUST_ID));

                List<ProjectAssignmentUser> PAU_Temp = pau_dto_serviceInterface.getAllProjectAssignmentUser();
                ProjectAssignmentUser PAU_Final = pau_dto_serviceInterface.get_PAU_By_assignmentID(PAU_Temp, idUpdateAssignment);

                // Set attributes and forward to View
                request.setAttribute(Constants.SELECTED_USE, userServiceInterface.getUserById(Integer.parseInt(idCurrentUser)));
                request.setAttribute(Constants.SELECTED_PAU, PAU_Final);
                request.setAttribute(Constants.LIST_PROJECTS, projectServiceInterface.getAllProjects());
                request.setAttribute(Constants.LIST_ASSIGNMENTS_STATUS, Arrays.asList(Constants.ASSIGNMENT_STILL,
                        Constants.ASSIGNMENT_PROCESSING, Constants.ASSIGNMENT_COMPLETED));

                request.getRequestDispatcher(Constants.PROFILE_EDIT_JSP).forward(request, response);
                break;

            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        idUpdateAssignment = (String) session.getAttribute(Constants.SELECTED_ASSIGNMENT_ID);

        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        Assignment_CRM assignment;
        switch (servletPath) {

            case Constants.URL_PROFILE_EDIT:
                assignment = new Assignment_CRM();
                assignment.setAssignment_Name(request.getParameter(Constants.ASSIGNMENT_CRM_NAME));
                assignment.setAssignment_Start_Date(request.getParameter(Constants.ASSIGNMENT_CRM_START_DATE));
                assignment.setAssignment_End_Date(request.getParameter(Constants.ASSIGNMENT_CRM_END_DATE));
                assignment.setAssignment_Status(request.getParameter(Constants.ASSIGNMENT_CRM_STATUS));
                assignment.setAssignment_Project_ID(Integer.parseInt(request.getParameter(Constants.ASSIGNMENT_CRM_PROJECT_ID)));

                // Execute add query
                assignmentServiceInterface.updateAssignmentByID(assignment, Integer.parseInt(idUpdateAssignment));

                response.sendRedirect(request.getContextPath() + Constants.URL_PROFILE);
                break;

            default:
                break;
        }
    }
}
