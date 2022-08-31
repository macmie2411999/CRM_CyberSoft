package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Repository.AssignmentRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class AssignmentService implements AssignmentServiceInterface {
    AssignmentRepositoryInterface assignmentRepositoryInterface;

    // Constructor
    public AssignmentService(AssignmentRepositoryInterface assignmentRepositoryInterface) {
        this.assignmentRepositoryInterface = assignmentRepositoryInterface;
    }

    @Override
    public List<Assignment_CRM> getAllAssignments() {
        return assignmentRepositoryInterface.getAllAssignments();
    }

    @Override
    public Integer getNumbersOfSelectedAssignments(List<Assignment_CRM> listAssignmentsCRM, String assignmentStatus) {
        Integer result = 0;

        // Counts number of assignments matching required status
        for(Assignment_CRM element: listAssignmentsCRM){
            if(element.getAssignment_Status().equals(assignmentStatus)){
                result++;
            }
        }
        return result;
    }

    @Override
    public List<Assignment_CRM> getAllAssignmentsByName(String assignmentName) {
        return assignmentRepositoryInterface.getAllAssignmentsByName(assignmentName);
    }

    @Override
    public List<Assignment_CRM> getAllAssignmentsByStatus(List<Assignment_CRM> listAssignmentsCRM, String assignmentStatus) {
        List<Assignment_CRM> listAssignmentsByStatus = new ArrayList<Assignment_CRM>();

        // Counts number of assignments matching required status
        for(Assignment_CRM element: listAssignmentsCRM){
            if(element.getAssignment_Status().equals(assignmentStatus)){
                listAssignmentsByStatus.add(element);
            }
        }
        return listAssignmentsByStatus;
    }

    @Override
    public List<Assignment_CRM> getAllAssignmentsByUserID(List<Assignment_CRM> listAssignmentsCRM, Integer userID) {
        List<Assignment_CRM> listAssignmentsByUserID = new ArrayList<Assignment_CRM>();

        // Counts number of assignments matching required status
        for(Assignment_CRM element: listAssignmentsCRM){
            if(element.getAssignment_User_ID() == userID){
                listAssignmentsByUserID.add(element);
                System.out.println(element.getAssignment_Name());
            }
        }
        return listAssignmentsByUserID;
    }

    @Override
    public List<Assignment_CRM> getAllAssignmentsByUserID(String userID) {
        return assignmentRepositoryInterface.getAllAssignmentsByUserID(userID);
    }

    @Override
    public List<Assignment_CRM> getAllAssignmentsByProjectID(String projectID) {
        return assignmentRepositoryInterface.getAllAssignmentsByProjectID(projectID);
    }

    @Override
    public void deleteAssignmentsByID(String assignmentID) {
        assignmentRepositoryInterface.deleteAssignmentsByID(assignmentID);
    }

    @Override
    public void addNewAssignment(Assignment_CRM newAssignment) {
        assignmentRepositoryInterface.addNewAssignment(newAssignment);
    }
}
