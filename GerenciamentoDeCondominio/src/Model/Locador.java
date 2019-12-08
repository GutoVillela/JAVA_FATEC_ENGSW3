/*
 * Classe Model para Locador
 */
package Model;

import Database.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class Locador {

   
    //Construtor da classe Locador
    public Locador(){
        this.tabelaBD = "LOCADORES";
        con = new Conexao();//Inicializar instância da classe de conexão
    }
    
    //Nome da tabela no banco de dados
    public final String tabelaBD;
    
    //Conexão
    private final Conexao con;
    
    //Atributos para Locador
    private int pessoaId;
    private Date dtCadastro;
    private String tipoDeLocador;
    private PessoaFisica pf;
    private PessoaJuridica pj;
    
    //Métodos
    public boolean Cadastrar(){
        String comandoSQL = "INSERT INTO " + this.tabelaBD + "(PESSOA_ID, DT_CADASTRO, TIPO_DE_LOCADOR) VALUES (?, ?, ?)";
        
        try{
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            query.setInt(1, this.getPessoaId());
            query.setDate(2, new java.sql.Date(this.getDtCadastro().getTime()));
            query.setString(3, this.getTipoDeLocador());
            query.executeUpdate();
            
            return true;
        }
        catch (Exception erro){
            return false;
        }
    }
    
     public List<Locador> Consultar(){
        //DEFINIR COMANDO SQL
        String comandoSQL = "SELECT * FROM " + this.tabelaBD + " JOIN pessoas ON LOCADORES.pessoa_id = pessoas.id LEFT JOIN pessoas_fisicas ON pessoas_fisicas.pessoa_id = locadores.pessoa_id left join pessoas_juridicas on locadores.pessoa_id = pessoas_juridicas.pessoa_id;";
        
        //CRIANDO LISTA QUE VAI RECEBER TODO O RESULTADO DA CONSULTA
        List<Locador> listaDeLocadores = new LinkedList<>();
        
        try {
            //PREPARANDO COMANDO PARA SER EXECUTADO
            PreparedStatement query = con.Conectar().prepareStatement(comandoSQL);
            
            //RESULT SET QUE VAI GUARDAR O RESULTADO
            ResultSet resultadoConsulta = query.executeQuery();
            
            while (resultadoConsulta.next()) { 
                //PREENCHER ITEM
                Locador locador = new Locador();
                locador.setPessoaId(resultadoConsulta.getInt("pessoa_id"));
                locador.setDtCadastro(resultadoConsulta.getDate("dt_cadastro"));
                locador.setTipoDeLocador(resultadoConsulta.getString("tipo_de_locador"));
                
                // DEFINIR SE LOCADOR É PESSOA FÍSICA OU JURÍDICA
                if(locador.getTipoDeLocador() == "PF"){
                    PessoaFisica pf = new PessoaFisica();
                    pf.setId(resultadoConsulta.getInt("pessoa_id"));
                    pf.setNome(resultadoConsulta.getString("nome"));
                    pf.setDtNascimento(resultadoConsulta.getDate("dt_nascimento"));
                    
                    locador.setPf(pf);
                }
                else {
                    PessoaJuridica pj = new PessoaJuridica();
                    pj.setId(resultadoConsulta.getInt("pessoa_id"));
                    pj.setRazaoSocial(resultadoConsulta.getString("razao_social"));
                    pj.setCnpj(resultadoConsulta.getString("cnpj"));
                    
                    locador.setPj(pj);
                }
                
                //ADICIONAR NOVA PESSOA À LISTA
                listaDeLocadores.add(locador);
            }
            
            // RETORNAR LISTA PREENCHIDA
            return listaDeLocadores;
            
            
        } catch (Exception e) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + e);
            return null;
        }
    }
    
    //Encapsuladores
 /**
     * @return the pessoaId
     */
    public int getPessoaId() {
        return pessoaId;
    }

    /**
     * @param pessoaId the pessoaId to set
     */
    public void setPessoaId(int pessoaId) {
        this.pessoaId = pessoaId;
    }

    /**
     * @return the dtCadastro
     */
    public Date getDtCadastro() {
        return dtCadastro;
    }

    /**
     * @param dtCadastro the dtCadastro to set
     */
    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    /**
     * @return the pf
     */
    public PessoaFisica getPf() {
        return pf;
    }

    /**
     * @param pf the pf to set
     */
    public void setPf(PessoaFisica pf) {
        this.pf = pf;
    }

    /**
     * @return the pj
     */
    public PessoaJuridica getPj() {
        return pj;
    }

    /**
     * @param pj the pj to set
     */
    public void setPj(PessoaJuridica pj) {
        this.pj = pj;
    }

    /**
     * @return the tipoDeLocador
     */
    public String getTipoDeLocador() {
        return tipoDeLocador;
    }

    /**
     * @param tipoDeLocador the tipoDeLocador to set
     */
    public void setTipoDeLocador(String tipoDeLocador) {
        this.tipoDeLocador = tipoDeLocador;
    }
    
}
