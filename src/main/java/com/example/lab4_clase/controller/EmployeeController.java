package com.example.lab4_clase.controller;

import com.example.lab4_clase.entity.Employees;
import com.example.lab4_clase.repository.DepartmentsRepository;
import com.example.lab4_clase.repository.EmployeesRepository;
import com.example.lab4_clase.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;

    @GetMapping(value = {"","/"})
    public String listaEmployee(Model model){
        model.addAttribute("listaEmployee", employeesRepository.findAll());
        model.addAttribute("listaJobs", jobsRepository.findAll());
        model.addAttribute("listaDepartments", departmentsRepository.findAll());
        return "employee/lista";
    }

    @GetMapping("/new")
    public String nuevoEmployeeForm(@ModelAttribute("employees") Employees employees, Model model) {
        model.addAttribute("listaJefes",employeesRepository.findAll());
        model.addAttribute("listaJobs", jobsRepository.findAll());
        model.addAttribute("listaDepartments",departmentsRepository.findAll());
        return "employee/Frm";
    }

    @PostMapping("/save")
    public String guardarEmployee(@ModelAttribute("employees") @Valid Employees employees, BindingResult bindingResult,
                                  RedirectAttributes attr,
                                  @RequestParam(name="fechaContrato", required=false) String fechaContrato, Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("listaJobs", jobsRepository.findAll());
            model.addAttribute("listaJefes", employeesRepository.findAll());
            model.addAttribute("listaDepartments", departmentsRepository.findAll());
            return "employee/Frm";
        }else {
            if (employees.getId() == null) {
                attr.addFlashAttribute("msg1", "Empleado creado exitosamente");
                employees.setHireDate(LocalDateTime.now());
                employeesRepository.save(employees);
                return "redirect:/employee";
            } else {
                employees.setHireDate(LocalDateTime.now());
                employeesRepository.save(employees);
                attr.addFlashAttribute("msg2", "Empleado actualizado exitosamente");
                return "redirect:/employee";
            }
        }
    }

    @GetMapping("/edit")
    public String editarEmployee(Model model, @RequestParam("id") int id) {

        Optional<Employees> optionalEmployees = employeesRepository.findById(id);

        if (optionalEmployees.isPresent()) {
            Employees employees = optionalEmployees.get();
            model.addAttribute("employees", employees);
            model.addAttribute("listaJobs", jobsRepository.findAll());
            model.addAttribute("listaJefes", employeesRepository.findAll());
            model.addAttribute("listaDepartments", departmentsRepository.findAll());
            return "employee/Frm";
        } else {
            return "redirect:/employee";
        }
    }

    @GetMapping("/delete")
    public String borrarEmpleado(Model model,
                                      @RequestParam("id") int id,
                                      RedirectAttributes attr) {

        Optional<Employees> optEmployees = employeesRepository.findById(id);

        if (optEmployees.isPresent()) {
            employeesRepository.deleteById(id);
            attr.addFlashAttribute("msg3","Empleado borrado exitosamente");
        }
        return "redirect:/employee";

    }

    @PostMapping("/search")
    public String buscar (@RequestParam("searchText") String searchField,Model model){
        model.addAttribute("listaEmployee",employeesRepository.buscarEmployee(searchField));
        return "employee/lista";

    }

}
