/*
 * Classe Controller para Locador
 */
package Controller;

import Model.Locador;

/**
 *
 * @author Gustavo
 */
public class LocadorController {
    
    public boolean Cadastrar(Locador locador){
        
        if(locador.getTipoDeLocador() == "PF"){
            PessoaFisicaController pfController = new PessoaFisicaController();
            pfController.Cadastrar(locador.getPf());
            locador.setPessoaId(pfController.RecuperarIdUltimaPessoaFisicaCadastrada());
            locador.Cadastrar();
        }
        else if(locador.getTipoDeLocador() == "PJ"){
            PessoaJuridicaController pjController = new PessoaJuridicaController();
            pjController.Cadastrar(locador.getPj());
            locador.setPessoaId(pjController.RecuperarIdUltimaPessoaJuridicaCadastrada());
            locador.Cadastrar();
        }
        
        return true;
    }
    
}
