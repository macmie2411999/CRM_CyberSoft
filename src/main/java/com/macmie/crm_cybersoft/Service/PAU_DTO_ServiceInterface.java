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
}
