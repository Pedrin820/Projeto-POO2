package view;

import service.ClienteService;
import service.LivroService;

import java.util.Scanner;

public class MenuPrincipal {
    public static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        LivroService livroService = new LivroService();
        ClienteService clienteService = new ClienteService();

        boolean running = true;
        while (running) {
            System.out.println("""
                    BEM-VINDO AO SISTEMA PRINCIPAL. DIGITE QUAL SERÁ A SUA AÇÃO:
                    
                    1. Adicionar livro
                    2. Remover livro
                    3. Adicionar cliente
                    4. Remover Cliente
                    5. Emprestar livro
                    6. Devolver livro
                    0. Sair
                                       
                    ->\s""");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1" -> livroService.adicionarLivro();
                case "2" -> livroService.removerLivro();
            }
        }
    }
}
