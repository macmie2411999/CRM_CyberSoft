package com.macmie.crm_cybersoft.DTO;

public class AssignmentUserRole {
    private int User_ID;
    private String User_Name;
    private String User_Email;
    private String User_Password;
    private int User_Role_ID;
    private String Role_Name;
    private String Role_Description;
    private int Assignment_ID;
    private String Assignment_Name;
    private String Assignment_Start_Date;
    private String Assignment_End_Date;
    private String Assignment_Status;

    public AssignmentUserRole() {
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

    public String getRole_Name() {
        return Role_Name;
    }

    public void setRole_Name(String role_Name) {
        Role_Name = role_Name;
    }

    public String getRole_Description() {
        return Role_Description;
    }

    public void setRole_Description(String role_Description) {
        Role_Description = role_Description;
    }

    public int getAssignment_ID() {
        return Assignment_ID;
    }

    public void setAssignment_ID(int assignment_ID) {
        Assignment_ID = assignment_ID;
    }

    public String getAssignment_Name() {
        return Assignment_Name;
    }

    public void setAssignment_Name(String assignment_Name) {
        Assignment_Name = assignment_Name;
    }

    public String getAssignment_Start_Date() {
        return Assignment_Start_Date;
    }

    public void setAssignment_Start_Date(String assignment_Start_Date) {
        Assignment_Start_Date = assignment_Start_Date;
    }

    public String getAssignment_End_Date() {
        return Assignment_End_Date;
    }

    public void setAssignment_End_Date(String assignment_End_Date) {
        Assignment_End_Date = assignment_End_Date;
    }

    public String getAssignment_Status() {
        return Assignment_Status;
    }

    public void setAssignment_Status(String assignment_Status) {
        Assignment_Status = assignment_Status;
    }
}
