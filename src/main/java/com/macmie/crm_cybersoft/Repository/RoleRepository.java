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

public class RoleRepository implements RoleRepositoryInterface{
    List<Role_CRM> listRoles = new ArrayList<Role_CRM>();

    @Override
    public List<Role_CRM> getAllRoles() {
        try {
            String query = "SELECT * FROM Role_CRM";
            Connection connectionMySQL = MySQLConnectionConfiguration.getConnection();

            PreparedStatement statement = connectionMySQL.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Role_CRM role = new Role_CRM();
                role.setRole_ID(resultSet.getInt(Constants.ROLE_CRM_ID));
                role.setRole_Name(resultSet.getString(Constants.ROLE_CRM_NAME));
                role.setRole_Description(resultSet.getString(Constants.ROLE_CRM_DESCRIPTION));

                listRoles.add(role);
            }
            connectionMySQL.close();
        } catch (SQLException e) {
            System.out.println(Constants.ERROR_QUERY_DATA_FROM_MYSQL + e.getMessage());
        }
        return listRoles;
    }
}
