package com.example.ifbademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ifbademo.model.VendaItens;


public interface IVendaItensRepository extends JpaRepository<VendaItens, Long>{
    
}
