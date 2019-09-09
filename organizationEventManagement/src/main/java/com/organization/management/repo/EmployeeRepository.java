package com.organization.management.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.management.model.Employee;
import com.organization.management.model.Event;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
