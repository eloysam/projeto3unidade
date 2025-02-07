package com.example.ifbademo.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.ifbademo.model.Produto;
import com.example.ifbademo.service.ProdutoService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class CadastroProdutoBean {
    @Getter @Setter
    private Produto produto;
    @Getter
    private ProdutoService prodService;
    @Getter
    private List<Produto> listDepartamentos;

    public void init(){
        
    }
}
