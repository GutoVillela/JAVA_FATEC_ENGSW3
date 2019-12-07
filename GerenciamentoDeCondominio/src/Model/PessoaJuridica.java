/*
 * Classe Model para Pessoa Jurídica
 */
package Model;

import Database.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class PessoaJuridica extends Pessoa {
    
    //Construtor da classe Pessoa Física
    public PessoaJuridica(){
        this.tabelaBD = "PESSOAS_JURIDICAS";
        con = new Conexao();//Inicializar instância da classe de conexão
    }
    
    //Nome da tabela no banco de dados e dos campos
    private final String tabelaBD;
    
    //Conexão
    private final Conexao con;
    
    // Atributos para Pessoa Jurídica
    protected String razaoSocial;
    protected String cnpj;
    
    //Métodos
    
    /**
     * @param idPessoa id da pessoa na tabela PESSOAS a ser assossiada na tabela PESSOAS_FISICAS.
     * @return true caso cadastro tenha ocorrido com sucesso, false caso tenha ocorrido algum erro.
     */
    public boolean CadastrarPessoaJuridica(int idPessoa){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO " + this.tabelaBD + " (pessoa_id, razao_social, cnpj) VALUES (?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, idPessoa);
            query.setString(2, this.getRazaoSocial());
            query.setString(3, this.getCnpj());
            
            
            // EXECUTAR COMANDO
            query.executeUpdate();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + ex);
            return false;
        }
    }
    
    //Encapsulamentos

    /**
     * @return the razaoSocial
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }

    /**
     * @param razaoSocial the razaoSocial to set
     */
    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
