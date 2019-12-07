package eng3_condominio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class LocadorView {
	
	private int idPessoa;
	private int idSala;
	private Date dataCadastro;
	
	public void setIdPessoa(int idPessoa){
		this.idPessoa = idPessoa;
	}	
	
	public int getIdPessoa() {
		return idPessoa;
	}
	
	
	public void setIdSala(int idSala){
		this.idSala = idSala;
	}
	
	public int getIdSala() {
		return idSala;
	}

	public void setDataCadastro(Date date){
		this.dataCadastro = date;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}
	
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
	
	public List<LocadorView> listarProdutos() {
		List<LocadorView> linkBancoList = new ArrayList<LocadorView>();
		try {
			String query = "SELECT * FROM LOCADORES ORDER BY dt_cadastro";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				LocadorView linkBanco = new LocadorView();
				setIdPessoa((this.resultset.getInt("id")));
				setDataCadastro((this.resultset.getDate("dt_cadastro")));
				setIdSala((this.resultset.getInt("id_sala")));
				
				linkBancoList.add(linkBanco);
				
			}
		} catch (Exception error) {
			System.out.println("Erro: " + error.getMessage());
		}
		return linkBancoList;
	}

	public void inserirLocadores(int idPessoa, Date date, int numeroSala) {
		try {
			String query = "INSERT INTO locadores (pessoa_id, dt_cadastro) VALUES ('"
					+ idPessoa  + "', '" + date + "');";
			System.out.println(query);
			this.statement.executeUpdate(query);
			String query2 = "UPDATE salas SET proprietario =  ('"+ idPessoa  + "'WHERE numero == '" + numeroSala + "');";
			System.out.println(query2);
			this.statement.executeUpdate(query2);
		} catch (Exception error) {
			System.out.println("Erro: " + error.getMessage());
		}
	}

	public void editarLocadores(int idPessoa, int numeroSala) {
		try {
			String query = "UPDATE SALAS SET proprietario = '" + idPessoa +"' WHERE numero == '" + numeroSala + "';";
			System.out.println(query);
			this.statement.executeUpdate(query);
		} catch (Exception error) {
			System.out.println("Erro: " + error.getMessage());
		}
	}

	public void apagarLocadores(int id) {
		try {
			String query = "DELETE proprietario FROM SALAS WHERE  = " + id + ";";
			System.out.println(query);
			this.statement.executeUpdate(query);
			String query2 = "DELETE FROM LOCADORES WHERE pessoaid = " + id + ";";
			System.out.println(query2);
			this.statement.executeUpdate(query2);
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
