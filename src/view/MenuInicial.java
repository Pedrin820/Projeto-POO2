package view;

import domain.model.Funcionario;
import domain.repository.FuncionarioRepository;
import service.FuncionarioService;

import java.util.Scanner;
public class MenuInicial {
    FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
    FuncionarioService funcionarioService = new FuncionarioService();

    public void criarMenuInicial() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
            BEM-VINDO AO SISTEMA DA BIBLIOTECA!
                        
            1. Registro
            2. Login
            0. Sair
                
            ->\s""");

        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1" -> registrarFuncionario();
            case "2" -> logarFuncionario();
            case "0" -> System.exit(0);
            default -> System.out.println("Opção inválida!");
        }
    }

    private void registrarFuncionario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o seu login: ");
        String login = scanner.nextLine();

        if (funcionarioService.hasFuncionarioCadastrado(login)){
            System.out.println("Já existe um funcionário cadastrado com esse login");
            criarMenuInicial();
        } else {
            System.out.print("Digite sua Senha: ");
            String senha = scanner.nextLine();

            funcionarioRepository.getListaFuncionarios().add(new Funcionario(login, senha));
            funcionarioRepository.salvarFuncionarios();

            criarMenuInicial();
        }
    }

    private void logarFuncionario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Funcionario funcionario : funcionarioRepository.getListaFuncionarios()) {
            if (funcionario.getLogin().equalsIgnoreCase(login) && funcionario.getSenha().equalsIgnoreCase(senha)) {
                System.out.println("Bem-vindo, " + funcionario.getLogin() + "!");
                MenuPrincipal.menuPrincipal();
            }
        }
        System.out.println("Login ou senha incorreto(s)!");
        criarMenuInicial();
    }
}
