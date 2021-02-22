package com.hydra.pma.api.controllers;

import com.hydra.pma.dao.EmployeeRepository;
import com.hydra.pma.dao.ProjectRepository;
import com.hydra.pma.dto.EmployeeDto;
import com.hydra.pma.dto.ProjectDto;
import com.hydra.pma.entities.Employee;
import com.hydra.pma.entities.Project;
import com.hydra.pma.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectApiController {
    @Autowired
    ProjectRepository projectRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @Autowired
    private ProjectService projectService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getProjects() {
        return projectRepo.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public ProjectDto getProject(@PathVariable("id") long id) {
        Project project = projectRepo.findById(id).orElseThrow(() -> new EntityNotFoundException());
        return projectService.getDto(project);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(Project project) {
        Project newProject = projectRepo.save(project);
        List<Employee> assignedEmployee = newProject.getEmployees();
        for (int i = 0; i < assignedEmployee.size(); i++) {
            Employee current = assignedEmployee.get(i);
            current.setProject(newProject);
            employeeRepo.save(current);
        }

        return newProject;
    }
}
