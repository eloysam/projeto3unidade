package com.example.ifbademo.model;


import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "itensEntrada")
@Data
public class Itens_entrada extends AbstractEntity<Long>{
    
    @Column
    private int quantidade;
    @Column
    private double valorUnitario;
    
    @ManyToOne
    @JoinColumn(name = "id_entrada_fk") // chave estrangeira
    private Entrada entrada;

    @ManyToOne
    @JoinColumn(name = "id_produto_fk")
    private Produto produto;

    /*
    @Override
    public String toString() {
        return "ItensEntrada [idProduto=" + produto + ", quantidade=" + quantidade + ", valorUnitario="
                + valorUnitario + "]";
    }
    */
}
