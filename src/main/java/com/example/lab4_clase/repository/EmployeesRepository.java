package com.example.lab4_clase.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeesRepository extends JpaRepository<com.example.laboratorio4.entity.Employees,Integer> {


}
