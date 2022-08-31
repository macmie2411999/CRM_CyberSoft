package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;

import java.util.List;

public interface ProjectServiceInterface {
    List<Project_CRM> getAllProjects();
    void addNewProject(Project_CRM newProject);
    void deleteProjectsByID(String projectID);
    Project_CRM getProjectByID(String projectID);
}
