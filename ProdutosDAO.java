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
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProdutosDAO {

public void cadastrarProduto(ProdutosDTO produto){
    int novoId = listarProdutos().size() + 1; // gera ID sequencial
    produto.setId(novoId);

    try (BufferedWriter bw = new BufferedWriter(new FileWriter("produtos.txt", true))) {
        bw.write(produto.getId() + ";" + produto.getNome() + ";" + produto.getValor() + ";" + produto.getStatus());
        bw.newLine();
    } catch (IOException e) {
        System.out.println("Erro ao salvar produto: " + e.getMessage());
    }
}
    public ArrayList<ProdutosDTO> listarProdutos(){
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("produtos.txt"))) {
        String linha;
        while ((linha = br.readLine()) != null) {
            if (linha.trim().isEmpty()) continue; // pula linhas vazias
            String[] dados = linha.split(";");
            if (dados.length < 4) continue; // pula linhas incompletas

            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(Integer.parseInt(dados[0]));
            produto.setNome(dados[1]);
            produto.setValor(Integer.parseInt(dados[2]));
            produto.setStatus(dados[3]);
            listagem.add(produto);
        }
    } catch (IOException e) {
        System.out.println("Erro ao ler produtos: " + e.getMessage());
    }
    return listagem;
}
}
