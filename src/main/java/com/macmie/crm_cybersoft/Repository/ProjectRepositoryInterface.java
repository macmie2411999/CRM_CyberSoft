package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;

import java.util.List;

public interface ProjectRepositoryInterface {
    List<Project_CRM> getAllProjects();
    Project_CRM getProjectByID(String projectID);
    void addNewProject(Project_CRM newProject);
    void deleteProjectsByID(String projectID);
}
