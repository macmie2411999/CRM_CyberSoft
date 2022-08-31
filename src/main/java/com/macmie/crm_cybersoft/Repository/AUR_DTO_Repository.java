package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Connection.MySQLConnectionConfiguration;
import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.DTO.AssignmentUserRole;
import com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AUR_DTO_Repository implements AUR_DTO_RepositoryInterface {
    List<AssignmentUserRole> listAssignmentUserRole;

    public AUR_DTO_Repository(List<AssignmentUserRole> listAssignmentUserRole) {
        this.listAssignmentUserRole = listAssignmentUserRole;
    }

    @Override
    public List<AssignmentUserRole> getAllAssignmentUserRole() {
        try {
            String query = "SELECT * FROM (User_CRM LEFT JOIN Assignment_CRM ON Assignment_CRM.Assignment_User_ID = User_CRM.User_ID) INNER JOIN Role_CRM ON User_CRM.User_Role_ID = Role_CRM.Role_ID";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                AssignmentUserRole assignmentUserRole = new AssignmentUserRole();
                assignmentUserRole.setUser_ID(resultSet.getInt(Constants.USER_CRM_ID));
                assignmentUserRole.setUser_Name(resultSet.getString(Constants.USER_CRM_NAME));
                assignmentUserRole.setUser_Email(resultSet.getString(Constants.USER_CRM_EMAIL));
                assignmentUserRole.setUser_Password(resultSet.getString(Constants.USER_CRM_PASSWORD));
                assignmentUserRole.setUser_Role_ID(resultSet.getInt(Constants.USER_CRM_ROLE_ID));
                assignmentUserRole.setRole_Name(resultSet.getString(Constants.ROLE_CRM_NAME));
                assignmentUserRole.setRole_Description(resultSet.getString(Constants.ROLE_CRM_DESCRIPTION));
                assignmentUserRole.setAssignment_ID(resultSet.getInt(Constants.ASSIGNMENT_CRM_ID));
                assignmentUserRole.setAssignment_Name(resultSet.getString(Constants.ASSIGNMENT_CRM_NAME));
                assignmentUserRole.setAssignment_Start_Date(resultSet.getString(Constants.ASSIGNMENT_CRM_START_DATE));
                assignmentUserRole.setAssignment_End_Date(resultSet.getString(Constants.ASSIGNMENT_CRM_END_DATE));
                assignmentUserRole.setAssignment_Status(resultSet.getString(Constants.ASSIGNMENT_CRM_STATUS));

                listAssignmentUserRole.add(assignmentUserRole);
            }
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
        return listAssignmentUserRole;

    }
}
