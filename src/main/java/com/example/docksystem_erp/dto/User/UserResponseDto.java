package com.example.docksystem_erp.dto.User;

import com.example.docksystem_erp.dto.Department.DepartmentResponseDto;
import com.example.docksystem_erp.dto.Role.RoleResponseDto;
import com.example.docksystem_erp.entity.User;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long userNo;
    private String userName;
    private String userId;
    private String userPw;
    private String userPhone;
    private String userWork;
    private Long userSalary;
    private DepartmentResponseDto department;
    private RoleResponseDto role;

    public static UserResponseDto fromEntity(User user){
        UserResponseDto dto = new UserResponseDto();
        dto.setUserNo(user.getUserNo());
        dto.setUserName(user.getUserName());
        dto.setUserId(user.getUserId());
        dto.setUserPw(user.getUserPw());
        dto.setUserPhone(user.getUserPhone());
        dto.setUserWork(user.getUserWork());
        dto.setUserSalary(user.getUserSalary());
        dto.setDepartment(DepartmentResponseDto.fromEntity(user.getDepartment()));
        dto.setRole(RoleResponseDto.fromEntity(user.getRole()));
        return dto;
    }
}
