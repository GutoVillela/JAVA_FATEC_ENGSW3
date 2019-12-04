/*
 * Classe Model para Pessoa Física
 */
package Model;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class PessoaFisica extends Pessoa{
    
    protected String nome;
    protected String cpf;
    protected Date dtNascimento;

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
     * @param dt_nascimento the dt_nascimento to set
     */
    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }
    
    
    
}
