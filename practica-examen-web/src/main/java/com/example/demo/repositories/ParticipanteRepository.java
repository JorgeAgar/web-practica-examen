package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

}
