package com.example.ifbademo.model;

import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class Produto extends AbstractEntity<Long>{
    @Column
    private String categoria;
    @Column
    private String nomeProduto;
    @Column
    private String dataFabricacao;
    @Column
    private String dataValidade;
    @Column
    private int qtdProduto;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Itens_entrada> itens_entrada;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<VendaItens> vendaIt;

    @ManyToOne
    private Fornecedor fornecedor;

    @Override
    public String toString() {
        return "Produto [categoria=" + categoria + ", nomeProduto=" + nomeProduto + ", dataFabricacao=" + dataFabricacao
                + ", dataValidade=" + dataValidade + "]";
    }

    
}
