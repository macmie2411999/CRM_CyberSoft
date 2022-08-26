package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.Pojo.User_CRM;

import java.util.List;

public interface UserServiceInterface {
    // List methods of UserService
    User_CRM getUserLogin(String email, String password);

    User_CRM getUserById(int ID);

    void addUser(User_CRM userCRM);

    void removeUserById(int ID);

    List<User_CRM> getAllUsers();
}
