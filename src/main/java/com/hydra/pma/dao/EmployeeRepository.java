package com.hydra.pma.dao;

import com.hydra.pma.entities.Employee;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByFirstnameContainsAndLastnameContains(String firstname, String lastname, Pageable pageable);
    List<Employee> findAllByProject(long projectId);
}
