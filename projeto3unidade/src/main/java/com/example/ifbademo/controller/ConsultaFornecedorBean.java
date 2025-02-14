package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

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
    private Fornecedor fornecedorSelecionado;

    @Getter
    private List<Fornecedor> fornecedores;
    @Getter
    private FornecedorService forService;
    
    @PostConstruct
    public void init(){
        fornecedores = forService.buscarTodos();
    }

    public void excluir(){
        FacesContext context = FacesContext.getCurrentInstance();

        forService.buscarPorId(fornecedor.getId());
    
    }


}
