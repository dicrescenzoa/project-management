package com.hydra.pma.mapper;

import com.hydra.pma.dto.EmployeeDto;
import com.hydra.pma.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDto convert(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setEmail(employee.getEmail());
        return new EmployeeDto();
    }

    public Employee convert(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }
}
