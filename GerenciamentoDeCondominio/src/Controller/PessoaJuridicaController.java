/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.PessoaJuridica;

/**
 *
 * @author gusta
 */
public class PessoaJuridicaController {
    public boolean Cadastrar(PessoaJuridica pj){
        
        //Tratamento de erros
        try{
            //Cadastrar Pessoa
            if(pj.Cadastrar()){
                //Cadastrar Pessoa Física associada à Pessoa Cadastrada
                return pj.CadastrarPessoaJuridica(pj.RecuperarUltimoIdCadastrado());
            }else{
                return false;
            }
        }
        catch(Exception erro){
            return false;
        }
        
    }
    
    public int RecuperarIdUltimaPessoaJuridicaCadastrada(){
        PessoaJuridica pj = new PessoaJuridica();
        return pj.RecuperarUltimoIdCadastrado();
    }
}
