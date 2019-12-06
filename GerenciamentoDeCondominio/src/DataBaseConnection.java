package eng3_condominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseConnection {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/eng_sw_3";
		String usuario = "root";
		String senha = "91154743";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception error) {
			System.out.println("Erro: " + error.getMessage());
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
			System.out.println("ESTÁ CONECTADO");
			return true;
		} else {
			return false;
		}
	}

	public void inserirLocadores(int idPessoa, Date dtLocacao, int numeroSala) {
		try {
			String query = "INSERT INTO locadores (pessoa_id, dt_cadastro, sala_id) VALUES ('"
					+ idPessoa  + "', '" + dtLocacao + "', '" + numeroSala+ "');";
			this.statement.executeUpdate(query);
		} catch (Exception error) {
			System.out.println("Erro: " + error.getMessage());
		}
	}

	public void editarLocadores(int idPessoa, Date dtLocacao, int numeroSala) {
		try {
			String query = "UPDATE tabela_produto SET pessoaId = '" + idPessoa + "', dtCadastro= '" + dtLocacao	+ "' WHERE ID_PROD = '" + numeroSala + "';";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception error) {
			System.out.println("Erro: " + error.getMessage());
		}
	}

	public void apagarLocadores(String id) {
		try {
			String query = "DELETE FROM tabela_produto WHERE ID_PROD = " + id + ";";
			this.statement.executeUpdate(query);
		} catch (Exception error) {
			System.out.println("Erro: " + error.getMessage());
		}
	}

	public void desconectar() {
		try {
			this.connection.close();
			System.out.println("ESTÁ DESCONECTADO");
		} catch (Exception error) {
			System.out.println("Erro: " + error.getMessage());
		}
	}
}
