package eng3_condominio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LocadorEditarModel {

	private JFrame frame;
	private JTextField EditaIdPessoa;
	private JTextField editaIdSala;
	
	LocadorView locaView = new LocadorView();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocadorEditarModel window = new LocadorEditarModel();
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
	public LocadorEditarModel() {
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
		
		JLabel lblNewLabel = new JLabel("Insira o ID da pessoa");
		lblNewLabel.setBounds(10, 11, 126, 14);
		frame.getContentPane().add(lblNewLabel);
		
		EditaIdPessoa = new JTextField();
		EditaIdPessoa.setBounds(10, 36, 126, 20);
		frame.getContentPane().add(EditaIdPessoa);
		EditaIdPessoa.setColumns(10);
		
		JLabel lblInsiraOId = new JLabel("Insira o ID da sala a ser alterado ");
		lblInsiraOId.setBounds(221, 11, 165, 14);
		frame.getContentPane().add(lblInsiraOId);
		
		editaIdSala = new JTextField();
		editaIdSala.setBounds(221, 36, 126, 20);
		frame.getContentPane().add(editaIdSala);
		editaIdSala.setColumns(10);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				locaView.setIdPessoa(Integer.parseInt(EditaIdPessoa.getText()));
				locaView.setIdSala(Integer.parseInt(editaIdSala.getText()));
				
				locaView.conectar();
				locaView.editarLocadores(locaView.getIdPessoa(), locaView.getIdSala());
				locaView.desconectar();	
			}
		});
		btnEditar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnEditar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnVoltar);
	}

}
