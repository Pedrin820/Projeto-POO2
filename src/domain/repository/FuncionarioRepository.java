package domain.repository;

import domain.model.Funcionario;
import java.io.*;

import java.util.ArrayList;

public class FuncionarioRepository {
    private ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();
    private final String arquivo = "src/utils/funcionarios.txt";

    public ArrayList<Funcionario> getListaFuncionarios() {
        return listaFuncionarios;
    }

    public void inserirFuncionarios() {
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linhaInserir;
            while ((linhaInserir = br.readLine()) != null) {
                String[] dados = linhaInserir.split(",");
                Funcionario funcionario = new Funcionario(dados[0], dados[1]);
                listaFuncionarios.add(funcionario);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void salvarFuncionarios() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (Funcionario funcionario : listaFuncionarios) {
                String linhaSalvar = funcionario.getLogin().toUpperCase() + "," + funcionario.getSenha().toUpperCase();
                bw.write(linhaSalvar);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
