package com.macmie.crm_cybersoft.Controller;

import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.DTO.AssignmentUserRole;
import com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.Role_CRM;
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
        Constants.URL_USER,
        Constants.URL_USER_ADD,
        Constants.URL_USER_DELETE,
        Constants.URL_USER_DETAILS})
public class UserController extends HttpServlet {
    List<AssignmentUserRole> listAssignmentUserRole;
    AUR_DTO_RepositoryInterface aur_dto_repositoryInterface;
    AUR_DTO_ServiceInterface aur_dto_serviceInterface;

    UserRepositoryInterface userRepositoryInterface;
    UserServiceInterface userServiceInterface;

    AssignmentRepositoryInterface assignmentRepositoryInterface;
    AssignmentServiceInterface assignmentServiceInterface;

    List<Role_CRM> listRoles;
    RoleRepositoryInterface roleRepositoryInterface;
    RoleServiceInterface roleServiceInterface;

    List<Project_CRM> listProjects;
    List<Assignment_CRM> listAssignments;
    List<Assignment_CRM> listAssignmentsTemp;
    List<Assignment_CRM> listAssignmentsTemp2;
    List<User_CRM> listUsers;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // New Obs
        listAssignmentUserRole = new ArrayList<AssignmentUserRole>();
        aur_dto_repositoryInterface = (AUR_DTO_RepositoryInterface) new AUR_DTO_Repository(listAssignmentUserRole);
        aur_dto_serviceInterface = (AUR_DTO_ServiceInterface) new AUR_DTO_Service(aur_dto_repositoryInterface);

        listUsers = new ArrayList<User_CRM>();
        userRepositoryInterface = (UserRepositoryInterface) new UserRepository(listUsers);
        userServiceInterface = (UserServiceInterface) new UserService(userRepositoryInterface);

        listRoles = new ArrayList<Role_CRM>();
        roleRepositoryInterface = (RoleRepositoryInterface) new RoleRepository(listRoles);
        roleServiceInterface = (RoleServiceInterface) new RoleService(roleRepositoryInterface);

        listAssignments = new ArrayList<Assignment_CRM>();
        assignmentRepositoryInterface = (AssignmentRepositoryInterface) new AssignmentRepository( listAssignments);
        assignmentServiceInterface = (AssignmentServiceInterface) new AssignmentService(assignmentRepositoryInterface);

        Integer userID;

        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_USER:
                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_AUR_DTO, aur_dto_serviceInterface.getAllAssignmentUserRole());
                request.setAttribute(Constants.LIST_USERS, userServiceInterface.getAllUsers());

                request.getRequestDispatcher(Constants.USER_TABLE_JSP).forward(request, response);
                break;

            case Constants.URL_USER_ADD:
                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_AUR_DTO, aur_dto_serviceInterface.getAllAssignmentUserRole());
                request.setAttribute(Constants.LIST_ROLES, roleServiceInterface.getAllRoles());

                request.getRequestDispatcher(Constants.USER_ADD_JSP).forward(request, response);
                break;

            case Constants.URL_USER_DETAILS:

                // Get User ID from request
                userID = Integer.valueOf(request.getParameter(Constants.JUST_ID));

                // Get all assignments of selected user
                List<Assignment_CRM> listAssignmentsOfSelectedUser = assignmentServiceInterface.getAllAssignmentsByUserID(String.valueOf(userID));

                // Set attributes and forward to View
                // Check if user have any assignments
                if(listAssignmentsOfSelectedUser.size()==0){
                    System.out.println("User have no Assignments");
                    response.sendRedirect(request.getContextPath() + Constants.URL_USER);
                } else{
                    request.setAttribute(Constants.SELECTED_USE, userServiceInterface.getUserById(userID));
                    request.setAttribute(Constants.LIST_USER_ASSIGNMENTS, listAssignmentsOfSelectedUser);
                    request.setAttribute(Constants.LIST_COMPLETED_ASSIGNMENTS, assignmentServiceInterface.getAllAssignmentsByStatus(listAssignmentsOfSelectedUser, Constants.ASSIGNMENT_COMPLETED));
                    request.setAttribute(Constants.LIST_PROCESSING_ASSIGNMENTS, assignmentServiceInterface.getAllAssignmentsByStatus(listAssignmentsOfSelectedUser, Constants.ASSIGNMENT_PROCESSING));
                    request.setAttribute(Constants.LIST_STILL_ASSIGNMENTS, assignmentServiceInterface.getAllAssignmentsByStatus(listAssignmentsOfSelectedUser, Constants.ASSIGNMENT_STILL));
                    request.getRequestDispatcher(Constants.USER_DETAILS_JSP).forward(request, response);
//                    response.sendRedirect(request.getContextPath() + Constants.USER_DETAILS_JSP);
                }
                break;

            case Constants.URL_USER_DELETE:
                // Remove Assignment by ID using AssignmentServiceInterface
                userServiceInterface.removeUserById(Integer.parseInt(request.getParameter(Constants.JUST_ID)));

                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_AUR_DTO, aur_dto_serviceInterface.getAllAssignmentUserRole());

                response.sendRedirect(request.getContextPath() + Constants.URL_USER);

                break;

            default:
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // New Obs
        listAssignmentUserRole = new ArrayList<AssignmentUserRole>();
        aur_dto_repositoryInterface = (AUR_DTO_RepositoryInterface) new AUR_DTO_Repository(listAssignmentUserRole);
        aur_dto_serviceInterface = (AUR_DTO_ServiceInterface) new AUR_DTO_Service(aur_dto_repositoryInterface);

        listUsers = new ArrayList<User_CRM>();
        userRepositoryInterface = (UserRepositoryInterface) new UserRepository(listUsers);
        userServiceInterface = (UserServiceInterface) new UserService(userRepositoryInterface);

        listRoles = new ArrayList<Role_CRM>();
        roleRepositoryInterface = (RoleRepositoryInterface) new RoleRepository(listRoles);
        roleServiceInterface = (RoleServiceInterface) new RoleService(roleRepositoryInterface);

        User_CRM user;
        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        switch (servletPath) {
            case Constants.URL_USER_ADD:
                user = new User_CRM();
                user.setUser_Name(request.getParameter(Constants.USER_CRM_NAME));
                user.setUser_Email(request.getParameter(Constants.USER_CRM_EMAIL));
                user.setUser_Password(request.getParameter(Constants.USER_CRM_PASSWORD));
                user.setUser_Role_ID(Integer.parseInt(request.getParameter(Constants.USER_CRM_ROLE_ID)));

                // Execute add query
                System.out.println(user.getUser_Name());
                userServiceInterface.addUser(user);

                response.sendRedirect(request.getContextPath() + Constants.URL_USER);
                break;

            default:
                break;
        }
    }
}
