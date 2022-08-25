package com.macmie.crm_cybersoft.Pojo;

public class Role_CRM {
    private int Role_ID;
    private String Role_Name;
    private String Role_Description;

    public Role_CRM() {
    }

    public Role_CRM(int role_ID, String role_Name, String role_Description) {
        Role_ID = role_ID;
        Role_Name = role_Name;
        Role_Description = role_Description;
    }

    public int getRole_ID() {
        return Role_ID;
    }

    public void setRole_ID(int role_ID) {
        Role_ID = role_ID;
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
}
