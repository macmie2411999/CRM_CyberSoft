package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;

import java.util.List;

public interface PAU_DTO_ServiceInterface {
    List<ProjectAssignmentUser> getAllProjectAssignmentUser();
    List<Project_CRM> getAllProjects();
    List<Assignment_CRM> getAllAssignments();
    List<User_CRM> getAllUsers();
    List<ProjectAssignmentUser> getAll_PAU_By_ProjectID(List<ProjectAssignmentUser> listPAU, String projectID);
    List<ProjectAssignmentUser> getAll_PAU_By_UserID(List<ProjectAssignmentUser> listPAU, String userID);
    List<ProjectAssignmentUser> getAll_PAU_By_statusAssignment(List<ProjectAssignmentUser> listPAU, String statusAssignment);
    ProjectAssignmentUser get_PAU_By_assignmentID(List<ProjectAssignmentUser> listPAU, String assignmentID);
}
