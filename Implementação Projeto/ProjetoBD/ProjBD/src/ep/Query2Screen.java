package ep;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.Consultas;

public class Query2Screen extends Screen{
	private static final long serialVersionUID = 1L;
	
	private JTextField state, city;
    private JTable table;
    private DefaultTableModel tableModel;
	
	public Query2Screen() {
		super("Query 2");
		addComponents();
	}

	@Override
	protected void addComponents() { //Cria o layout da página
		createLogoCenter(0, 0, 3); //Cria a logo central
		
		JButton btnExit = createIcon(25, 25, 0, 0, GridBagConstraints.WEST, "/logo/seta-left-icon.png");
        btnExit .addActionListener(e -> {
        	this.dispose();
        	MenuScreen menu = new MenuScreen();
        	menu.showScreen();
        });
		
        add(btnExit, getConstraints(0, 0, GridBagConstraints.WEST, 0, 0, 0, 0));
		
		city = createTextField(1, 1, GridBagConstraints.WEST, "Cidade:");
		state = createTextField(1, 2, GridBagConstraints.WEST, "Estado:");

		
		JButton btnSubmit = createButton(2, 2, GridBagConstraints.CENTER, "Consultar");
		btnSubmit.addActionListener(e -> {
		    try {
			        Consultas consultas = new Consultas();
			        DefaultTableModel resultModel = consultas.query2(city.getText(), state.getText());

			        // Substituir o modelo da tabela
			        table.setModel(resultModel);
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos", "Erro", JOptionPane.ERROR_MESSAGE);
		    }
		});
		
        // Criar tabela e modelo vazio inicialmente
        tableModel = new DefaultTableModel(new Object[]{"Nome Empresa"}, 0);
        table = new JTable(tableModel);
        table.setRowSelectionAllowed(false); // Desativa seleção de linhas
        table.setColumnSelectionAllowed(false); // Desativa seleção de colunas
        table.setCellSelectionEnabled(false); // Desativa seleção de células        
        table.setPreferredScrollableViewportSize(new Dimension(400, 300)); // Tamanho da tabela
        table.setFocusable(false);
        
        table.getColumnModel().getColumn(0).setPreferredWidth(100); // Largura da coluna 1
        JScrollPane scrollPane = new JScrollPane(table);
        
        GridBagConstraints tableConstraints = getConstraints(0, 5, GridBagConstraints.CENTER, 3, 0, 0, 0);
        tableConstraints.fill = GridBagConstraints.BOTH;
        tableConstraints.gridwidth = 3; // Faz a tabela ocupar 3 colunas
        tableConstraints.weightx = 1.0;
        tableConstraints.weighty = 1.0;
        add(scrollPane, tableConstraints);
	}

}