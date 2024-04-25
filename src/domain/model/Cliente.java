package domain.model;

public class Cliente extends Pessoa {

    private String id;

    public Cliente(String id, String nome, String endereco, String telefone) {
        super(nome, endereco, telefone);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
