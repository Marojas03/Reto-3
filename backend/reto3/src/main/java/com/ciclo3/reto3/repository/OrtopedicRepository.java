package com.ciclo3.reto3.repository;

import com.ciclo3.reto3.model.Ortopedic;
import com.ciclo3.reto3.repository.crud.OrtopedicCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrtopedicRepository {
    @Autowired
    private OrtopedicCrudRepository ortopedicCrudRepository;

    public List<Ortopedic> getAll() {
        return  (List<Ortopedic>) ortopedicCrudRepository.findAll();
    }

    public Optional<Ortopedic> getOrtopedic(int id) {
        return ortopedicCrudRepository.findById(id);
    }

    public Ortopedic save(Ortopedic o) {
        return ortopedicCrudRepository.save(o);
    }
}