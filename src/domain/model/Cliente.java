package domain.model;

import java.util.ArrayList;

public class Cliente extends Pessoa {

    private long id;
    private ArrayList<Livro> livros = new ArrayList<>();

    public Cliente(long id, String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return String.format("ID: %s | Nome: %s | Livros: %s", getId(), getNome(), getLivros().toString());
    }
}
