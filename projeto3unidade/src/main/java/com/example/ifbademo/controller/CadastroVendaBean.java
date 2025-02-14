package com.example.ifbademo.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.example.ifbademo.model.Produto;
import com.example.ifbademo.model.Venda;
import com.example.ifbademo.model.VendaItens;
import com.example.ifbademo.service.ProdutoService;
import com.example.ifbademo.service.VendaItensService;
import com.example.ifbademo.service.VendaService;

import lombok.*;

@Component
@Scope("view")
public class CadastroVendaBean {
    
    @Getter
    private Venda vendas = new Venda();

    @Setter @Getter
    private VendaItens vendaItens;

    @Getter
    private List<Produto> produtos;

    @Getter
    private VendaService venService;

    @Getter
    private ProdutoService prodService;

    @Getter
    private VendaItensService venItenService;

    @PostConstruct
    public void init(){
        produtos = prodService.buscarTodos();
    }

    public void salvar(){
        FacesContext cont = FacesContext.getCurrentInstance();
        venService.salvar(vendas);

        vendas = new Venda();
        FacesMessage messagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso!", "Venda cadastrada com sucesso!");
        cont.addMessage(null, messagem);
    }

    public void preparaVenda(){
       vendas = venService.buscarPorId(vendas.getId());
    }
}
