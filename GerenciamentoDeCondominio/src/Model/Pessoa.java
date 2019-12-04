/*
 * Classe Model para Pessoa
 */
package Model;

import Database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class Pessoa {
    
    //Construtor da classe Pessoa
    public Pessoa(){
        this.tabelaBD = "PESSOAS";
        con = new Conexao();//Inicializar instância da classe de conexão
    }
    
    //Nome da tabela no banco de dados
    public final String tabelaBD;
    
    //Atributos de Pessoa
    protected int id;
    protected String login;
    protected String senha;
    
    //Conexão
    private final Conexao con;
    
    
    //Métodos
    public boolean Cadastrar(){
        String comandoSQL = "INSERT INTO " + this.tabelaBD + "(LOGIN, SENHA) VALUES (?, ?)";
        
        try{
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setString(1, this.getLogin());
            query.setString(2, this.getSenha());
            query.executeUpdate();
            
            return true;
        }
        catch (Exception erro){
            return false;
        }
    }
    
    public List<Pessoa> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM " + this.tabelaBD + ";";
        
        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<Pessoa> listaDePessoas = new LinkedList<>();
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();
            
            while (resultadoConsulta.next()) { 
                //PREENCHER ITEM
                Pessoa pessoa = new Pessoa();
                pessoa.setId(resultadoConsulta.getInt("id"));
                pessoa.setLogin(resultadoConsulta.getString("login"));
                pessoa.setSenha(resultadoConsulta.getString("senha"));
                
                //ADICIONAR NOVA PESSOA À LISTA
                listaDePessoas.add(pessoa);
            }
            
            // RETORNAR LISTA PREENCHIDA
            return listaDePessoas;
            
            
        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return null;
        }
    }
    
    /**
     * @return o último ID cadastrado na tabela PESSOAS. Em caso de erro é retornado o valor 0.
     */
    public int RecuperarUltimoIdCadastrado(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT ID FROM " + this.tabelaBD + " ORDER BY ID DESC LIMIT 1;";
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();
            
            //EXECUTAR COMANDO
            resultadoConsulta.next();
            
            //SALVAR ID RECUPERADO EM VARIÁVEL
            int id = resultadoConsulta.getInt("id");
                
            // RETORNAR LISTA PREENCHIDA
            return id;
            
            
        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return 0;
        }
    }
    
    //Encapsulamentos
    
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }  
}
