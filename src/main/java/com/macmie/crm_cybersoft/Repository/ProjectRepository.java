package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Connection.MySQLConnectionConfiguration;
import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepository implements ProjectRepositoryInterface{
    List<Project_CRM> listProjects;

    public ProjectRepository(List<Project_CRM> listProjects) {
        this.listProjects = listProjects;
    }

    @Override
    public List<Project_CRM> getAllProjects() {
        try {
            String query = "SELECT * FROM Project_CRM";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Project_CRM project = new Project_CRM();
                project.setProject_ID(resultSet.getInt(Constants.PROJECT_CRM_ID));
                project.setProject_Name(resultSet.getString(Constants.PROJECT_CRM_NAME));
                project.setProject_Start_Date(resultSet.getString(Constants.PROJECT_CRM_START_DATE));
                project.setProject_End_Date(resultSet.getString(Constants.PROJECT_CRM_END_DATE));

                listProjects.add(project);
            }
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
        return listProjects;
    }

    @Override
    public void addNewProject(Project_CRM newProject) {
        try {
            String query = "INSERT INTO Project_CRM (Project_Name, Project_Start_Date, Project_End_Date) VALUES (?, ?, ?)";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            statement.setString(1, newProject.getProject_Name());
            statement.setString(2, newProject.getProject_Start_Date());
            statement.setString(3, newProject.getProject_End_Date());

            int resultSet = statement.executeUpdate();

            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
    }
}
