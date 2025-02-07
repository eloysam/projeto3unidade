package com.example.ifbademo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.ifbademo.model.Fornecedor;
import com.example.ifbademo.model.Produto;
import com.example.ifbademo.service.FornecedorService;
import com.example.ifbademo.service.ProdutoService;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("view")
public class CadastroProdutoBean {
    @Getter @Setter
    private Produto produto = new Produto();
    @Getter
    private List<Fornecedor> fornecedores;

    @Getter
    private FornecedorService forService;
    @Getter
    private ProdutoService prodService;


    @PostConstruct
    public void init(){
       fornecedores = forService.buscarTodos();
       
    }

    public void salvar(){
        FacesContext context = FacesContext.getCurrentInstance(); // eu não sei o que é isso.
        prodService.salvar(produto);

        produto = new Produto();
        FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "cadastro efeutuado com sucesso!", "Produto cadastrado com sucesso!");
        context.addMessage(null, mensagem);
    }

    public void preparaProduto(){
       produto = prodService.buscarPorId(produto.getId());
    }
}
