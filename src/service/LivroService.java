package service;

import domain.model.Livro;
import domain.model.LivroStatus;
import domain.repository.BibliotecaRepository;

import java.util.Scanner;

public class LivroService {

    BibliotecaRepository bibliotecaRepository = new BibliotecaRepository();
    BibliotecaService bibliotecaService = new BibliotecaService();

    public void adicionarLivro() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o título:");
        String titulo = scanner.nextLine();

        System.out.println("Digite o nome do autor: ");
        String autor = scanner.nextLine();

        Livro livro = new Livro("1", titulo, autor, LivroStatus.DISPONIVEL);
        bibliotecaRepository.listaLivros().add(livro);
    }

    public void removerLivro() {
        Scanner scanner = new Scanner(System.in);

        int i = 0;
        for (Livro livro : bibliotecaRepository.listaLivros()) {
            System.out.println(i + " | " + livro);
            i++;
        }

        System.out.print("ID do livro para remover: ");

        int idLivro = scanner.nextInt();

        bibliotecaRepository.listaLivros().remove(idLivro);
    }

    public boolean livroCadastrado(String livroTitulo) {
        for (Livro livro : bibliotecaRepository.listaLivros()) {
            if (livroTitulo.equalsIgnoreCase(livro.getTitulo())) {
                return true;
            }
        }
        return false;
    }
}
