package com.hydra.pma.services;

import com.hydra.pma.dto.ProjectDto;
import com.hydra.pma.entities.Project;
import com.hydra.pma.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    public ProjectDto getDto(Project project){
        return projectMapper.convert(project);
    }

    public Project getProject(ProjectDto dto){
        return projectMapper.convert(dto);
    }
}
