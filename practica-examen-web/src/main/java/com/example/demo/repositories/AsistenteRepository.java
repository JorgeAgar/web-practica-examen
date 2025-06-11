package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Asistente;

@Repository
public interface AsistenteRepository extends JpaRepository<Asistente, Integer> {

}
