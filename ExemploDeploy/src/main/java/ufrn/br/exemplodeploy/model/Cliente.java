package ufrn.br.exemplodeploy.model;

import jakarta.persistence.*;


@Entity
@Table(name = "cliente")
public class Cliente extends Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf", nullable = false, unique = true)
    private String cpf;

    public Cliente() {
    }

    public Cliente(String email, String nome, String senha, String cpf) {
        super(email, nome, senha);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
