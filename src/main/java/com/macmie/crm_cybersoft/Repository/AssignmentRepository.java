package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Connection.MySQLConnectionConfiguration;
import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AssignmentRepository implements AssignmentRepositoryInterface {
    List<Assignment_CRM> listAssignments;

    public AssignmentRepository(List<Assignment_CRM> listAssignments) {
        this.listAssignments = listAssignments;
    }

    @Override
    public List<Assignment_CRM> getAllAssignments() {
        try {
            String query = "SELECT * FROM Assignment_CRM";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
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
//            System.out.println("Assignment of User SQL: " + listAssignments.size());
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
        return listAssignments;
    }

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

    @Override
    public List<Assignment_CRM> getAllAssignmentsByUserID(String userID) {
        try {
            String query = "SELECT * FROM Assignment_CRM WHERE Assignment_User_ID = ?";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            statement.setString(1, userID);
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

    @Override
    public List<Assignment_CRM> getAllAssignmentsByProjectID(String projectID) {
        try {
            String query = "SELECT * FROM Assignment_CRM WHERE Assignment_Project_ID = ?";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            statement.setString(1, projectID);
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

    @Override
    public void deleteAssignmentsByID(String assignmentID) {
        try {
            String query = "DELETE FROM Assignment_CRM WHERE Assignment_ID = ?";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            statement.setString(1, assignmentID);

            int resultSet = statement.executeUpdate();

            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
    }

    @Override
    public void addNewAssignment(Assignment_CRM newAssignment) {
        try {
            String query = "INSERT INTO Assignment_CRM (Assignment_Name, Assignment_Start_Date, Assignment_End_Date, Assignment_Status, Assignment_Project_ID, Assignment_User_ID) VALUES (?, ?, ?, ?, ?,?)";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            statement.setString(1, newAssignment.getAssignment_Name());
            statement.setString(2, newAssignment.getAssignment_Start_Date());
            statement.setString(3, newAssignment.getAssignment_End_Date());
            statement.setString(4, newAssignment.getAssignment_Status());
            statement.setInt(5, newAssignment.getAssignment_Project_ID());
            statement.setInt(6, newAssignment.getAssignment_User_ID());

            int resultSet = statement.executeUpdate();

            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
    }

    @Override
    public void updateAssignmentByID(Assignment_CRM updateAssignment, int assignmentID) {
        try {
            String query = "UPDATE Assignment_CRM SET Assignment_Name = ?, Assignment_Start_Date = ?, Assignment_End_Date = ?, Assignment_Status = ?, Assignment_Project_ID = ? WHERE Assignment_ID = ?";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();
            PreparedStatement statement = connectionMySQL.prepareStatement(query);

            statement.setString(1, updateAssignment.getAssignment_Name());
            statement.setString(2, updateAssignment.getAssignment_Start_Date());
            statement.setString(3, updateAssignment.getAssignment_End_Date());
            statement.setString(4, updateAssignment.getAssignment_Status());
            statement.setInt(5, updateAssignment.getAssignment_Project_ID());
            statement.setInt(6, assignmentID);

            int result = statement.executeUpdate();
            if(result < 1) {
                System.out.println("Update Assignment with ID: " + assignmentID + " unsuccessfully.");
            }
            connectionMySQL.close();
        } catch (Exception e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
    }
}
