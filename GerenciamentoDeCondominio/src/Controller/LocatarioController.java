/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Locatario;

/**
 *
 * @author gusta
 */
public class LocatarioController {
    
    public boolean Cadastrar(Locatario locatario){
        
        if(locatario.getTipoDeLocatario() == "PF"){
            PessoaFisicaController pfController = new PessoaFisicaController();
            pfController.Cadastrar(locatario.getPf());
            locatario.setPessoaId(pfController.RecuperarIdUltimaPessoaFisicaCadastrada());
            locatario.Cadastrar();
        }
        else if(locatario.getTipoDeLocatario() == "PJ"){
            PessoaJuridicaController pjController = new PessoaJuridicaController();
            pjController.Cadastrar(locatario.getPj());
            locatario.setPessoaId(pjController.RecuperarIdUltimaPessoaJuridicaCadastrada());
            locatario.Cadastrar();
        }
        
        return true;
    }
    
}
