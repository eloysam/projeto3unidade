package com.example.ifbademo.model;
import javax.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "vendaItens")
public class VendaItens extends AbstractEntity<Long> {
   
    @Column
    private double valorUnitario;
    @Column
    private int quantidade;
   
    
    @ManyToOne
    @JoinColumn(name = "id_venda_fk") // criando uma chave estrangeira venda na tabela do banco de dados vendaItens
    private Venda venda;
    
    @ManyToOne
    @JoinColumn(name = "id_produto_fk")
    private Produto produto;

    /*
    @Override
    public String toString() {
        return "VendaItens [nomeProduto=" + nomeProduto + ", valorUnitario=" + valorUnitario + ", quantidade="
                + quantidade + ", valorTotal=" + valorTotal +  "]";
    }
    */
    
}
