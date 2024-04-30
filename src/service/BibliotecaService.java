package service;

import domain.model.Cliente;
import domain.model.Livro;
import domain.repository.BibliotecaRepository;
import view.MenuPrincipal;

import java.util.Scanner;

public class BibliotecaService {

    private static Livro livroEmprestado;

    public static void emprestarLivro(){
        Scanner scanner = new Scanner(System.in);
        ClienteService.listarClientes();

        System.out.println("Digite o ID do cliente que irá pegar o livro: ");
        long idCliente = scanner.nextLong();

        if (idCliente == 10000) {
            LivroService.inserirHqsNoArray();
            LivroService.listarHqs();

            System.out.println("Digite o ID do livro que deseja: ");
            long idLivro = scanner.nextLong();

            if (hqValida(idLivro)) {
                Cliente cliente = getClienteValido(idCliente);
                cliente.getLivros().add(livroEmprestado);
                livroEmprestado.setStatus("INDISPONÍVEL");
                System.out.println("Livro emprestado com sucesso.");
                MenuPrincipal.menuPrincipal();
            }
        } else {
            if (clienteValido(idCliente)) {
                LivroService.listarLivros();

                System.out.print("Digite o ID do livro que deseja: ");
                long idLivro = scanner.nextLong();

                if (!livroValido(idLivro) || !livroDisponivel(idLivro)) {
                    System.out.println("Livro inválido ou indisponível!");
                    MenuPrincipal.menuPrincipal();
                } else {
                    Cliente cliente = getClienteValido(idCliente);

                    cliente.getLivros().add(livroEmprestado);
                    livroEmprestado.setStatus("INDISPONÍVEL");
                    System.out.println("Livro emprestado com sucesso.");
                    MenuPrincipal.menuPrincipal();

                }
            } else {
                System.out.println("Cliente inválido!");
                MenuPrincipal.menuPrincipal();
            }
        }
    }

    public static void devolverLivro() {
        Scanner scanner = new Scanner(System.in);
        ClienteService.listarClientes();


        System.out.println("Digite o ID do cliente que irá devolver o livro: ");
        long idCliente = scanner.nextLong();

        if (clienteValido(idCliente)) {
            LivroService.listarLivros();

            System.out.print("Digite o ID do livro que deseja devolver: ");
            long idLivro = scanner.nextLong();

            if (livroValido(idLivro)) {

                Cliente cliente = getClienteValido(idCliente);

                cliente.getLivros().remove(livroEmprestado);
                livroEmprestado.setStatus("DISPONÍVEL");
                System.out.println("Livro devolvido com sucesso.");
                MenuPrincipal.menuPrincipal();
            } else {
                System.out.println("Cliente inválido!");
                MenuPrincipal.menuPrincipal();
            }
        } else {
            System.out.println("Livro inválido!");
            MenuPrincipal.menuPrincipal();
        }
    }

    private static boolean livroValido(long idLivro) {
        for (Livro livro : BibliotecaRepository.listaLivros){
            if (livro.getIdLivro() == idLivro){
                setLivroEmprestado(livro);
                return true;
            }
        }
        return false;
    }

    private static Boolean hqValida(long idLivro) {
        for (Livro hq : BibliotecaRepository.listaHqs) {
            if (hq.getIdLivro() == idLivro) {
                setLivroEmprestado(hq);
                return true;
            }
        }
        return false;
    }

    public static boolean clienteValido(long idCliente) {
        for (Cliente cliente : BibliotecaRepository.listaClientes) {
            if (cliente.getId() == idCliente) {
                return true;
            }
        }
        return false;
    }

    public static boolean livroDisponivel(long id) {
        for (Livro livro : BibliotecaRepository.listaLivros) {
            if (livro.idLivro == id) {
                var status = livro.getStatus().equalsIgnoreCase("DISPONÍVEL");
                return status;
            }
        }
        return false;
    }

    public static Cliente getClienteValido(long idCliente) {
        for (Cliente cliente : BibliotecaRepository.listaClientes) {
            if (cliente.getId() == idCliente) {
                return cliente;
            }
        }
        return null;
    }

    private static void setLivroEmprestado(Livro livro) {
        livroEmprestado = livro;
    }
}