package view;

import domain.repository.BibliotecaRepository;
import domain.repository.FuncionarioRepository;
import service.BibliotecaService;
import service.ClienteService;

import java.util.Scanner;

public class MenuClientes {

    public static void menuClientes(){
        Scanner scanner = new Scanner(System.in);
        var repository = FuncionarioRepository.getInstancia();

        repository.salvarFuncionarios();

        System.out.print("""
                # Digite o que você deseja fazer:
                #
                # 1. Lista de clientes
                # 2. Adicionar clientes
                # 3. Remover clientes
                # 4. Pegar um livro emprestado
                # 5. Devolver um livro
                # 0. Voltar
                # ->\s""");

        String escolha = scanner.nextLine();
        switch (escolha) {
            case "1" -> {
                ClienteService.listarClientes();
            }
            case "2" -> {
                ClienteService.adicionarCliente();
            }
            case "3" -> {
                ClienteService.removerCliente();
            }
            case "4" -> {
                BibliotecaService.emprestarLivro();
            }
            case "5" -> {
                BibliotecaService.devolverLivro();
            }
            case "0" -> MenuPrincipal.menuPrincipal();
            default -> System.out.println("Opção inválida!");

        }
    }
}
