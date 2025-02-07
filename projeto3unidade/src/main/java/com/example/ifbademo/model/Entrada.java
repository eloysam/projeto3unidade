package com.example.ifbademo.model;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "entrada")
@Data
public class Entrada extends AbstractEntity<Long>{
    //private Long idEntrada;
    @Column
    private String data;
    @Column
    private double valor;

    @OneToMany(mappedBy = "entrada") // por na outra classe haver um atributo com o @joincolunm, esse relacionamento é bidimencional
    private List<Itens_entrada> itensEntrada;
    
    @Override
    public String toString() {
        return "Entrada [data=" + data + ", valor=" + valor + ", itensEntrada=" + itensEntrada
                + "]";
    }

    
}
