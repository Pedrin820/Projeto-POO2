package domain.repository;

import domain.model.Cliente;
import domain.model.Funcionario;
import domain.model.Livro;

import java.io.*;
import java.util.ArrayList;

public class BibliotecaRepository {

    private static BibliotecaRepository instancia;

    public static ArrayList<Livro> listaLivros = new ArrayList<>();
    public static ArrayList<Cliente> listaClientes = new ArrayList<>();

    public static ArrayList<Livro> listaHqs = new ArrayList<>();

    private static String arquivoClientes = "src/utils/Cliente.txt";
    private static String arquivoLivros = "src/utils/Livros.txt";

    public static BibliotecaRepository getInstancia() {
        if (instancia == null) {
            instancia = new BibliotecaRepository();
        }
        return instancia;
    }

    public void inserirClientes() { // insere os clientes do txt no array
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoClientes))) {
            String linhaInserir;
            while ((linhaInserir = br.readLine()) != null) {
                String[] dadosClientes = linhaInserir.split(",");
                long id = Long.parseLong(dadosClientes[0]);
                Cliente cliente = new Cliente(id, dadosClientes[1], dadosClientes[2], dadosClientes[3]);
                listaClientes.add(cliente);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void salvarClientes() { // inserere os funcionarios do array no txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoClientes))) {
            for (Cliente cliente : listaClientes) {
                String linhaSalvar =
                        cliente.getId()  + ","
                        + cliente.getNome().toUpperCase() + ","
                        + cliente.getEndereco().toUpperCase() + ","
                        + cliente.getTelefone().toUpperCase() + ","
                        + cliente.getLivros().toString().toUpperCase();
                bw.write(linhaSalvar);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void inserirLivros() { // insere os livros do txt no array
        try (BufferedReader br = new BufferedReader(new FileReader(arquivoLivros))) {
            String linhaInserirLivros;
            while ((linhaInserirLivros = br.readLine()) != null) {
                String[] dados = linhaInserirLivros.split(",");
                long idLivro = Long.parseLong(dados[0]);
                Livro livro = new Livro(idLivro, dados[1], dados[2], dados[3]);
                listaLivros.add(livro);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void salvarLivros() { // inserere os livros do array no txt
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoLivros))) {
            for (Livro livro : listaLivros) {
                String linhaSalvarLivros =
                        livro.getIdLivro()  + ","
                                + livro.getTitulo().toUpperCase() + ","
                                + livro.getAutor().toUpperCase() + ","
                                + livro.getStatus().toUpperCase();
                bw.write(linhaSalvarLivros);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Livro> getListaLivros() {
        return listaLivros;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }
}
