package com.hydra.pma.controllers;

import com.hydra.pma.dao.ProjectRepository;
import com.hydra.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projectRepo;

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
}
