package com.example.lab4_clase.controller;

import com.example.lab4_clase.DTO.DepartamentoSalarioDto;
import com.example.lab4_clase.DTO.EmpleadoDepartamentoDto;
import com.example.lab4_clase.repository.DepartmentsRepository;
import com.example.lab4_clase.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    DepartmentsRepository departmentsRepository;
    @Autowired
    JobsRepository jobsRepository;

    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }

    @GetMapping(value = {"/Salario"})
    public String listaEmpleadosMayorSalrio (){

      //COMPLETAR
        return "Search/lista2";
    }

    @PostMapping("/busqueda")
    public String buscar (){

        return "redirect /Search/";
    }

    @GetMapping(value = "/Filtro2")
    public String cantidadEmpleadosPorPais (Model model){
        List<DepartamentoSalarioDto> out = departmentsRepository.obtenerSalarioPorDepartamento();
        model.addAttribute("lista",out);
        return "/Search/salario";
    }

    @GetMapping("/listar")
    public String listarEmpleadoDep(Model model,@RequestParam("id") String id) {
        try{
            List<EmpleadoDepartamentoDto> out = jobsRepository.obtenerEmpleadoDepartamento(Integer.parseInt(id));
            model.addAttribute("lista",out);
        }catch(Exception e){
            System.out.println("Se envio un id invalido");
        }
        return "/Search/lista3";
    }


}
