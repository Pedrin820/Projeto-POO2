import domain.repository.FuncionarioRepository;
import view.MenuInicial;

public class Main {
    public static void main(String[] args) {
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        funcionarioRepository.inserirFuncionarios();

        MenuInicial menuInicial = new MenuInicial();
        menuInicial.criarMenuInicial();
    }
}