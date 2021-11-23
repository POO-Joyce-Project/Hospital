package poo.trabalho.screens.consulta.laudo;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import poo.trabalho.interfaces.IConsultaController;

public class ConsultaLaudoView extends JPanel {
	
	private static final long serialVersionUID = -7225920741930322445L;
	
	private IConsultaController controller;
	
	private DefaultTableModel tableModel;
	private JTable table;
	private JScrollPane scrollPane;
	
	public ConsultaLaudoView() {
		
		setupTable();
		
		controller = new ConsultaLaudoController(this);
		controller.carregarDados();
		
		setLayout(null);
		setBounds(0, 0, 620, 450);
	}
	
	private void setupTable() {
		String column[] = { "ID", "Paciente", "Médico", "Sintomas", "Medicação", "Observação", "Diagnóstico" };
		
		tableModel = new DefaultTableModel(new String[][]{}, column);
		table = new JTable(tableModel) {
			
			private static final long serialVersionUID = 6260813707854965453L;
			
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setBounds(10, 77, this.getWidth(), this.getHeight());
		
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setHorizontalAlignment(JLabel.CENTER);
		
		table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 11, 600, 428);
		add(scrollPane);
	}
	
	public IConsultaController getController() {
		return controller;
	}
	
	public DefaultTableModel getTableModel() {
		return tableModel;
	}

}
