package domain.model;

public class Funcionario {

    private String login;
    private String senha;

    public Funcionario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    @Override
    public String toString() {
        return String.format("Login: %s | Senha: %s", getLogin(), getSenha());
    }
}
