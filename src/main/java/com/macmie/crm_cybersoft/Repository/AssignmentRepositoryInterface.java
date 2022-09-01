package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;

import java.util.List;

public interface AssignmentRepositoryInterface {
    List<Assignment_CRM> getAllAssignments();
    List<Assignment_CRM> getAllAssignmentsByName(String assignmentName);
    List<Assignment_CRM> getAllAssignmentsByUserID(String userID);
    List<Assignment_CRM> getAllAssignmentsByProjectID(String projectID);
    void deleteAssignmentsByID(String assignmentID);
    void addNewAssignment(Assignment_CRM newAssignment);
    public void updateAssignmentByID(Assignment_CRM updateAssignment, int assignmentID);
}
