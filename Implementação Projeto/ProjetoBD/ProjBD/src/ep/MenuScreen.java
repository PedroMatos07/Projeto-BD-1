package ep;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MenuScreen extends Screen{
	private static final long serialVersionUID = 1L;
	
	private int optionQuery = 0; //Valor do campo selecionado
	
	public MenuScreen() {
		super("Menu");
		addComponents();
	}
	
	@Override
	protected void addComponents() { //Cria o layout da página
		
		createLogoCenter(0, 0, 2); //Cria a logo
		
		JLabel title = createLabel(1, 1, GridBagConstraints.WEST, "Menu de Consultas");
		
        JComboBox<String> queryBox = createComboBox(1, 3, GridBagConstraints.CENTER, "Opções:"); //Caixa para selecionar a consulta
		
        queryBox.addItem("1");
        queryBox.addItem("2");
        queryBox.addItem("3");
        queryBox.addItem("4");
        queryBox.addItem("5");
        queryBox.addItem("6");
        queryBox.addItem("7");
        queryBox.addItem("8");
        queryBox.addItem("9");
        queryBox.addItem("10");
        
        queryBox.addActionListener(e -> {
            optionQuery = queryBox.getSelectedIndex();
        });
        
		JButton btnInfo = createIcon(32, 32, 1, 1, GridBagConstraints.EAST, "/logo/info.png"); //Botão de sair
		btnInfo.addActionListener(e -> {
	        // Texto com as opções
	        String texto = """
	        	CONSULTAS
	            1. Que tipo de serviços um determinado cliente X solicitou no último mês.
	            2. Qual é a empresa que mais ofereceu mais serviços à cidade de Y no estado de Z.
	            3. Quais funcionários (nome e sobrenome) trabalharam para o cliente X no mês Y do ano Z.
	            4. Listar as solicitações foram feitas no último ano, nome do cliente que as realizou, municípios de origem e destino (se houver) e preço total de cada solicitação.
	            5. Listar o faturamento das empresas por mês em um ano X.
	            6. Verificar qual o serviço mais solicitado no último mês entre todas empresas.
	            7. Listar o serviço (nome) mais solicitado, e o número de solicitações para cada empresa.
	            8. Verificar em qual cidade houve o maior número de solicitações.
	            9. Verificar qual a cidade destino que é mais referenciada nos pedidos e a sua quantidade de pedidos.
	            10. Listar para cada empresa o seu faturamento total.
	            """;

	        // Exibir o texto em um JOptionPane
	        JOptionPane.showMessageDialog(null, texto, "Menu de Consultas", JOptionPane.INFORMATION_MESSAGE);
		});
        
        
		JButton btnSubmit = createButton(1, 4, GridBagConstraints.CENTER, "Entrar");
		btnSubmit.addActionListener(e -> {

        switch (optionQuery) {
          case 0:
        	  this.dispose();
        	  Query1Screen query1 = new Query1Screen();
        	  query1.showScreen();
        	  break;
          case 1:
        	  this.dispose();
        	  Query2Screen query2 = new Query2Screen();
        	  query2.showScreen();
        	  break;
          case 2:
        	  this.dispose();
        	  Query3Screen query3 = new Query3Screen();
        	  query3.showScreen();
        	  break;
          case 3:
        	  this.dispose();
        	  Query4Screen query4 = new Query4Screen();
        	  query4.showScreen();
        	  break;
          case 4:
        	  this.dispose();
        	  Query5Screen query5 = new Query5Screen();
        	  query5.showScreen();
        	  break;
          case 5:
        	  this.dispose();
        	  Query6Screen query6 = new Query6Screen();
        	  query6.showScreen();
        	  break;
          case 6:
        	  this.dispose();
        	  Query7Screen query7 = new Query7Screen();
        	  query7.showScreen();
        	  break;
          case 7:
        	  this.dispose();
        	  Query8Screen query8 = new Query8Screen();
        	  query8.showScreen();
        	  break;
          case 8:
        	  this.dispose();
        	  Query9Screen query9 = new Query9Screen();
        	  query9.showScreen();
        	  break;
          case 9:
        	  this.dispose();
        	  Query10Screen query10 = new Query10Screen();
        	  query10.showScreen();
        	  break;
        }
			
		});
		
	}
	
	
}
