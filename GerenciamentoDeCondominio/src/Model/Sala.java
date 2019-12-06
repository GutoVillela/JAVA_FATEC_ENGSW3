package Model;

import Database.Conexao;
import java.sql.*;

/**
 *
 * @author alexandre
 */
public class Sala {

    private int id;
    private int numero;
    private int bloco;
    private int andar;
    private int proprietario;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getBloco() {
        return bloco;
    }

    public void setBloco(int bloco) {
        this.bloco = bloco;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public int getProprietario() {
        return proprietario;
    }

    public void setProprietario(int proprietario) {
        this.proprietario = proprietario;
    }

    public boolean cadastrar(Sala s) {
        Conexao con = new Conexao();
        String comandoSQL = "INSERT INTO SALAS (numero, bloco, andar, proprietario) VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, s.getNumero());
            query.setInt(2, s.getBloco());
            query.setInt(3, s.getAndar());
            query.setInt(4, s.getProprietario());
            query.executeUpdate();

            return true;
        } catch (Exception erro) {
            System.out.println(erro.getCause());
            System.out.println(erro.getMessage());
            return false;
        }
    }

    public boolean deletar(Sala s) {
        Conexao con = new Conexao();
        String comandoSQL = "DELETE FROM SALAS WHERE id = ?;";
        //String comandoSQL2 = "SET GLOBAL FOREIGN_KEY_CHECKS=0;";

        try {
            //PreparedStatement query2 = con.Conectar().prepareStatement(comandoSQL2);
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, s.getId());
            //query2.execute();
            query.execute();
            System.out.println("Ok");

            return true;
        } catch (Exception erro) {
            System.out.println(erro.getCause());
            System.out.println(erro.getMessage());
            return false;
        }
    }

    public boolean atualizar(Sala s) {
        Conexao con = new Conexao();
        String comandoSQL = "UPDATE SALAS set numero = ?, bloco = ?, andar = ?, proprietario = ? where id = ?;";

        try {
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, s.getNumero());
            query.setInt(2, s.getBloco());
            query.setInt(3, s.getAndar());
            query.setInt(4, s.getProprietario());
            query.setInt(5, s.getId());
            query.executeUpdate();

            return true;
        } catch (Exception erro) {
            System.out.println(erro.getCause());
            System.out.println(erro.getMessage());
            return false;
        }

    }

    public Sala buscar(int id) throws SQLException {
        Sala s = new Sala();
        Conexao con = new Conexao();
        String comandoSQL = "SELECT numero, bloco, andar, proprietario from SALAS where id = ?;";
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, id);

            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();

            if (resultadoConsulta.next()) {
                //PREENCHER ITEM                                
                s.setNumero(resultadoConsulta.getInt("numero"));
                s.setBloco(resultadoConsulta.getInt("bloco"));
                s.setAndar(resultadoConsulta.getInt("andar"));
                s.setProprietario(resultadoConsulta.getInt("proprietario"));
                System.out.println("----->" + s.getProprietario());
            } else {
                s = null;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }
}
