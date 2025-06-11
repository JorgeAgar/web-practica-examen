package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Taller;

@Repository
public interface TallerRepository extends JpaRepository<Taller, Integer> {

}
