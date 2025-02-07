package com.example.ifbademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ifbademo.model.Venda;
import com.example.ifbademo.repository.IVendaRepository;


@Service
@Transactional(readOnly = false)
public class VendaService {
    @Autowired
    private IVendaRepository repVen;

    public void salvar(Venda ven){
        repVen.save(ven);
    }

    public void atualizar(Venda ven){
        repVen.save(ven);
    }

    public void excluir(Long id){
        repVen.deleteById(id);
    }

    public Optional<Venda> buscarPorId(Long id){ //serve para representar valores que podem estar presentes ou ausentes (nulos)
        return repVen.findById(id);
    }

    public List<Venda> buscarTodos(){
        return repVen.findAll();
    }
}

