package com.hydra.pma.controllers;

import com.hydra.pma.dao.EmployeeRepository;
import com.hydra.pma.dao.ProjectRepository;
import com.hydra.pma.entities.Employee;
import com.hydra.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);
        return "new-project";
    }

    @PostMapping(value = "/save", produces = "application/json")
    public String createProjectForm(Project project, Model model) {
        projectRepo.save(project);
        return "redirect:/projects/new";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Project> createProject(Project project, @RequestParam List<Long> employees) {
        Project newProject = projectRepo.save(project);

        List<Employee> assignedEmployees = employeeRepo.findAllById(employees);
        for (int i = 0; i < assignedEmployees.size(); i++) {
            Employee current = assignedEmployees.get(i);
            current.setProject(newProject);
            employeeRepo.save(current);
        }

        return ResponseEntity.ok(newProject);
    }
}
