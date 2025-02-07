package com.example.ifbademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ifbademo.model.Produto;


public interface IProdutoRepository extends JpaRepository<Produto, Long> {
    
}
