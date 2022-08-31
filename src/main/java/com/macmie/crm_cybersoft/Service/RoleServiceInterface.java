package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.Pojo.Role_CRM;

import java.util.List;

public interface RoleServiceInterface {
    List<Role_CRM> getAllRoles();
    void deleteRoleByID(String roleID);
    void addNewRole(Role_CRM newRole);
}
