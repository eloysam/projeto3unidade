package com.example.ifbademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ifbademo.model.Usuario;
import com.example.ifbademo.repository.IUsuarioRepository;



@Service
@Transactional(readOnly = false)
public class UsuarioService {
    @Autowired
    private IUsuarioRepository repUs;

    public void salvar(Usuario us){
        repUs.save(us);
    }

    public void atualizar(Usuario us){
        repUs.save(us);
    }

    public void excluir(Long id){
        repUs.deleteById(id);
    }

    public Optional<Usuario> buscarPorId(Long id){ //serve para representar valores que podem estar presentes ou ausentes (nulos)
        return repUs.findById(id);
    }

    public List<Usuario> buscarTodos(){
        return repUs.findAll();
    }
}
