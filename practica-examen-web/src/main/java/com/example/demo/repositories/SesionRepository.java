package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Sesion;

@Repository
public interface SesionRepository extends JpaRepository<Sesion, Integer> {

}
