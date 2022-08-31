package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.Project_CRM;
import com.macmie.crm_cybersoft.Pojo.Role_CRM;

import java.util.List;

public interface RoleRepositoryInterface {
    List<Role_CRM> getAllRoles();
    void deleteRoleByID(String roleID);
    void addNewRole(Role_CRM newRole);
}
