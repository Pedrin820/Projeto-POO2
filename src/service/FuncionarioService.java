package service;

import domain.model.Funcionario;
import domain.repository.FuncionarioRepository;

public class FuncionarioService {
    FuncionarioRepository funcionarioRepository = new FuncionarioRepository();

    public boolean hasFuncionarioCadastrado(String login) {
        for (Funcionario funcionario : funcionarioRepository.getListaFuncionarios()) {
            if (login.equalsIgnoreCase(funcionario.getLogin())) {
                return true;
            }
        }
        return false;
    }
}
