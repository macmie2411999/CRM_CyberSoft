package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.Pojo.Role_CRM;
import com.macmie.crm_cybersoft.Repository.RoleRepositoryInterface;
import com.macmie.crm_cybersoft.Repository.UserRepositoryInterface;

import java.util.List;

public class RoleService implements RoleServiceInterface {
    RoleRepositoryInterface roleRepositoryInterface;

    // Constructor
    public RoleService(RoleRepositoryInterface roleRepositoryInterface) {
        this.roleRepositoryInterface = roleRepositoryInterface;
    }

    @Override
    public List<Role_CRM> getAllRoles() {
        return roleRepositoryInterface.getAllRoles();
    }
}
