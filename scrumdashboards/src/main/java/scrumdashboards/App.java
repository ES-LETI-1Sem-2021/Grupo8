package ESGRUPO8.esgrupo8;

import java.awt.EventQueue;

import javax.swing.JFrame;

import Aplicacaoooo;
import App;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class App2 {

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
		
		JButton idProjeto = new JButton("idProjeto");
		idProjeto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacao l= new Aplicacao();
				l.idprojeto();
			}
		});
		idProjeto.setBounds(345, 213, 89, 48);
		frame.getContentPane().add(idProjeto);
		
		JButton btnNewButton = new JButton("membros");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacao l= new Aplicacao ();
				l.members();
			}
		});
		btnNewButton.setBounds(178, 211, 107, 50);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Informações");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aplicacao l= new Aplicacao();
				l.idprojeto();
				l.members();
				System.out.println("Data de ínicio: 25 setembro");
			}
		});
		btnNewButton_1.setBounds(163, 100, 107, 50);
		frame.getContentPane().add(btnNewButton_1);
		//f
	}
}
