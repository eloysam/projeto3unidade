package com.example.ifbademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ifbademo.model.Entrada;


public interface IEntradaRepository extends JpaRepository<Entrada, Long> {
    
}
