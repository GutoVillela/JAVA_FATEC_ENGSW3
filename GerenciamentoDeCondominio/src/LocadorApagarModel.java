package eng3_condominio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocadorApagarModel {

	private JFrame frame;
	private JTextField apagaIdPessoa;
	
	LocadorView locaView = new LocadorView();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocadorApagarModel window = new LocadorApagarModel();
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
	public LocadorApagarModel() {
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
		
		JLabel lblInsiraOId = new JLabel("Insira o ID do cliente a ser retirado da sala");
		lblInsiraOId.setBounds(10, 11, 217, 14);
		frame.getContentPane().add(lblInsiraOId);
		
		apagaIdPessoa = new JTextField();
		apagaIdPessoa.setBounds(10, 36, 160, 20);
		frame.getContentPane().add(apagaIdPessoa);
		apagaIdPessoa.setColumns(10);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				locaView.setIdPessoa(Integer.parseInt(apagaIdPessoa.getText()));
				
				locaView.conectar();
				locaView.apagarLocadores(locaView.getIdPessoa());
				locaView.desconectar();	
				//NÃO ESQUECER OS RETURNS
			}
		});
		btnApagar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnApagar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
	}
}
