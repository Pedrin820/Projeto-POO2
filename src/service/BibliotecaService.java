package service;

import domain.model.Livro;
import domain.repository.BibliotecaRepository;

public class BibliotecaService {
    BibliotecaRepository bibliotecaRepository = new BibliotecaRepository();

//    public void listarLivrosEmLista() {
//        int i = 0;
//        for (Livro livro : bibliotecaRepository.listaLivros()) {
//            System.out.println(i + " | " + livro);
//            i++;
//        }
//    }
}
