package com.exercicio.estudante.services;

import com.exercicio.estudante.models.EstudanteModel;
import com.exercicio.estudante.repositories.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudanteService {

    @Autowired
    private EstudanteRepository estudanteRepository;

    public EstudanteModel criarEstudante(EstudanteModel estudanteModel) {
        return estudanteRepository.save(estudanteModel);
    }

    public List<EstudanteModel> findAll() {
        return estudanteRepository.findAll();
    }

    public void deletarEstudante(Long id) {
        estudanteRepository.deleteById(id);
    }

    public void buscarPorId(Long id) {
        estudanteRepository.findById(id);
    }
}
