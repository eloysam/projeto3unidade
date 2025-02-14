package com.example.ifbademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ifbademo.model.Fornecedor;
import com.example.ifbademo.repository.IFornecedorRepository;



@Service
@Transactional(readOnly = false)
public class FornecedorService {
    @Autowired
    private IFornecedorRepository repCliFornecedor;

    public void salvar(Fornecedor cliF){
        repCliFornecedor.save(cliF);
    }

    public void atualizar(Fornecedor cliF){
        repCliFornecedor.save(cliF);
    }

    public boolean excluir(Long id){
       // repCliFornecedor.deleteById(id);
       return true;
    }

    private boolean FornecedorTemProduto(Long id) {
        /*if (buscarPorId(id).get().isEmpty()){
            return false;
        }else{
            return true;
        }*/
        return true;
    }

    public Optional<Fornecedor> buscarPorId(Long id){
        return repCliFornecedor.findById(id);
    }

    public List<Fornecedor> buscarTodos(){
        return repCliFornecedor.findAll();
    } 
}
