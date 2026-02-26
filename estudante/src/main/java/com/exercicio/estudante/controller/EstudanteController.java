package com.exercicio.estudante.controller;

import com.exercicio.estudante.models.EstudanteModel;
import com.exercicio.estudante.repositories.EstudanteRepository;
import com.exercicio.estudante.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @PostMapping
    public EstudanteModel criarEstudante(@RequestBody EstudanteModel estudanteModel) {
        return estudanteService.criarEstudante(estudanteModel);
    }

    @GetMapping
    public List<EstudanteModel> listarEstudante() {
        return estudanteService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarEstudante(@PathVariable("long id") Long Id) {
        estudanteService.deletarEstudante(Id);
    }

}
