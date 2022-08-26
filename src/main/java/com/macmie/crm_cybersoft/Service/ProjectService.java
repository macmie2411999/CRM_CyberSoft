package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Repository.AssignmentRepositoryInterface;
import com.macmie.crm_cybersoft.Repository.ProjectRepositoryInterface;

import java.util.List;

public class ProjectService implements ProjectServiceInterface {
    ProjectRepositoryInterface projectRepositoryInterface;

    // Constructor
    public ProjectService(ProjectRepositoryInterface projectRepositoryInterface) {
        this.projectRepositoryInterface = projectRepositoryInterface;
    }

    @Override
    public List<Project_CRM> getAllProjects() {
        return projectRepositoryInterface.getAllProjects();
    }
}
