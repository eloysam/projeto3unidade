package com.example.ifbademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ifbademo.model.Usuario;


public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
