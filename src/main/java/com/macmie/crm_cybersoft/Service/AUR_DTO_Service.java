package com.macmie.crm_cybersoft.Service;

import com.macmie.crm_cybersoft.DTO.AssignmentUserRole;
import com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser;
import com.macmie.crm_cybersoft.Pojo.Assignment_CRM;
import com.macmie.crm_cybersoft.Pojo.User_CRM;
import com.macmie.crm_cybersoft.Repository.AUR_DTO_RepositoryInterface;
import com.macmie.crm_cybersoft.Repository.AssignmentRepositoryInterface;

import java.util.*;
import java.util.stream.Collectors;

public class AUR_DTO_Service implements AUR_DTO_ServiceInterface{
    AUR_DTO_RepositoryInterface aur_dto_repositoryInterface;

    // Constructor
    public AUR_DTO_Service(AUR_DTO_RepositoryInterface aur_dto_repositoryInterface) {
        this.aur_dto_repositoryInterface = aur_dto_repositoryInterface;
    }

    @Override
    public List<AssignmentUserRole> getAllAssignmentUserRole() {
        List<AssignmentUserRole> listAssignmentUserRole = aur_dto_repositoryInterface.getAllAssignmentUserRole();

        // Sort out duplicate elements
        Set<AssignmentUserRole> listAssignmentUserRoleTempt = listAssignmentUserRole.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<AssignmentUserRole>(Comparator.comparing(AssignmentUserRole::getUser_ID))));
        List<AssignmentUserRole> listAssignmentUserRoleFinal = new ArrayList<>(listAssignmentUserRoleTempt);

        // Sort elements by ID
        listAssignmentUserRoleFinal.sort((firstAUR, secondAUR) -> {
            return firstAUR.getUser_ID() > secondAUR.getUser_ID() ? 1 : -1;
        });

        return listAssignmentUserRoleFinal;
    }

//    @Override
//    public List<Assignment_CRM> getAllAssignments() {
//        return null;
//    }
//
//    @Override
//    public List<Assignment_CRM> getAllRoles() {
//        return null;
//    }

    @Override
    public List<User_CRM> getAllUsers() {
        //        // Extract List<Assignment_CRM> out of List<AssignmentUserRole>
        List<AssignmentUserRole> listAssignmentUserRole = aur_dto_repositoryInterface.getAllAssignmentUserRole();
        List<User_CRM> listUsers = new ArrayList<User_CRM>();
        User_CRM userElement;
        for (AssignmentUserRole element : listAssignmentUserRole) {
            userElement = new User_CRM();
            userElement.setUser_ID(element.getUser_ID());
            userElement.setUser_Name(element.getUser_Name());
            userElement.setUser_Email(element.getUser_Name());
            userElement.setUser_Password(element.getUser_Password());
            userElement.setUser_Role_ID(element.getUser_Role_ID());
            listUsers.add(userElement);
        }

        // Sort out duplicate elements
        Set<User_CRM> listUsersTempt = listUsers.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<User_CRM>(Comparator.comparing(User_CRM::getUser_ID))));
        List<User_CRM> listUsersFinal = new ArrayList<>(listUsersTempt);

        // Sort elements by ID
        listUsersFinal.sort((firstUser, secondUser) -> {
            return firstUser.getUser_ID() > secondUser.getUser_ID() ? 1 : -1;
        });

        // System.out.println("So phan tu: " + listProjectsTempt.size());

        return listUsersFinal;
    }
}
