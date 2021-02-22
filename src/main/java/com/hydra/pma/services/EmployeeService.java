package com.hydra.pma.services;

import com.hydra.pma.dao.EmployeeRepository;
import com.hydra.pma.dto.EmployeeDto;
import com.hydra.pma.entities.Employee;
import com.hydra.pma.entities.Project;
import com.hydra.pma.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<EmployeeDto> getEmployeesOfProject(Project project) {
        return (employeeRepo.findAllByProject(project.getProjectId())).stream().map(this::convertEmployeeToDto).collect(Collectors.toList());
    }

    private EmployeeDto convertEmployeeToDto(Employee employee) {
        EmployeeDto employeeDto = employeeMapper.convert(employee);
        return employeeDto;
    }
}
