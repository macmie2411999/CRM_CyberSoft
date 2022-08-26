package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Connection.MySQLConnectionConfiguration;
import com.macmie.crm_cybersoft.Constants.Constants;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.Role_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements UserRepositoryInterface {
    List<User_CRM> listUsers;

    public UserRepository(List<User_CRM> listUsers) {
        this.listUsers = listUsers;
    }

    // Query data of user login from Database and return to UserService
    @Override
    public User_CRM getUserLogin(String email, String password) {
        try {
            String query = "SELECT * FROM User_CRM WHERE User_Email = ? AND User_Password = ?";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User_CRM userCMR = new User_CRM();
                userCMR.setUser_ID(resultSet.getInt(Constants.USER_CRM_ID));
                userCMR.setUser_Name(resultSet.getString(Constants.USER_CRM_NAME));
                userCMR.setUser_Email(resultSet.getString(Constants.USER_CRM_EMAIL));
                userCMR.setUser_Password(resultSet.getString(Constants.USER_CRM_PASSWORD));
                userCMR.setUser_Role_ID(resultSet.getInt(Constants.USER_CRM_ROLE_ID));
                return userCMR;
            }
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
        return null;
    }

    @Override
    public User_CRM getUserById(int ID) {
        try {
            String query = "SELECT * FROM User_CRM WHERE User_ID = ?";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            statement.setInt(1, ID);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                User_CRM userCMR = new User_CRM();
                userCMR.setUser_ID(resultSet.getInt(Constants.USER_CRM_ID));
                userCMR.setUser_Name(resultSet.getString(Constants.USER_CRM_NAME));
                userCMR.setUser_Email(resultSet.getString(Constants.USER_CRM_EMAIL));
                userCMR.setUser_Password(resultSet.getString(Constants.USER_CRM_PASSWORD));
                userCMR.setUser_Role_ID(resultSet.getInt(Constants.USER_CRM_ROLE_ID));
                return userCMR;
            }
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
        return null;
    }

    @Override
    public List<User_CRM> getAllUsers() {
        try {
            String query = "SELECT * FROM User_CRM";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                User_CRM user = new User_CRM();
                user.setUser_ID(resultSet.getInt(Constants.USER_CRM_ID));
                user.setUser_Name(resultSet.getString(Constants.USER_CRM_NAME));
                user.setUser_Email(resultSet.getString(Constants.USER_CRM_EMAIL));
                user.setUser_Password(resultSet.getString(Constants.USER_CRM_PASSWORD));
                user.setUser_Role_ID(resultSet.getInt(Constants.USER_CRM_ROLE_ID));

                listUsers.add(user);
            }
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
        return listUsers;
    }

    @Override
    public void addUser(User_CRM userCRM) {
        try {
            String query = "INSERT INTO User_CRM (User_Name, User_Email, User_Password, User_Role_ID) VALUES (?, ?, ?, ?);";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);

            statement.setString(1, userCRM.getUser_Name());
            statement.setString(2, userCRM.getUser_Email());
            statement.setString(3, userCRM.getUser_Password());
            statement.setInt(4, userCRM.getUser_Role_ID());

            statement.executeUpdate();
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
    }

    @Override
    public void removeUserById(int ID) {
        try {
            String query = "DELETE FROM User_CRM WHERE User_Role_ID = ?";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            statement.setInt(1, ID);
            statement.executeUpdate();
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
    }
}
