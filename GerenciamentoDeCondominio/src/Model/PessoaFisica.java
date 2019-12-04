/*
 * Classe Model para Pessoa Física
 */
package Model;

import Database.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class PessoaFisica extends Pessoa{
    
    //Construtor da classe Pessoa Física
    public PessoaFisica(){
        this.tabelaBD = "PESSOAS_FISICAS";
        con = new Conexao();//Inicializar instância da classe de conexão
    }
    
    //Nome da tabela no banco de dados
    public final String tabelaBD;
    
    //Atributos de Pessoa Física
    private String nome;
    private String cpf;
    private Date dtNascimento;
    
    //Conexão
    private final Conexao con;

    //Métodos
    
    /**
     * @param idPessoa id da pessoa na tabela PESSOAS a ser assossiada na tabela PESSOAS_FISICAS.
     * @return true caso cadastro tenha ocorrido com sucesso, false caso tenha ocorrido algum erro.
     */
    public boolean CadastrarPessoaFisica(int idPessoa){
        // CRIANDO COMANDO SQL
        String comandoSQL = "INSERT INTO " + this.tabelaBD + " (pessoa_id, nome, cpf, dt_nascimento) VALUES (?, ?, ?, ?);";
        
        // TRATAMENTO DE ERRO
        try {
            
            // PREPARANDO QUERY PARA EXECUÇÃO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, idPessoa);
            query.setString(2, this.getNome());
            query.setString(3, this.getCpf());
            query.setDate(4, new java.sql.Date(this.getDtNascimento().getTime()));
            
            
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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the dt_nascimento
     */
    public Date getDtNascimento() {
        return dtNascimento;
    }

    /**
     * @param dtNascimento the dt_nascimento to set
     */
    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    
    
    
}
