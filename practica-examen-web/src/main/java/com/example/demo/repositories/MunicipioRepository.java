package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer> {

}
