package com.macmie.crm_cybersoft.Controller;

import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Repository.AssignmentRepository;
import com.macmie.crm_cybersoft.Repository.AssignmentRepositoryInterface;
import com.macmie.crm_cybersoft.Service.AssignmentService;
import com.macmie.crm_cybersoft.Service.AssignmentServiceInterface;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(Constants.URL_HOME)
public class HomeController extends HttpServlet {
    AssignmentRepositoryInterface assignmentRepositoryInterface = (AssignmentRepositoryInterface) new AssignmentRepository();
    AssignmentServiceInterface assignmentServiceInterface = (AssignmentServiceInterface) new AssignmentService(assignmentRepositoryInterface);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get lists of required assignments
        List<Assignment_CRM> listCompletedAssignments = assignmentServiceInterface.getAllAssignmentsByName(Constants.ASSIGNMENT_COMPLETED);
        List<Assignment_CRM> listProcessingAssignments = assignmentServiceInterface.getAllAssignmentsByName(Constants.ASSIGNMENT_PROCESSING);
        List<Assignment_CRM> listStillAssignments = assignmentServiceInterface.getAllAssignmentsByName(Constants.ASSIGNMENT_STILL);

        // Get number of assignments in each list
        request.setAttribute(Constants.ASSIGNMENT_COMPLETED, listCompletedAssignments.size());
        request.setAttribute(Constants.ASSIGNMENT_PROCESSING, listProcessingAssignments.size());
        request.setAttribute(Constants.ASSIGNMENT_STILL, listStillAssignments.size());

        RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.HOME_JSP);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.HOME_JSP);
        dispatcher.forward(request, response);
    }
}
