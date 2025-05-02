package ufrn.br.exemplodeploy.model;

import java.util.ArrayList;

public class Carrinho {

    ArrayList<Produto> produtos;

    public Carrinho(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto(int posicao) {
        for(Produto produto : produtos) {
            if(produto.getId() == posicao) {
                return produto;
            }
        }
        return null;
    }
    public void removeProduto(int id) {
        Produto produto = getProduto(id);
        produtos.remove(produto);
    }

    public void addProduto(Produto produto) {
        produtos.add(produto);
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
}
