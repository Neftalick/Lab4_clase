package com.example.lab4_clase.repository;


import com.example.lab4_clase.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<com.example.lab4_clase.entity.Employees,Integer> {

    @Query(value = "SELECT * FROM hr.employees INNER JOIN hr.departments ON ( hr.employees.department_id = hr.departments.department_id) INNER JOIN hr.jobs ON ( hr.employees.job_id = hr.jobs.job_id) INNER JOIN hr.locations ON ( hr.departments.location_id = hr.locations.location_id) WHERE first_name = ?1 OR last_name = ?1 OR job_title = ?1 OR department_name = ?1  OR city = ?1 ",nativeQuery = true)
    List<Employees> buscarEmployee(String campo);
}
