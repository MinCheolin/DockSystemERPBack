package com.example.docksystem_erp.controller.Project;

import com.example.docksystem_erp.dto.Project.ProjectCreateDto;
import com.example.docksystem_erp.dto.Project.ProjectResponseDto;
import com.example.docksystem_erp.dto.Project.ProjectUpdateDto;
import com.example.docksystem_erp.service.Project.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/erp/v1/projects")
public class ProjectController {
    private final ProjectService pjtService;

    @GetMapping
    public ResponseEntity<List<ProjectResponseDto>> getAllUser(){
             List<ProjectResponseDto> pjts = pjtService.FindAllProject();
        return ResponseEntity.ok(pjts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponseDto> getUser(@PathVariable("id")Long projectNo){
        ProjectResponseDto pjt = pjtService.FindProject(projectNo);
        return ResponseEntity.ok(pjt);
    }


    @PostMapping
    public ResponseEntity<Objects> CreateProject(@RequestBody ProjectCreateDto dto){
       pjtService.CreateProject(dto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{projectNo}")
    public ResponseEntity<Objects> UpdateProject(@PathVariable("projectNo")Long projectNo, @RequestBody ProjectUpdateDto dto){
       pjtService.UpdateProject(projectNo,dto);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Objects> Delete(@PathVariable("id")Long projectNo){
        pjtService.DeleteProject(projectNo);
        return ResponseEntity.noContent().build();
    }

}
