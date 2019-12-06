package eng3_condominio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class LocadorListarModel {

	private JFrame frame;
	private JTable table;
	
	LocadorView locaView = new LocadorView();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LocadorListarModel window = new LocadorListarModel();
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
	public LocadorListarModel() {
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
		
		table = new JTable();
		table.setBounds(46, 49, 333, 156);
		frame.getContentPane().add(table);
		
		JButton btnListar = new JButton("Listar");
		DefaultTableModel model = new DefaultTableModel();
		String[] columnNames = {"id", "dtLocacao", "numeroSala"};
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				locaView.conectar();
				List<LocadorView> listarLocacao = locaView.listarProdutos();
				locaView.desconectar();
				model.setColumnIdentifiers(columnNames);
				
				
				model.addRow(new Object[] {"id", "dtLocacao", "numeroSala"});
				for (LocadorView locaView : listarLocacao) {

					model.addRow(new Object[] {locaView.getIdPessoa(), locaView.getDataCadastro(), locaView.getIdSala()});
				}
				table.setModel(model);
				
			}			
		});
		btnListar.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnListar);
	}
}
