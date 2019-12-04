/*
 * Classe Controller para Pessoa
 */
package Controller;

import Model.Pessoa;

/**
 *
 * @author Gustavo
 */
public class PessoaController {
    
    public boolean Cadastrar(Pessoa pessoa){
        return pessoa.Cadastrar();
    }
    
}
