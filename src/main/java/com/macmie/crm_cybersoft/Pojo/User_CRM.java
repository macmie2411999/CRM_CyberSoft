package com.macmie.crm_cybersoft.Pojo;

public class User_CRM {
    private int User_ID;
    private String User_Name;
    private String User_Email;
    private String User_Password;
    private int User_Role_ID;

    public User_CRM() {
    }

    public User_CRM(int user_ID, String user_Name, String user_Email,
                    String user_Password, int user_Role_ID) {
        User_ID = user_ID;
        User_Name = user_Name;
        User_Email = user_Email;
        User_Password = user_Password;
        User_Role_ID = user_Role_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Email() {
        return User_Email;
    }

    public void setUser_Email(String user_Email) {
        User_Email = user_Email;
    }

    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String user_Password) {
        User_Password = user_Password;
    }

    public int getUser_Role_ID() {
        return User_Role_ID;
    }

    public void setUser_Role_ID(int user_Role_ID) {
        User_Role_ID = user_Role_ID;
    }
}
