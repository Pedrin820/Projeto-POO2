package domain.repository;

import domain.model.Biblioteca;
import domain.model.Cliente;
import domain.model.Livro;

import java.util.ArrayList;

public class BibliotecaRepository implements Biblioteca {
    private ArrayList<Livro> listaLivros = new ArrayList<>();
    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    @Override
    public ArrayList<Livro> listaLivros() {
        return listaLivros;
    }

    @Override
    public ArrayList<Cliente> listaClientes() {
        return listaClientes;
    }
}
