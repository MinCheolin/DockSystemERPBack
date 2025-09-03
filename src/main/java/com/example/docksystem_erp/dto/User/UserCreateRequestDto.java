package com.example.docksystem_erp.dto.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserCreateRequestDto {

    @NotBlank(message = "이름은 필수입니다.")
    private String userName;
    @NotBlank(message = "아이디는 필수입니다.")
    private String userId;
    @NotBlank(message = "비밀번호는 필수입니다.")
    private String userPw;
    @NotBlank(message = "연락처는 필수입니다.")
    private String userPhone;
    @NotBlank(message = "업무는 필수입니다.")
    private String userWork;
    @NotBlank(message = "기본급은 필수입니다.")
    private Long userSalary;
    @NotNull(message = "부서를 입력해주세요.")
    private Long departmentNo;
    @NotNull(message = "직급을 입력해주세요.")
    private Long roleNo;
}
