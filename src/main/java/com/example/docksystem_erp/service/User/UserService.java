package com.example.docksystem_erp.service.User;

import com.example.docksystem_erp.dto.User.UserCreateRequestDto;
import com.example.docksystem_erp.dto.User.UserLoginDto;
import com.example.docksystem_erp.dto.User.UserResponseDto;
import com.example.docksystem_erp.dto.User.UserUpdateRequestDto;
import com.example.docksystem_erp.entity.Department.Department;
import com.example.docksystem_erp.entity.Role.Role;
import com.example.docksystem_erp.entity.User.User;
import com.example.docksystem_erp.repository.Department.DepartmentRepository;
import com.example.docksystem_erp.repository.Role.RoleRepository;
import com.example.docksystem_erp.repository.User.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor

public class UserService {
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserLoginDto findByUserId(String userId){
        UserLoginDto user = new UserLoginDto(userRepository.findByUserId(userId).orElseThrow(()->new EntityNotFoundException("사용자가 없습니다.")));
        return user;
    }


    //새로운 사용자 정보 생성
    public User createUser(UserCreateRequestDto requestDto){
        User user = new User();
        user.setUserName(requestDto.getUserName());
        user.setUserId(requestDto.getUserId());
        user.setUserPw(passwordEncoder.encode(requestDto.getUserPw()));
        user.setUserPhone(requestDto.getUserPhone());
        user.setUserWork(requestDto.getUserWork());
        user.setUserSalary(requestDto.getUserSalary());
        Department department = departmentRepository.findById(requestDto.getDepartmentNo())
                .orElseThrow(()->new EntityNotFoundException("존재하지 않는 부서입니다."+requestDto.getDepartmentNo()));
        user.setDepartment(department);
        Role role = roleRepository.findById(requestDto.getRoleNo())
                .orElseThrow(()->new EntityNotFoundException(("존재하지 않는 직급입니다."+requestDto.getRoleNo())));
        user.setRole(role);
        return userRepository.save(user);
    }
    //db상 모든 사용자 정보 조회
    public List<UserResponseDto> getAllUser(){
        return userRepository.findAll().stream()
                .map(UserResponseDto ::fromEntity)
                .collect(Collectors.toList());
    }
    //삭제
    public void deleteUser(Long userNo){
        if(!userRepository.existsById(userNo)){
            throw new EntityNotFoundException("해당 No의 사용자를 찾을 수 없습니다."+userNo);
        }
        userRepository.deleteById(userNo);
    }
    //업데이트
    public User updateUser(Long userNo, UserUpdateRequestDto requestDto){
        User existingUser = userRepository.findById(userNo)
                .orElseThrow(()->new EntityNotFoundException("해당 No의 사용자를 찾을 수 없습니다."));
        Department department = departmentRepository.findById(requestDto.getDepartmentNo())
                .orElseThrow(()->new EntityNotFoundException("존재하지 않는 부서입니다."+requestDto.getDepartmentNo()));
        Role role = roleRepository.findById(requestDto.getRoleNo())
                .orElseThrow(()->new EntityNotFoundException(("존재하지 않는 직급입니다."+requestDto.getRoleNo())));
        existingUser.updateUser(requestDto);
        existingUser.setDepartment(department);
        existingUser.setRole(role);
        return existingUser;
    }
}
