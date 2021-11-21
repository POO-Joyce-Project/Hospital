package poo.trabalho.views.consulta;

import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;

import java.text.ParseException;

import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;

public abstract class ConsultaPessoaView extends JPanel {
	
	private static final long serialVersionUID = 942926819272191419L;
	
	public ConsultaPessoaView() {
		setBounds(0, 0, 550, 450);
		setLayout(null);
		
		JLabel searchLabel = new JLabel("Buscar:");
		searchLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		searchLabel.setBounds(10, 11, 46, 14);
		add(searchLabel);
		
		try {
			MaskFormatter mask = new MaskFormatter("###.###.###-##");
			mask.setPlaceholderCharacter('_');
			
			JFormattedTextField searchTextField = new JFormattedTextField(mask);
			searchTextField.setBounds(66, 8, 375, 20);
			add(searchTextField);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String data[][]={ {"08199405180", "Johnny", "02/07/2002", "Masculino", "A+"},
                			{"01234567891", "Leticia", "21/10/2000", "Feminino", "B+"}};
		String column[] = { "CPF", "Nome", "Data de nascimento", "Sexo", "Tipo sanguíneo" };
		
		JTable table = new JTable(data, column);
		table.setBounds(10, 77, this.getWidth(), this.getHeight());
//		add(table);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 49, 530, 390);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(451, 7, 89, 23);
		add(btnNewButton);
	}
	
}
