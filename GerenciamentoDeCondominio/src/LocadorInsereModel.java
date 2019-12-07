package eng3_condominio;

import eng3_condominio.DataBaseConnection;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class LocadorInsereModel {

	private JFrame frame;
	private JTextField insereIdPessoa;
	
	LocadorView locaView = new LocadorView();
	
	private JTextField insereNumeroSala;
	private JTextField insereDtCadastro;

	/**
	 * Launch the application.
	 */
	public static void LocadorInsere() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocadorInsereModel window = new LocadorInsereModel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LocadorInsereModel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Insira o ID da pessoa que alugou");
		lblNewLabel.setBounds(10, 11, 160, 14);
		frame.getContentPane().add(lblNewLabel);
		
		insereIdPessoa = new JTextField();
		insereIdPessoa.setBounds(10, 36, 139, 20);
		frame.getContentPane().add(insereIdPessoa);
		insereIdPessoa.setColumns(10);
		
		JButton btnAlocar = new JButton("Alocar");
		btnAlocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				locaView.setIdPessoa(Integer.parseInt(insereIdPessoa.getText())); //ALOCANDO ID PESSOA COMO INTEIRO NA VARIAVEL IdPessoa APÓS APERTAR O BOTÃO	
				locaView.setIdSala(Integer.parseInt(insereNumeroSala.getText()));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				locaView.setDataCadastro(LocalDate.parse((insereDtCadastro.getText())));
				
				locaView.conectar();
				locaView.inserirLocadores(locaView.getIdPessoa(), locaView.getDataCadastro(), locaView.getIdSala());
				locaView.desconectar();	
				//NÃO ESQUECER OS RETURNS
			}
		});
		btnAlocar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnAlocar);
				
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
		
		JLabel lblInsiraONmero = new JLabel("Insira o n\u00FAmero da sala a ser alugada");
		lblInsiraONmero.setBounds(213, 11, 211, 14);
		frame.getContentPane().add(lblInsiraONmero);
		
		insereNumeroSala = new JTextField();
		insereNumeroSala.setBounds(213, 36, 139, 20);
		frame.getContentPane().add(insereNumeroSala);
		insereNumeroSala.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Insira a data de cadastro");
		lblNewLabel_1.setBounds(10, 67, 139, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		insereDtCadastro = new JTextField();
		insereDtCadastro.setBounds(10, 92, 139, 20);
		frame.getContentPane().add(insereDtCadastro);
		insereDtCadastro.setColumns(10);
	}
}
