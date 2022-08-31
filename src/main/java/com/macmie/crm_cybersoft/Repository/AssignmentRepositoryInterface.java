package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;

import java.util.List;

public interface AssignmentRepositoryInterface {
    List<Assignment_CRM> getAllAssignments();
    List<Assignment_CRM> getAllAssignmentsByName(String assignmentName);
    List<Assignment_CRM> getAllAssignmentsByUserID(String userID);
    void deleteAssignmentsByID(String assignmentID);
    void addNewAssignment(Assignment_CRM newAssignment);
}
