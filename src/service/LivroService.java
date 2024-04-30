package service;

import domain.repository.BibliotecaRepository;

import java.util.Random;
import java.util.Scanner;

import domain.model.Livro;
import view.MenuPrincipal;

public class LivroService {

    public static void adicionarLivro() {
        LivroService.listarLivros();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título: ");
        String titulo = scanner.nextLine();

        if (hasLivroPorTitulo(titulo)) {
            System.out.println("Esse livro já está cadastrado!");
        } else {
            System.out.print("Digite o nome do autor: ");
            String autor = scanner.nextLine();

            long id = gerarIdAleatorio();

            BibliotecaRepository.listaLivros.add(new Livro(id, titulo.toUpperCase(), autor.toUpperCase(), "DISPONÍVEL"));
            System.out.println("Livro adicionado com sucesso!");
            BibliotecaRepository.salvarLivros();
        }
    }

    public static void inserirHqsNoArray() {
        BibliotecaRepository.listaHqs.add(new Livro((long) 10203, "Superman: Origem", "DC Comics", "DISPONIVEL"));
        BibliotecaRepository.listaHqs.add(new Livro((long) 10302, "Superman: Filho vermelho", "DC Comics", "DISPONIVEL"));
        BibliotecaRepository.listaHqs.add(new Livro((long) 20918, "Superman: Origem Secreta", "DC Comics", "DISPONIVEL"));
        BibliotecaRepository.listaHqs.add(new Livro((long) 20303, "Superman: Por Todas as Estações", "DC Comics", "DISPONIVEL"));
        BibliotecaRepository.listaHqs.add(new Livro((long) 73821, "Superman: Último Filho de Krypton", "DC Comics", "DISPONIVEL"));
        BibliotecaRepository.listaHqs.add(new Livro((long) 20453, "Como Derrotar o Superman usando Java", "DC Comics", "DISPONIVEL"));
    }

    public static void removerLivro() {
        LivroService.listarLivros();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o ID do livro que deseja remover: ");
        long id = scanner.nextLong();

        for (Livro livro : BibliotecaRepository.listaLivros){
            if (livro.getIdLivro() == id) {
                BibliotecaRepository.listaLivros.remove(livro);
                System.out.println("Livro removido com sucesso!");
                BibliotecaRepository.salvarLivros();
                MenuPrincipal.menuPrincipal();
            }
        }
        System.out.println("ID inválido!");
    }

    public static boolean hasLivroPorTitulo(String tituloLivro) {
        for (Livro livro : BibliotecaRepository.listaLivros) {
            if (livro.getTitulo().equalsIgnoreCase(tituloLivro)) return true;
        }
        return false;
    }


    public static long gerarIdAleatorio() {
        Random random = new Random();
        return random.nextLong(1, 99999);
    }

    public static void listarLivros() {
        for (Livro livro : BibliotecaRepository.listaLivros) {
            System.out.println(livro);
        }
    }

    public static void listarHqs() {
        for (Livro hq : BibliotecaRepository.listaHqs) {
            System.out.println(hq);
        }
    }
}