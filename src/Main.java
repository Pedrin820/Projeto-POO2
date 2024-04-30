import domain.repository.BibliotecaRepository;
import domain.repository.FuncionarioRepository;
import view.MenuInicial;

public class Main {
    public static void main(String[] args) {
        FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
        funcionarioRepository.inserirFuncionarios();

        BibliotecaRepository bibliotecaRepository = new BibliotecaRepository();
        bibliotecaRepository.inserirClientes();
        bibliotecaRepository.inserirLivros();

        new MenuInicial();
    }
}