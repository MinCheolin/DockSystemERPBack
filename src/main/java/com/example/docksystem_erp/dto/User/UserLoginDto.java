package com.example.docksystem_erp.dto.User;

import com.example.docksystem_erp.entity.User.User;
import lombok.Data;

@Data
public class UserLoginDto {
    private String userId;
    private String userName;
    private String passwordHash;


    public UserLoginDto(User user){
        this.userId = user.getUserId();
        this.passwordHash = user.getUserPw();
        this.userName = user.getUserName();
    }

}
