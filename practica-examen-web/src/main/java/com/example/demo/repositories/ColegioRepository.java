package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Colegio;

@Repository
public interface ColegioRepository extends JpaRepository<Colegio, Integer> {

}
