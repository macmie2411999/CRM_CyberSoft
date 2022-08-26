package com.macmie.crm_cybersoft.Repository;

import com.macmie.crm_cybersoft.DTO.AssignmentUserRole;
import com.macmie.crm_cybersoft.DTO.ProjectAssignmentUser;

import java.util.List;

public interface PAU_DTO_RepositoryInterface {
    List<ProjectAssignmentUser> getAllProjectAssignmentUser();
}
