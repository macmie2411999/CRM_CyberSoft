package com.macmie.crm_cybersoft.Controller;

import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.Role_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;
import com.macmie.crm_cybersoft.Repository.ProjectRepository;
import com.macmie.crm_cybersoft.Repository.ProjectRepositoryInterface;
import com.macmie.crm_cybersoft.Repository.RoleRepository;
import com.macmie.crm_cybersoft.Repository.RoleRepositoryInterface;
import com.macmie.crm_cybersoft.Service.ProjectService;
import com.macmie.crm_cybersoft.Service.ProjectServiceInterface;
import com.macmie.crm_cybersoft.Service.RoleService;
import com.macmie.crm_cybersoft.Service.RoleServiceInterface;

import javax.management.relation.Role;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {
        Constants.URL_ROLE,
        Constants.URL_ROLE_ADD,
        Constants.URL_ROLE_DELETE})
public class RoleController extends HttpServlet {

    List<Role_CRM> listRoles;
    RoleRepositoryInterface roleRepositoryInterface;
    RoleServiceInterface roleServiceInterface;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        // New Obs
        listRoles = new ArrayList<Role_CRM>();
        roleRepositoryInterface = (RoleRepositoryInterface) new RoleRepository(listRoles);
        roleServiceInterface = (RoleServiceInterface) new RoleService(roleRepositoryInterface);

        switch (servletPath) {
            case Constants.URL_ROLE:
                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_ROLES, roleServiceInterface.getAllRoles());

                request.getRequestDispatcher(Constants.ROLE_TABLE_JSP).forward(request, response);
                break;

            case Constants.URL_ROLE_ADD:
                request.getRequestDispatcher(Constants.ROLE_ADD_JSP).forward(request, response);
                break;

            case Constants.URL_ROLE_DELETE:
                // Remove Assignment by ID using AssignmentServiceInterface
                roleServiceInterface.deleteRoleByID(request.getParameter(Constants.JUST_ID));

                // Set attributes and forward to View
                request.setAttribute(Constants.LIST_ROLES, roleServiceInterface.getAllRoles());

                response.sendRedirect(request.getContextPath() + Constants.URL_ROLE);
//                request.getRequestDispatcher(Constants.ROLE_TABLE_JSP).forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // New Obs
        listRoles = new ArrayList<Role_CRM>();
        roleRepositoryInterface = (RoleRepositoryInterface) new RoleRepository(listRoles);
        roleServiceInterface = (RoleServiceInterface) new RoleService(roleRepositoryInterface);

        // Get URL to forward/direct page
        String servletPath = request.getServletPath();

        Role_CRM role;
        switch (servletPath) {
            case Constants.URL_ROLE_ADD:
                role = new Role_CRM();
                role.setRole_Name(request.getParameter(Constants.ROLE_CRM_NAME));
                role.setRole_Description(request.getParameter(Constants.ROLE_CRM_DESCRIPTION));

                // Execute add query
                System.out.println(role.getRole_Name());
                roleServiceInterface.addNewRole(role);

                response.sendRedirect(request.getContextPath() + Constants.URL_ROLE);
                break;

            default:
                break;
        }
    }
}
