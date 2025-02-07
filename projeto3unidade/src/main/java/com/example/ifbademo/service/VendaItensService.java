package com.example.ifbademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ifbademo.model.Produto;
import com.example.ifbademo.model.VendaItens;
import com.example.ifbademo.repository.IProdutoRepository;
import com.example.ifbademo.repository.IVendaItensRepository;



@Service
@Transactional(readOnly = false)
public class VendaItensService {
    @Autowired
    private IVendaItensRepository repVenIt;
    private IProdutoRepository repPro;

    public void salvar(VendaItens venIt){
        repVenIt.save(venIt);
    }

    public void atualizar(VendaItens venIt){
        repVenIt.save(venIt);
    }

    public void excluir(Long id){
        repVenIt.deleteById(id);
    }

    public Optional<VendaItens> buscarPorId(Long id){ //serve para representar valores que podem estar presentes ou ausentes (nulos)
        return repVenIt.findById(id);
    }

    public List<VendaItens> buscarTodos(){
        return repVenIt.findAll();
    }

    public void retirarItens(Long idVendaItens) {

        Optional<VendaItens> vendaItensOptional = buscarPorId(idVendaItens); // Busca o item de venda pelo id

        if (vendaItensOptional.isPresent()) { // Verifica se o item de venda foi encontrado
            VendaItens vendaItens = vendaItensOptional.get(); // Obtém o objeto VendaItens do Optional

            Produto produto = vendaItens.getProduto(); // Obtém o produto associado ao item de venda

            if (produto != null) {
                int estoqueAtual = produto.getQtdProduto(); // Obtém a quantidade atual do estoque do produto
                int qtdRetirada = vendaItens.getQuantidade();

                if (estoqueAtual >= qtdRetirada) { // Verifica se há estoque suficiente
                    produto.setQtdProduto(estoqueAtual - qtdRetirada); // Atualiza o estoque do produto
                    repPro.save(produto); // Salva o produto com o estoque atualizado
                    System.out.println("Estoque atualizado com sucesso. Produtos restantes: " + produto.getQtdProduto());
                } 
                else {
                    System.out.println("Estoque insuficiente para realizar a retirada.");
                }
            } 
            else {
                System.out.println("Produto associado ao item de venda não encontrado.");
            }
        } 
        else {
            System.out.println("Item de venda não encontrado.");
        }
    }

    //serVenIt.retirarItens(3L); para fazer o teste

}
