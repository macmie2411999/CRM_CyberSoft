package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;

import java.util.List;

public interface UserRepositoryInterface {
    // List methods of UserRepository
    User_CRM getUserLogin(String email, String password);

    User_CRM getUserById(int ID);

    List<User_CRM> getAllUsers();

    public void updateUserByID(User_CRM user, int userID);

    void addUser(User_CRM userCRM);

    void removeUserById(int ID);

}
