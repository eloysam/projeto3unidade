package com.example.ifbademo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ifbademo.model.Entrada;
import com.example.ifbademo.repository.IEntradaRepository;

@Service
@Transactional(readOnly = false)
public class EntradaService {
    @Autowired
    private IEntradaRepository repEntrada;

    // métodos básicos do CROUD + métodos específicos
    
    public void salvar(Entrada ent){
        repEntrada.save(ent);
    }

    public void atualizar(Entrada ent){
        repEntrada.save(ent);
    }

    public void excluir(Long id){
        repEntrada.deleteById(id);
    }

    public Optional<Entrada> buscarPorId(Long id){ //serve para representar valores que podem estar presentes ou ausentes (nulos)
        return repEntrada.findById(id);
    }

    public List<Entrada> buscarTodos(){
        return repEntrada.findAll();
    }
}
