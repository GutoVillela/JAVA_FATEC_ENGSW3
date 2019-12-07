/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Sala;
import java.sql.SQLException;

/**
 *
 * @author alexandre
 */
public class SalaController {

    public boolean cadastrar(Sala s) {
        return s.cadastrar(s);
    }

    public boolean remover(Sala s) {
        return s.deletar(s);
    }

    public boolean buscar(int id) throws SQLException {
        Sala s = new Sala();
        return (s.buscar(id)) != null;
    }
    
    public boolean atualizar(Sala s) {
        return (new Sala().atualizar(s));                
    }
}