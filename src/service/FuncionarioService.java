package service;

import domain.model.Funcionario;
import domain.repository.FuncionarioRepository;
import view.MenuInicial;
import view.MenuPrincipal;

import java.util.Scanner;

public class FuncionarioService {

    public static void registrarFuncionario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o seu login: ");
        String login = scanner.nextLine();

        if (hasFuncionarioCadastrado(login)){
            System.out.println("Já existe um funcionário cadastrado com esse login");
            new MenuInicial();

        } else {
            System.out.print("Digite sua Senha: ");
            String senha = scanner.nextLine();

            FuncionarioRepository.listaFuncionarios.add(new Funcionario(login, senha));
            new MenuInicial();
        }
    }

    public static void logarFuncionario() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        for (Funcionario funcionario : FuncionarioRepository.listaFuncionarios) {
            if (funcionario.getLogin().equalsIgnoreCase(login) && funcionario.getSenha().equalsIgnoreCase(senha)) {
                System.out.println("Bem-vindo, " + funcionario.getLogin() + "!");
                MenuPrincipal.menuPrincipal();
            }
        }
        System.out.println("Login ou senha incorreto(s)!");
        new MenuInicial();
    }

    public static boolean hasFuncionarioCadastrado(String login) {
        for (Funcionario funcionario : FuncionarioRepository.listaFuncionarios) {
            if (login.equalsIgnoreCase(funcionario.getLogin())) {
                return true;
            }
        }
        return false;
    }
}
