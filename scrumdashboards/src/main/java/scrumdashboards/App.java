package ESGRUPO8.esgrupo8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
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
	public App() {
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
				JOptionPane.showMessageDialog(null, l.prodbcklog(), " teste " ,JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton.setBounds(26, 138, 127, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Texto dos Sprints");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aplicacao3 l= new Aplicacao3();
				l.getSprintText();
				JOptionPane.showMessageDialog(null, l.getSprintText(), " teste " ,JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(26, 82, 127, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Informações");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aplicacao3 l= new Aplicacao3();
				l.idprojeto();
				l.members();
				JOptionPane.showMessageDialog(null, l.idprojeto() + "\n " + l.members() + l.dataInicio(), " teste " ,JOptionPane.PLAIN_MESSAGE);

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
}

}
