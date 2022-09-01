package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.Pojo.User_CRM;
import com.macmie.crm_cybersoft.Repository.UserRepositoryInterface;

import java.util.List;

public class UserService implements UserServiceInterface {
    UserRepositoryInterface userRepositoryInterface;

    // Constructor
    public UserService(UserRepositoryInterface userRepositoryInterface) {
        this.userRepositoryInterface = userRepositoryInterface;
    }

    // Return data of login user taken from UserRepository to UserController
    @Override
    public User_CRM getUserLogin(String email, String password) {
        return userRepositoryInterface.getUserLogin(email, password);
    }

    @Override
    public void addUser(User_CRM userCRM) {
        userRepositoryInterface.addUser(userCRM);
    }

    @Override
    public void updateUserByID(User_CRM user, int userID) {
        userRepositoryInterface.updateUserByID(user, userID);
    }

    @Override
    public User_CRM getUserById(int ID) {

        return userRepositoryInterface.getUserById(ID);
    }

    @Override
    public void removeUserById(int ID) {
        userRepositoryInterface.removeUserById(ID);
    }

    @Override
    public List<User_CRM> getAllUsers() {
        return userRepositoryInterface.getAllUsers();
    }


}
