package view;

import domain.model.Cliente;
import service.ClienteService;
import service.LivroService;

import java.util.Scanner;

public class MenuPrincipal {

    public MenuPrincipal() {
        menuPrincipal();
    }

    public static void menuPrincipal() {
        boolean running = true;

        while (running) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("""
                    # BEM-VINDO AO SISTEMA PRINCIPAL. DIGITE QUAL SERÁ A SUA AÇÃO:
                    #
                    # 1. Menu de livros
                    # 2. Menu de clientes
                    # 0. Sair
                    #               
                    # ->\s""");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1" -> {
                    MenuLivros.menuLivros();
                }
                case "2" -> {
                    MenuClientes.menuClientes();
                }
                case "0" -> new MenuInicial();
                default -> System.out.println("Opção inválida!");
            }
        }
    }
}
