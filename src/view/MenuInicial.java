package view;

import domain.model.Funcionario;
import domain.repository.FuncionarioRepository;
import service.FuncionarioService;

import java.util.Scanner;

public class MenuInicial {
    public MenuInicial() {
        criarMenuInicial();
    }

    public void criarMenuInicial() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
            # BEM-VINDO AO SISTEMA DA BIBLIOTECA!
            #            
            # 1. Registro
            # 2. Login
            # 0. Sair
            #    
            # ->\s""");

        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1" -> {
                FuncionarioService.registrarFuncionario();
            }
            case "2" -> {
                FuncionarioService.logarFuncionario();
            }
            case "0" -> System.exit(0);
            default -> System.out.println("Opção inválida!");
        }
    }
}
