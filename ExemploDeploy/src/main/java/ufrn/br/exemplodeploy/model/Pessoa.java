package ufrn.br.exemplodeploy.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa {
    private String nome;
    private String email;
    private String senha;

    public Pessoa(String email, String nome, String senha) {
        this.email = email;
        this.nome = nome;
        this.senha = senha;
    }

    public Pessoa() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
