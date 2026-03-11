package com.exercicio.estudante.controller;

import com.exercicio.estudante.models.EstudanteModel;
import com.exercicio.estudante.repositories.EstudanteRepository;
import com.exercicio.estudante.services.EstudanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/estudantes")
public class EstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    @PostMapping
    public ResponseEntity <EstudanteModel> criarEstudante(@RequestBody EstudanteModel estudanteModel) {
        EstudanteModel requeste = estudanteService.criarEstudante(estudanteModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(estudanteModel.getId()).toUri();
        return ResponseEntity.created(uri).body(requeste);
    }

    @GetMapping
    public ResponseEntity <List<EstudanteModel>> findAll() {
        List<EstudanteModel> requeste = estudanteService.findAll();
        return ResponseEntity.ok().body(requeste);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEstudante(@PathVariable Long id) {
        estudanteService.deletarEstudante(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public void buscarPorId(@PathVariable Long id) {
        estudanteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public EstudanteModel atualizar(@PathVariable Long id, @RequestBody EstudanteModel model) {
        return estudanteService.atualizar(id, model);
    }


}
