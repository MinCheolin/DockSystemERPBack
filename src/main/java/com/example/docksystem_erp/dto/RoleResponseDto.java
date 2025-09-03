package com.example.docksystem_erp.dto;

import com.example.docksystem_erp.entity.Role;
import lombok.Data;

@Data
public class RoleResponseDto {
    private Long roleNo;
    private String roleName;

    public static RoleResponseDto fromEntity(Role role){
        RoleResponseDto dto = new RoleResponseDto();
        dto.setRoleNo(role.getRoleNo());
        dto.setRoleName(role.getRoleName());
        return dto;
    }
}
