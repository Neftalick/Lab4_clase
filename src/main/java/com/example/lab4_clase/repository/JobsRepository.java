package com.example.lab4_clase.repository;


import com.example.lab4_clase.DTO.EmpleadoDepartamentoDto;
import com.example.lab4_clase.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobsRepository extends JpaRepository<Jobs, String> {
    @Query(nativeQuery = true,value="select employees.employee_id as id, employees.first_name as nombre,employees.last_name as apellido,jobs.job_title as cargo, employees.salary as sueldo from employees \n" +
            "inner join jobs on jobs.job_id=employees.job_id\n" +
            "where employees.department_id=?1 \n" +
            "order by employees.salary desc")
    List<EmpleadoDepartamentoDto> obtenerEmpleadoDepartamento(int id);
}
