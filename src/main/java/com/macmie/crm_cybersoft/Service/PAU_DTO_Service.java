package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;
import com.macmie.crm_cybersoft.Repository.PAU_DTO_RepositoryInterface;

import java.util.*;
import java.util.stream.Collectors;

public class PAU_DTO_Service implements PAU_DTO_ServiceInterface {
    PAU_DTO_RepositoryInterface pau_dto_repositoryInterface;

    // Constructor
    public PAU_DTO_Service(PAU_DTO_RepositoryInterface pau_dto_repositoryInterface) {
        this.pau_dto_repositoryInterface = pau_dto_repositoryInterface;
    }

    @Override
    public List<ProjectAssignmentUser> getAllProjectAssignmentUser() {
        List<ProjectAssignmentUser> listProjectAssignmentUser = pau_dto_repositoryInterface.getAllProjectAssignmentUser();

        // Sort elements by ID
        listProjectAssignmentUser.sort((firstAssignment, secondAssignment) -> {
            return firstAssignment.getAssignment_ID() > secondAssignment.getAssignment_ID() ? 1 : -1;
        });
        return listProjectAssignmentUser;
    }

    @Override
    public List<Project_CRM> getAllProjects() {
        // Extract List<Project_CRM> out of List<ProjectAssignmentUser>
        List<ProjectAssignmentUser> listProjectAssignmentUser = pau_dto_repositoryInterface.getAllProjectAssignmentUser();

        List<Project_CRM> listProjects = new ArrayList<Project_CRM>();
        Project_CRM projectElement;
        for (ProjectAssignmentUser element : listProjectAssignmentUser) {
            projectElement = new Project_CRM();
            projectElement.setProject_ID(element.getAssignment_Project_ID());
            projectElement.setProject_Name(element.getProject_Name());
            projectElement.setProject_Start_Date(element.getProject_Start_Date());
            projectElement.setProject_End_Date(element.getProject_End_Date());
            listProjects.add(projectElement);
        }

        // Sort out duplicate elements
        Set<Project_CRM> listProjectsTempt = listProjects.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<Project_CRM>(Comparator.comparing(Project_CRM::getProject_ID))));
        List<Project_CRM> listProjectsFinal = new ArrayList<>(listProjectsTempt);

        // Sort elements by ID
        listProjectsFinal.sort((firstProject, secondProject) -> {
            return firstProject.getProject_ID() > secondProject.getProject_ID() ? 1 : -1;
        });

        // System.out.println("So phan tu: " + listProjectsTempt.size());

        return listProjectsFinal;
    }

    @Override
    public List<Assignment_CRM> getAllAssignments() {

        // Extract List<Assignment_CRM> out of List<ProjectAssignmentUser>
        List<ProjectAssignmentUser> listProjectAssignmentUser = pau_dto_repositoryInterface.getAllProjectAssignmentUser();
        List<Assignment_CRM> listAssignments = new ArrayList<Assignment_CRM>();
        Assignment_CRM assignmentElement;
        for (ProjectAssignmentUser element : listProjectAssignmentUser) {
            assignmentElement = new Assignment_CRM();
            assignmentElement.setAssignment_ID(element.getAssignment_ID());
            assignmentElement.setAssignment_Name(element.getAssignment_Name());
            assignmentElement.setAssignment_Start_Date(element.getAssignment_Start_Date());
            assignmentElement.setAssignment_End_Date(element.getAssignment_End_Date());
            assignmentElement.setAssignment_Status(element.getAssignment_Status());
            assignmentElement.setAssignment_Project_ID(element.getAssignment_Project_ID());
            assignmentElement.setAssignment_User_ID(element.getAssignment_User_ID());
            listAssignments.add(assignmentElement);
        }

        // Sort out duplicate elements
        Set<Assignment_CRM> listAssignmentsTempt = listAssignments.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<Assignment_CRM>(Comparator.comparing(Assignment_CRM::getAssignment_ID))));
        List<Assignment_CRM> listAssignmentsFinal = new ArrayList<>(listAssignmentsTempt);

        // Sort elements by ID
        listAssignmentsFinal.sort((firstAssignment, secondAssignment) -> {
            return firstAssignment.getAssignment_ID() > secondAssignment.getAssignment_ID() ? 1 : -1;
        });

        // System.out.println("So phan tu: " + listProjectsTempt.size());

        return listAssignmentsFinal;
    }

    @Override
    public List<User_CRM> getAllUsers() {
        // Extract List<User_CRM> out of List<ProjectAssignmentUser>
        List<ProjectAssignmentUser> listProjectAssignmentUser = pau_dto_repositoryInterface.getAllProjectAssignmentUser();
        List<User_CRM> listUsers = new ArrayList<User_CRM>();
        User_CRM userElement;
        for (ProjectAssignmentUser element : listProjectAssignmentUser) {
            userElement = new User_CRM();
            userElement.setUser_ID(element.getAssignment_User_ID());
            userElement.setUser_Name(element.getUser_Name());
            userElement.setUser_Email(element.getUser_Email());
            userElement.setUser_Password(element.getUser_Password());
            userElement.setUser_Role_ID(element.getUser_Role_ID());
            listUsers.add(userElement);
        }

        // Sort out duplicate elements
        Set<User_CRM> listUsersTempt = listUsers.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<User_CRM>(Comparator.comparing(User_CRM::getUser_ID))));
        List<User_CRM> listUsersFinal = new ArrayList<>(listUsersTempt);

        // Sort elements by ID
        listUsersFinal.sort((firstUser, secondUser) -> {
            return firstUser.getUser_ID() > secondUser.getUser_ID() ? 1 : -1;
        });

        // System.out.println("So phan tu: " + listProjectsTempt.size());

        return listUsersFinal;
    }
}
