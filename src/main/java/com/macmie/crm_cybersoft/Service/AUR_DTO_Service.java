package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.DTO.AssignmentUserRole;
import com.macmie.crm_cybersoft.Repository.AUR_DTO_RepositoryInterface;
import com.macmie.crm_cybersoft.Repository.AssignmentRepositoryInterface;

import java.util.List;

public class AUR_DTO_Service implements AUR_DTO_ServiceInterface{
    AUR_DTO_RepositoryInterface aur_dto_repositoryInterface;

    // Constructor
    public AUR_DTO_Service(AUR_DTO_RepositoryInterface aur_dto_repositoryInterface) {
        this.aur_dto_repositoryInterface = aur_dto_repositoryInterface;
    }

    @Override
    public List<AssignmentUserRole> getAllAssignmentUserRole() {
        return aur_dto_repositoryInterface.getAllAssignmentUserRole();
    }
}
