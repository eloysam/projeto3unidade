package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ifbademo.model.Produto;
import com.example.ifbademo.service.ProdutoService;

import lombok.Getter;
import lombok.Setter;

public class ConsultaProdutosBean {

    @Getter
    private Produto produto = new Produto();
    @Getter
    private List<Produto> produtos;

    @Getter @Setter
    private Produto prodSelecionado;

    @Autowired
    private ProdutoService produtoService;

    @PostConstruct
    public void init(){
        produtos = produtoService.buscarTodos();
    }

    public void excluir(){
        FacesContext context = FacesContext.getCurrentInstance();

        if(produtoService.excluir(prodSelecionado.getId());){
            context.addMessage(null, new FacesMessage("Exclusão", "Produto excluído com sucesso."));

            produtos = produtoService.buscarTodos();
        }
        else{
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro na exclusão.",
                    "Existe um produto vinculado a este fornecedor."));
        }
    }
}
