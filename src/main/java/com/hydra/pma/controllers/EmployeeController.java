package com.hydra.pma.controllers;

import com.hydra.pma.dao.EmployeeRepository;
import com.hydra.pma.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Employee>> getEmployees() {
        Iterable<Employee> employees = employeeRepo.findAll();
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(employees, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/findAllByFullName", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Employee>> findAllByFullName(@RequestParam String firstname, @RequestParam String lastname) {
        Pageable pageable = PageRequest.of(0, 10);
        Iterable<Employee> employees = employeeRepo.findAllByFirstnameContainsAndLastnameContains(firstname, lastname, pageable);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(employees, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id) {
        Optional<Employee> employeeOpt = employeeRepo.findById(id);
        if(employeeOpt.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(employeeOpt.get());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Employee> createEmployee(Employee employee, Model model) {
        Employee newEmployee = employeeRepo.save(employee);
        return ResponseEntity.ok(newEmployee);
    }
}
