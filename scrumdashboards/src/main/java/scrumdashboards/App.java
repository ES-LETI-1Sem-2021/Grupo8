package ESGRUPO8.esgrupo8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App2 extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App2 window = new App2();
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
	public App2() {
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
		
		JButton btnNewButton = new JButton("Items do ProductBackLog");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aplicacao3 l= new Aplicacao3 ();
				l.prodbcklog();
				JTextArea textArea = new JTextArea(l.prodbcklog());
	            JScrollPane scrollPane = new JScrollPane(textArea);
	            textArea.setLineWrap(true);
	            textArea.setWrapStyleWord(true); 
	            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
	            JOptionPane.showMessageDialog(null, scrollPane, " Product Backlog de cada Sprint " ,JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		btnNewButton.setBounds(26, 138, 127, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Texto dos Sprints");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aplicacao3 l= new Aplicacao3();
				l.getSprintText();
				JTextArea textArea = new JTextArea(l.getSprintText());
	            JScrollPane scrollPane = new JScrollPane(textArea);
	            textArea.setLineWrap(true);
	            textArea.setWrapStyleWord(true); 
	            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
	            JOptionPane.showMessageDialog(null, scrollPane, " Texto dos Sprints " ,JOptionPane.PLAIN_MESSAGE);
				
			}
		});
		btnNewButton_1.setBounds(26, 82, 127, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Informações");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aplicacao3 l= new Aplicacao3();
				JOptionPane.showMessageDialog(null, l.idprojeto() + "\n " + l.members() + l.dataInicio(), " Informações " ,JOptionPane.PLAIN_MESSAGE);

			}
		});
		btnNewButton_2.setBounds(126, 11, 127, 60);
		frame.getContentPane().add(btnNewButton_2);
	
	JButton btnNewButton_3 = new JButton("Sair");
	btnNewButton_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			System.exit(0);
		}
	});
	btnNewButton_3.setBounds(289, 210, 89, 23);
	frame.getContentPane().add(btnNewButton_3);
	
	JButton btnNewButton_4 = new JButton("Data de Inicio e de Fim de cada planning");
	btnNewButton_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Aplicacao3 l= new Aplicacao3();
			JOptionPane.showMessageDialog(null, l.dataInicioFim() + "\n", " Datas de inicio e fim de cada sprint " ,JOptionPane.PLAIN_MESSAGE);
		}
	});
	btnNewButton_4.setBounds(26, 194, 227, 56);
	frame.getContentPane().add(btnNewButton_4);
	
	JButton btnNewButton_5 = new JButton("Data de Inicio e Fim das Funções");
	btnNewButton_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Aplicacao3 l= new Aplicacao3();
			l.datasTestesFuncoes();
			
			JTextArea textArea = new JTextArea(l.datasTestesFuncoes());
            JScrollPane scrollPane = new JScrollPane(textArea);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true); 
            scrollPane.setPreferredSize( new Dimension( 500, 500 ) );
            JOptionPane.showMessageDialog(null, scrollPane, " teste " ,JOptionPane.PLAIN_MESSAGE);
		}
	});
	btnNewButton_5.setBounds(275, 104, 103, 56);
	frame.getContentPane().add(btnNewButton_5);
	}
	
}
	