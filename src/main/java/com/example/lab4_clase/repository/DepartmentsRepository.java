package com.example.lab4_clase.repository;

import com.example.lab4_clase.DTO.DepartamentoSalarioDto;
import com.example.lab4_clase.entity.Departments;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentsRepository extends JpaRepository<Departments,Integer> {
    //salario promedio por departamento
    @Query(nativeQuery = true,value = "select departments.department_id as id,departments.department_name as departamento,avg(employees.salary) as promedio from departments \n" +
            "inner join employees on employees.department_id= departments.department_id\n" +
            "group by employees.department_id")
    List<DepartamentoSalarioDto> obtenerSalarioPorDepartamento();

}
