package com.example.ifbademo.controller;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.ifbademo.model.Fornecedor;
import com.example.ifbademo.model.Produto;
import com.example.ifbademo.service.FornecedorService;

import lombok.Getter;

@Component
@Scope("view")
public class ConsultaFornecedorBean {
    
    @Getter
    private Fornecedor fornecedor;
    @Getter
    private FornecedorService forService;
    @Getter
    private Produto produto;

    @PostConstruct
    public void init(){
        fornecedor = forService.buscarTodos();
    }


}
