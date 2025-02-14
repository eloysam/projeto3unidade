package com.example.ifbademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ifbademo.model.Produto;
import com.example.ifbademo.repository.IProdutoRepository;

@Service
@Transactional(readOnly = false)
public class ProdutoService {
    @Autowired
    private IProdutoRepository repPro;

    public void salvar(Produto pro){
        repPro.save(pro);
    }

    public void atualizar(Produto pro){
        repPro.save(pro);
    }

    public boolean excluir(Long id){
        if (!produtoTemEntrada(id)) {
            repPro.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    private boolean produtoTemEntrada(Long id) {
        if (buscarPorId(id).getItens_entrada().isEmpty()){
            return false;
        }else{
            return true;
        }
    }

    public Produto buscarPorId(Long id){
        return repPro.findById(id).get();
    }

    public List<Produto> buscarTodos(){
        return repPro.findAll();
    }

    public void controlarEstoque(Long idProduto, int qtdRetirada) {
        Produto produtoOptional = buscarPorId(idProduto); // Busca o produto no repositório utilizando o id sfornecido e encapsula o resultado em um Optional

        if (produtoOptional != null) { // Verifica se o produto foi encontrado no Optional, o isPresente -> é usado em Java para verificar se um objeto encapsulado em um Optional está presente ou não retornando um valor bool
            Produto produto = produtoOptional; // Extrai o objeto Produto do Optional
            int estoqueAtual = produto.getQtdProduto(); // Obtém a quantidade atual do produto em estoque

            if (estoqueAtual >= qtdRetirada) { // Verifica se há estoque suficiente para a quantidade a ser retirada
                produto.setQtdProduto(estoqueAtual - qtdRetirada); // atualiza o valor do estoque
                atualizar(produto); // salva as mudanças
                System.out.println("Estoque atualizado com sucesso. Estoque restante: " + produto.getQtdProduto());
            } 
            else {
                System.out.println("Estoque insuficiente. Quantidade disponível: " + estoqueAtual);
            }
        } 
        else {
            System.out.println("Produto não encontrado.");
        }
    }

    // controleEstoque(1L, 7); para teste

}
