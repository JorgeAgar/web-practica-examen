package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

}
