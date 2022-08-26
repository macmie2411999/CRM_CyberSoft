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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(Constants.URL_HOME)
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Assignment_CRM> listAssignments = new ArrayList<Assignment_CRM>();
        AssignmentRepositoryInterface assignmentRepositoryInterface = (AssignmentRepositoryInterface) new AssignmentRepository(listAssignments);
        AssignmentServiceInterface assignmentServiceInterface =
                (AssignmentServiceInterface) new AssignmentService(assignmentRepositoryInterface);

        // Get lists of required assignments
        listAssignments = assignmentServiceInterface.getAllAssignments();

        // Save listAssignments to Session
//        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(10000);
//        session.setAttribute(Constants.SESSION_LIST_ASSIGNMENTS, listAssignments);


        // Get number of assignments in each list and set attributes to View
        request.setAttribute(Constants.ASSIGNMENT_COMPLETED,
                assignmentServiceInterface.getNumbersOfSelectedAssignments(listAssignments, Constants.ASSIGNMENT_COMPLETED));
        request.setAttribute(Constants.ASSIGNMENT_PROCESSING,
                assignmentServiceInterface.getNumbersOfSelectedAssignments(listAssignments, Constants.ASSIGNMENT_PROCESSING));
        request.setAttribute(Constants.ASSIGNMENT_STILL,
                assignmentServiceInterface.getNumbersOfSelectedAssignments(listAssignments, Constants.ASSIGNMENT_STILL));

        RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.HOME_JSP);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(Constants.HOME_JSP);
        dispatcher.forward(request, response);
    }
}
