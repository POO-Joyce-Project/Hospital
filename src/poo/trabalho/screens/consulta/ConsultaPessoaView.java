package poo.trabalho.screens.consulta;

import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import poo.trabalho.interfaces.IConsultaController;

import javax.swing.JScrollPane;

public abstract class ConsultaPessoaView extends JPanel {
	
	private static final long serialVersionUID = 942926819272191419L;
	
	protected IConsultaController controller;
	
	protected DefaultTableModel tableModel;
	protected JTable table;
	protected JScrollPane scrollPane;
	
	public ConsultaPessoaView() {
		
		setupTable();
		
		setBounds(0, 0, 620, 450);
		setLayout(null);
	}
	
	private void setupTable() {
		String column[] = { "CPF", "Nome", "Data de nascimento", "Sexo", "Tipo sanguíneo" };
		
		tableModel = new DefaultTableModel(new String[][]{}, column);
		table = new JTable(tableModel) {
			private static final long serialVersionUID = 4702824122374300234L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBounds(10, 77, this.getWidth(), this.getHeight());
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 600, 428);
		add(scrollPane);
	}
	
	public JTable getTable() {
		return table;
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}
	
	public IConsultaController getConsultaController() {
		return controller;
	}
	
}
