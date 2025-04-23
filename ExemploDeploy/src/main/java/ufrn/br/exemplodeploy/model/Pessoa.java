package ufrn.br.exemplodeploy.model;

public class Pessoa {
    private String nome;
    private String email;
    private String senha;

    public Pessoa(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

}
