package com.hydra.pma.mapper;

import com.hydra.pma.dto.ProjectDto;
import com.hydra.pma.entities.Project;
import com.hydra.pma.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProjectMapper {
    @Autowired
    private EmployeeService employeeService;

    public ProjectDto convert(Project project) {
        ProjectDto dto = new ProjectDto();

        dto.setProjectId(project.getProjectId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setStage(project.getStage());

        return dto;
    }

    public Project convert(ProjectDto dto) {
        Project project = new Project();

        project.setProjectId(dto.getProjectId());
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStage(dto.getStage());

        return project;
    }
}
