package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Connection.MySQLConnectionConfiguration;
import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AssignmentRepository implements AssignmentRepositoryInterface {
    List<Assignment_CRM> listAssignments = new ArrayList<Assignment_CRM>();

    @Override
    public List<Assignment_CRM> getAllAssignmentsByName(String assignmentName) {
        try {
            String query = "SELECT * FROM Assignment_CRM WHERE Assignment_Status = ?";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            statement.setString(1, assignmentName);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Assignment_CRM assignment = new Assignment_CRM();
                assignment.setAssignment_ID(resultSet.getInt(Constants.ASSIGNMENT_CRM_ID));
                assignment.setAssignment_Name(resultSet.getString(Constants.ASSIGNMENT_CRM_NAME));
                assignment.setAssignment_Start_Date(resultSet.getString(Constants.ASSIGNMENT_CRM_START_DATE));
                assignment.setAssignment_End_Date(resultSet.getString(Constants.ASSIGNMENT_CRM_END_DATE));
                assignment.setAssignment_Status(resultSet.getString(Constants.ASSIGNMENT_CRM_STATUS));
                assignment.setAssignment_Project_ID(resultSet.getInt(Constants.ASSIGNMENT_CRM_PROJECT_ID));
                assignment.setAssignment_ID(resultSet.getInt(Constants.ASSIGNMENT_CRM_USER_ID));

                listAssignments.add(assignment);
            }
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
        return listAssignments;
    }
}
