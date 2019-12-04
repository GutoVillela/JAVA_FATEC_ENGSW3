/*
 * Classe Controller para Pessoa Física
 */
package Controller;

import Model.PessoaFisica;

/**
 *
 * @author Gustavo
 */
public class PessoaFisicaController {
    
    public boolean Cadastrar(PessoaFisica pf){
        
        //Tratamento de erros
        try{
            //Cadastrar Pessoa
            if(pf.Cadastrar()){
                //Cadastrar Pessoa Física associada à Pessoa Cadastrada
                return pf.CadastrarPessoaFisica(pf.RecuperarUltimoIdCadastrado());
            }else{
                return false;
            }
        }
        catch(Exception erro){
            return false;
        }
        
        
        
    }
    
}
