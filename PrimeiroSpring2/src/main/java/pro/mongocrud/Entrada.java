package pro.mongocrud;

public class Entrada {

    private int id;
    private String email;
    private String senha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return email;
    }

    public void setNome(String nome) {
        this.email = nome;
    }

    public String getProfissao() {
        return senha;
    }

    public void setProfissao(String profissao) {
        this.senha = profissao;
    }
}
