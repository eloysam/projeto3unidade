package com.example.ifbademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ifbademo.model.Venda;


public interface IVendaRepository extends JpaRepository<Venda, Long> {
    
}
