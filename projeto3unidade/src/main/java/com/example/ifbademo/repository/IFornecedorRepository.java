package com.example.ifbademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ifbademo.model.Fornecedor;


public interface IFornecedorRepository extends JpaRepository<Fornecedor, Long> {
    
}
