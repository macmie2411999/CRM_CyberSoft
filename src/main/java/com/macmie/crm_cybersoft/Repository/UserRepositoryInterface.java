package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Pojo.User_CRM;

public interface UserRepositoryInterface {
    // List methods of UserRepository
    User_CRM getUserLogin(String email, String password);

    User_CRM getUserById(int ID);

    void addUser(User_CRM userCRM);

    void removeUserById(int ID);


}
