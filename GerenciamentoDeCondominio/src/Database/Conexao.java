/*
 * Classe que gerencia conexão com banco de dados
 */
package Database;

import java.sql.*;
/**
 *
 * @author Gustavo
 */
public class Conexao {
    //CONEXÃO
    private Connection conexao;
    
    //ATRIBUTOS PARA CONEXÃO
    private final String driver = "com.mysql.jdbc.Driver"; // ESTA LINHA CHAMA O DRIVER
    private final String url = "jdbc:mysql://localhost:3306/ENG_SW3"; // ESTE É O ENDEREÇO DO BANCO DE DADOS (VAI SER UTILIZADO PARA RECUPERAR UMA STRING DE CONEXÃO MAIS A FRENTE)
    private final String user = "root"; // USUÁRIO DO BANCO
    private final String password = ""; // ESTA É A SENHA PARA CONECTAR COM O BANCO DE DADOS
    
    public Connection Conectar() {
        conexao = null; // INICIAR UMA CONEXAO VAZIA

        try {
            Class.forName(driver);

            conexao = DriverManager.getConnection(url, user, password); // RETORNAR CONEXÃO USANDO ENDERECO DO BANCO, USUARIO E SENHA
            System.out.println("CONEXÃO BEM SUCEDIDA COM O BANCO DE DADOS");
            return conexao; // RETORNAR A CONEXAO PREENCHIDA
        } catch (ClassNotFoundException | SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        }
    }
}
