package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;

import java.util.List;

public interface AssignmentServiceInterface {
    List<Assignment_CRM> getAllAssignments();
    Integer getNumbersOfSelectedAssignments(List<Assignment_CRM> listAssignmentsCRM, String assignmentStatus);
    List<Assignment_CRM> getAllAssignmentsByName(String assignmentName);
    List<Assignment_CRM> getAllAssignmentsByStatus(List<Assignment_CRM> listAssignmentsCRM, String assignmentStatus);
    List<Assignment_CRM> getAllAssignmentsByUserID(List<Assignment_CRM> listAssignmentsCRM, Integer userID);
    List<Assignment_CRM> getAllAssignmentsByUserID(String userID);
    List<Assignment_CRM> getAllAssignmentsByProjectID(String projectID);
    void deleteAssignmentsByID(String assignmentID);
    void addNewAssignment(Assignment_CRM newAssignment);
    public void updateAssignmentByID(Assignment_CRM updateAssignment, int assignmentID);
}
