package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Connection.MySQLConnectionConfiguration;
import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.DTO.AssignmentUserRole;
import com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PAU_DTO_Repository implements PAU_DTO_RepositoryInterface {
    List<ProjectAssignmentUser> listProjectAssignmentUser;

    public PAU_DTO_Repository(List<ProjectAssignmentUser> listProjectAssignmentUser) {
        this.listProjectAssignmentUser = listProjectAssignmentUser;
    }

    @Override
    public List<ProjectAssignmentUser> getAllProjectAssignmentUser() {
        try {
            String query = "SELECT * FROM (Project_CRM INNER JOIN Assignment_CRM ON Project_CRM.Project_ID = Assignment_CRM.Assignment_Project_ID) INNER JOIN User_CRM ON Assignment_CRM.Assignment_User_ID = User_CRM.User_ID;";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                ProjectAssignmentUser projectAssignmentUser = new ProjectAssignmentUser();
                projectAssignmentUser.setAssignment_Project_ID(resultSet.getInt(Constants.PROJECT_CRM_ID));
                projectAssignmentUser.setProject_Name(resultSet.getString(Constants.PROJECT_CRM_NAME));
                projectAssignmentUser.setProject_Start_Date(resultSet.getString(Constants.PROJECT_CRM_START_DATE));
                projectAssignmentUser.setProject_End_Date(resultSet.getString(Constants.PROJECT_CRM_END_DATE));
                projectAssignmentUser.setAssignment_ID(resultSet.getInt(Constants.ASSIGNMENT_CRM_ID));
                projectAssignmentUser.setAssignment_Name(resultSet.getString(Constants.ASSIGNMENT_CRM_NAME));
                projectAssignmentUser.setAssignment_Start_Date(resultSet.getString(Constants.ASSIGNMENT_CRM_START_DATE));
                projectAssignmentUser.setAssignment_End_Date(resultSet.getString(Constants.ASSIGNMENT_CRM_END_DATE));
                projectAssignmentUser.setAssignment_Status(resultSet.getString(Constants.ASSIGNMENT_CRM_STATUS));
                projectAssignmentUser.setAssignment_User_ID(resultSet.getInt(Constants.USER_CRM_ID));
                projectAssignmentUser.setUser_Name(resultSet.getString(Constants.USER_CRM_NAME));
                projectAssignmentUser.setUser_Email(resultSet.getString(Constants.USER_CRM_EMAIL));
                projectAssignmentUser.setUser_Password(resultSet.getString(Constants.USER_CRM_PASSWORD));
                projectAssignmentUser.setUser_Role_ID(resultSet.getInt(Constants.USER_CRM_ROLE_ID));

                listProjectAssignmentUser.add(projectAssignmentUser);
            }
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
        return listProjectAssignmentUser;

    }
}
