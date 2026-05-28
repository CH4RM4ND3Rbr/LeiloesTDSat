package LeiloesTDSat;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProdutosDAO {
    
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto(ProdutosDTO produto){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("produtos.txt", true))) {
            // grava cada produto em uma linha, separado por ponto e vírgula
            bw.write(produto.getNome() + ";" + produto.getValor() + ";" + produto.getStatus());
            bw.newLine();
            bw.flush();
            
            // também adiciona na lista em memória
            listagem.add(produto);
            
            System.out.println("Produto salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar produto: " + e.getMessage());
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        return listagem;
    }
}
