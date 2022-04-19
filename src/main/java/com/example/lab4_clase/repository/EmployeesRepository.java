package com.example.lab4_clase.repository;


import com.example.lab4_clase.DTO.EmpleadoMayorSalario;
import com.example.lab4_clase.entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<com.example.lab4_clase.entity.Employees,Integer> {

    @Query(value = "SELECT * FROM hr.employees INNER JOIN hr.departments ON ( hr.employees.department_id = hr.departments.department_id) INNER JOIN hr.jobs ON ( hr.employees.job_id = hr.jobs.job_id) INNER JOIN hr.locations ON ( hr.departments.location_id = hr.locations.location_id) WHERE first_name = ?1 OR last_name = ?1 OR job_title = ?1 OR department_name = ?1  OR city = ?1 ",nativeQuery = true)
    List<Employees> buscarEmployee(String campo);

    @Query(nativeQuery = true,value = "SELECT e.first_name as firstName, e.last_name as lastName, e.hire_date as hireDate, j.job_title as jobTitle, d.department_name as departmentName, e.salary FROM employees e\n" +
            "inner join jobs j on j.job_id = e.job_id\n" +
            "inner join departments d on d.department_id = e.department_id\n" +
            "order by e.salary desc\n" +
            "limit 10;")
    List<EmpleadoMayorSalario> listarEmpleadosConMayorSalario();

    @Query(nativeQuery = true,value = "SELECT e.first_name as firstName, e.last_name as lastName, e.hire_date as hireDate, j.job_title as jobTitle, d.department_name as departmentName, e.salary FROM employees e\n" +
            "inner join jobs j on j.job_id = e.job_id\n" +
            "inner join departments d on d.department_id = e.department_id\n" +
            "where e.salary = ?1\n" +
            "order by e.salary desc;")
    List<EmpleadoMayorSalario> buscarEmpleadoPorMayorSalario(float salario);
}
