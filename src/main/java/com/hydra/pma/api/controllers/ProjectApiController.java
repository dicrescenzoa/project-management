package com.hydra.pma.api.controllers;

import com.hydra.pma.dao.EmployeeRepository;
import com.hydra.pma.dao.ProjectRepository;
import com.hydra.pma.entities.Employee;
import com.hydra.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectApiController {
    @Autowired
    ProjectRepository projectRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getProjects() {
        return projectRepo.findAll();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(Project project, @RequestParam List<Long> employees) {
        Project newProject = projectRepo.save(project);

        List<Employee> assignedEmployees = employeeRepo.findAllById(employees);
        for (int i = 0; i < assignedEmployees.size(); i++) {
            Employee current = assignedEmployees.get(i);
            current.setProject(newProject);
            employeeRepo.save(current);
        }

        return newProject;
    }
}
