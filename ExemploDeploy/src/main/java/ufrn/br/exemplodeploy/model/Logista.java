package ufrn.br.exemplodeploy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "logista")
public class Logista extends Pessoa{
    @Id
    private long id;
    public Logista(String email, String nome, String senha) {
        super(email, nome, senha);
    }

    public Logista() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
