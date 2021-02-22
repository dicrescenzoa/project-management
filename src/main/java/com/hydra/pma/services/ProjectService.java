package com.hydra.pma.services;

import com.hydra.pma.dao.EmployeeRepository;
import com.hydra.pma.dto.EmployeeDto;
import com.hydra.pma.entities.Employee;
import com.hydra.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {
    @Autowired
    private EmployeeRepository employeeRepo;

    public List<EmployeeDto> getEmployeesOfProject(Project project) {
        return (employeeRepo.findAllByProject(project.getProjectId())).stream().map(this::convertEmployeeForProjects).collect(Collectors.toList());
    }

    private EmployeeDto convertEmployeeForProjects(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto(
                employee.getEmployeeId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail()
        );
        return employeeDto;
    }
}
