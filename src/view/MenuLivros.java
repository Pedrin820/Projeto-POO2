package view;

import service.LivroService;

import java.util.Scanner;

public class MenuLivros {
    public static void menuLivros() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("""
                
                # Digite o que você deseja fazer:
                #
                # 1. Lista de livros
                # 2. Adicionar livro
                # 3. Remover livro
                # 0. Voltar
                # ->\s""");

        String escolha = scanner.nextLine();

        switch (escolha) {
            case "1" -> {
                LivroService.listarLivros();
            }
            case "2" -> {
                LivroService.adicionarLivro();
            }
            case "3" -> {
                LivroService.removerLivro();
            }
            case "0" -> MenuPrincipal.menuPrincipal();
            default -> System.out.println("Opção inválida!");
        }
    }
}
