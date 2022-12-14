package com.macmie.crm_cybersoft.Controller;

import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.DTO.AssignmentUserRole;
import com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;
import com.macmie.crm_cybersoft.Repository.*;
import com.macmie.crm_cybersoft.Service.*;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {
        Constants.URL_ASSIGNMENT,
        Constants.URL_ASSIGNMENT_ADD,
        Constants.URL_ASSIGNMENT_DELETE})
public class AssignmentController extends HttpServlet {

    List<ProjectAssignmentUser> listProjectAssignmentUser;
    PAU_DTO_RepositoryInterface pau_dto_repositoryInterface;
    PAU_DTO_ServiceInterface pau_dto_serviceInterface;

    AssignmentRepositoryInterface assignmentRepositoryInterface;
    AssignmentServiceInterface assignmentServiceInterface;

    ProjectRepositoryInterface projectRepositoryInterface;
    ProjectServiceInterface projectServiceInterface;

    UserRepositoryInterface userRepositoryInterface;
    UserServiceInterface userServiceInterface;

    List<Project_CRM> listProjects;
    List<Assignment_CRM> listAssignments;
    List<User_CRM> listUsers;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // New Obs
        listProjectAssignmentUser = new ArrayList<ProjectAssignmentUser>();
        pau_dto_repositoryInterface = (PAU_DTO_RepositoryInterface) new PAU_DTO_Repository(listProjectAssignmentUser);
        pau_dto_serviceInterface = (PAU_DTO_ServiceInterface) new PAU_DTO_Service(pau_dto_repositoryInterface);

        listProjects = new ArrayList<Project_CRM>();
        projectRepositoryInterface = (ProjectRepositoryInterface) new ProjectRepository(listProjects);
        projectServiceInterface = (ProjectServiceInterface) new ProjectService(projectRepositoryInterface);

        listUsers = new ArrayList<User_CRM>();
        userRepositoryInterface = (UserRepositoryInterface) new UserRepository(listUsers);
        userServiceInterface = (UserServiceInterface) new UserService(userRepositoryInterface);

        listAssignments = new ArrayList<Assignment_CRM>();
        assignmentRepositoryInterface = (AssignmentRepositoryInterface) new AssignmentRepository( listAssignments);
        assignmentServiceInterface = (AssignmentServiceInterface) new AssignmentService(assignmentRepositoryInterface);

        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_ASSIGNMENT:

                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_PAU_DTO, pau_dto_serviceInterface.getAllProjectAssignmentUser());

                request.getRequestDispatcher(Constants.ASSIGNMENT_JSP).forward(request, response);
                break;

            case Constants.URL_ASSIGNMENT_ADD:

                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_PAU_DTO, pau_dto_serviceInterface.getAllProjectAssignmentUser());
                request.setAttribute(Constants.LIST_PROJECTS, projectServiceInterface.getAllProjects());
                request.setAttribute(Constants.LIST_USERS, userServiceInterface.getAllUsers());

                request.getRequestDispatcher(Constants.ASSIGNMENT_ADD_JSP).forward(request, response);
                break;

            case Constants.URL_ASSIGNMENT_DELETE:

                // Remove Assignment by ID using AssignmentServiceInterface
                assignmentServiceInterface.deleteAssignmentsByID(request.getParameter(Constants.JUST_ID));

                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_PAU_DTO, pau_dto_serviceInterface.getAllProjectAssignmentUser());

                response.sendRedirect(request.getContextPath() + Constants.URL_ASSIGNMENT);
//                request.getRequestDispatcher(Constants.ASSIGNMENT_JSP).forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // New Obs
        listAssignments = new ArrayList<Assignment_CRM>();
        assignmentRepositoryInterface = (AssignmentRepositoryInterface) new AssignmentRepository(listAssignments);
        assignmentServiceInterface = (AssignmentServiceInterface) new AssignmentService(assignmentRepositoryInterface);

        Assignment_CRM assignment;

        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_ASSIGNMENT_ADD:
                assignment = new Assignment_CRM();
                assignment.setAssignment_Name(request.getParameter(Constants.ASSIGNMENT_CRM_NAME));
                assignment.setAssignment_Start_Date(request.getParameter(Constants.ASSIGNMENT_CRM_START_DATE));
                assignment.setAssignment_End_Date(request.getParameter(Constants.ASSIGNMENT_CRM_END_DATE));

                // Default status value for new assignment is Constants.ASSIGNMENT_STILL
                assignment.setAssignment_Status(Constants.ASSIGNMENT_STILL);
                assignment.setAssignment_Project_ID(Integer.parseInt(request.getParameter(Constants.ASSIGNMENT_CRM_PROJECT_ID)));
                assignment.setAssignment_User_ID(Integer.parseInt(request.getParameter(Constants.ASSIGNMENT_CRM_USER_ID)));

                // Execute add query
                System.out.println(assignment.getAssignment_Name());
                assignmentServiceInterface.addNewAssignment(assignment);

                response.sendRedirect(request.getContextPath() + Constants.URL_ASSIGNMENT);
                break;

            default:
                break;
        }
    }
}
