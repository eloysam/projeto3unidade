package com.example.ifbademo.controller;

import java.util.List;

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
public class ConsultaVendaBean {
    @Getter
    private Venda venda = new Venda();
    @Getter
    private VendaItens venItens;
    @Getter
    private List<Produto> produtos;
    @Getter
    private ProdutoService prodService;
    @Getter
    private VendaService venService;
    @Getter
    private VendaItensService venItenService;

    public void init(){
        produtos = prodService.buscarTodos(); // aqui serãos buscados todos os produtos que foram vendidos.
    }
    
    public void excluir(){
        FacesContext context = FacesContext.getCurrentInstance();
        
        if(venService.excluir(venda.getId())){
            
        }
    }
}
