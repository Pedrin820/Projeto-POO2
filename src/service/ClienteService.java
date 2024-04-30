package service;


import domain.model.Cliente;
import domain.repository.BibliotecaRepository;
import view.MenuPrincipal;

import java.util.Random;
import java.util.Scanner;

public class ClienteService {
    
    public static void adicionarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Digite o nome do cliente: ");
        String nome = scanner.nextLine();

        System.out.printf("Digite o endereço do cliente: ");
        String endereco = scanner.nextLine();

        System.out.printf("Digite o telefone do cliente: ");
        String telefone = scanner.nextLine();

        long id = gerarIdCliente();

        Cliente cliente = new Cliente(id, nome, endereco, telefone);
        BibliotecaRepository.listaClientes.add(cliente);

        System.out.println("Cliente adicionado com sucesso!");
        BibliotecaRepository.salvarClientes();
    }

    public static void removerCliente(){
        Scanner scanner = new Scanner(System.in);
        ClienteService.listarClientes();

        System.out.println("Digite o ID do cliente que deseja remover: ");
        long id = scanner.nextLong();

        for(Cliente cliente : BibliotecaRepository.listaClientes){
            if(cliente.getId() == id){
                BibliotecaRepository.listaClientes.remove(cliente);
                System.out.println("Cliente removido com sucesso");
                MenuPrincipal.menuPrincipal();
            }
        }

        System.out.println("ID inválido!");

    }

    public static void listarClientes() {
        for (Cliente cliente : BibliotecaRepository.listaClientes) {
            System.out.println(cliente);
        }
    }

    public static long gerarIdCliente() {
        Random random = new Random();
        return random.nextLong(1, 99999);
    }
}
