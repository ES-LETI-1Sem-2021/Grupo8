package ESGRUPO8.esgrupo8;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.kohsuke.github.GHTag;

import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

import com.julienvey.trello.domain.Member;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class App<JFreeChart, PiePlot, PieDataset> extends JFrame {

	private JFrame frmApp;
	public int custoHora;
	private JTextField custo;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.frmApp.setVisible(true);
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

	public JFrame frame() {
		return frmApp;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApp = new JFrame();
		frmApp.setResizable(false);
		frmApp.getContentPane().setBackground(new Color(255, 255, 240));
		frmApp.setTitle("Grupo 8 App");
		frmApp.setBounds(100, 100, 725, 686);
		frmApp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmApp.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("ProductBackLog");
		btnNewButton.setToolTipText("Aqui encontram-se as informações relativas ao Product Backlog");
		btnNewButton.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		btnNewButton.setForeground(new Color(255, 255, 240));
		btnNewButton.setBackground(new Color(102, 51, 0));
		btnNewButton.setOpaque(true);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TrelloApi l = new TrelloApi();
				JTextArea textArea = new JTextArea(l.prodbcklog());
				JScrollPane scrollPane = new JScrollPane(textArea);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				scrollPane.setPreferredSize(new Dimension(500, 500));
				JOptionPane.showMessageDialog(null, scrollPane, " Product Backlog de cada Sprint ",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton.setBounds(26, 251, 161, 45);
		frmApp.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Texto dos Sprints");
		btnNewButton_1.setToolTipText("Aqui encontram-se as informações relativas ao texto dos sprints");
		btnNewButton_1.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		btnNewButton_1.setForeground(new Color(255, 255, 240));
		btnNewButton_1.setBackground(new Color(102, 51, 0));
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TrelloApi l = new TrelloApi();
				JTextArea textArea = new JTextArea(l.getSprintText());
				JScrollPane scrollPane = new JScrollPane(textArea);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				scrollPane.setPreferredSize(new Dimension(500, 500));
				JOptionPane.showMessageDialog(null, scrollPane, " Texto dos Sprints ", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton_1.setBounds(26, 195, 161, 45);
		frmApp.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("TRELLO");
		lblNewLabel.setForeground(new Color(102, 51, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(SystemColor.info);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 30));
		lblNewLabel.setBounds(67, 52, 161, 39);
		frmApp.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 51, 0));
		panel.setBounds(350, 0, 359, 647);
		frmApp.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("GITHUB");
		lblNewLabel_1.setBounds(117, 50, 135, 39);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 240));
		lblNewLabel_1.setFont(new Font("Impact", Font.PLAIN, 30));

		JButton btnNewButton_7 = new JButton("Conteúdo do README");
		btnNewButton_7.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnNewButton_7.setBounds(188, 137, 161, 45);
		panel.add(btnNewButton_7);
		btnNewButton_7.setForeground(new Color(102, 51, 0));
		btnNewButton_7.setBackground(SystemColor.info);

		JButton btnNewButton_3 = new JButton("Sair");
		btnNewButton_3.setBounds(260, 613, 89, 23);
		panel.add(btnNewButton_3);
		btnNewButton_3.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		btnNewButton_3.setForeground(new Color(102, 51, 0));
		btnNewButton_3.setBackground(SystemColor.info);
		btnNewButton_3.setOpaque(true);

		JButton btnNewButton_9 = new JButton("Tags");
		btnNewButton_9.setBackground(SystemColor.info);
		btnNewButton_9.setForeground(new Color(102, 51, 0));
		btnNewButton_9.setBounds(188, 193, 161, 45);
		panel.add(btnNewButton_9);
		btnNewButton_9.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		btnNewButton_9.setToolTipText("Aqui encontram-se as informações relativas às tags de cada branch");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GitHubApi g = new GitHubApi();
				HashMap<GHTag, String> date;
				try {
					date = g.getTags();
					for (GHTag tag : date.keySet()) {
						JOptionPane.showMessageDialog(null, "tag:" + tag.getName() + "\nDate:" + date.get(tag),
								" Informações ", JOptionPane.PLAIN_MESSAGE);

					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				System.exit(0);
			}
		});
		btnNewButton_7.setToolTipText("Aqui encontram-se as informações relativas ao conteúdo do README.md");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GitHubApi g = new GitHubApi();
				try {
					JTextArea textArea = new JTextArea(g.getReadme());
					JScrollPane scrollPane = new JScrollPane(textArea);
					textArea.setLineWrap(true);
					textArea.setWrapStyleWord(true);
					scrollPane.setPreferredSize(new Dimension(500, 500));
					JOptionPane.showMessageDialog(null, g.getReadme(), " README.md ", JOptionPane.PLAIN_MESSAGE);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnNewButton_2 = new JButton("Informações");
		btnNewButton_2.setBounds(26, 138, 161, 45);
		frmApp.getContentPane().add(btnNewButton_2);
		btnNewButton_2.setToolTipText("Aqui encontram-se as informações relativas a este projeto e aos seus membros");
		btnNewButton_2.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		btnNewButton_2.setForeground(new Color(255, 255, 240));
		btnNewButton_2.setBackground(new Color(102, 51, 0));
		btnNewButton_2.setOpaque(true);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TrelloApi l = new TrelloApi();
				JOptionPane.showMessageDialog(null, l.idprojeto() + "\n " + l.members() + l.dataInicio(), " teste ",
						JOptionPane.PLAIN_MESSAGE);
			}
		});

		JButton btnNewButton_4 = new JButton("Data Inicio/Fim-Planning");
		btnNewButton_4.setToolTipText(
				"Aqui encontram-se as informações relativas às datas de início e de fim de cada Sprint Planning");
		btnNewButton_4.setForeground(SystemColor.info);
		btnNewButton_4.setBackground(new Color(102, 51, 0));
		btnNewButton_4.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrelloApi l = new TrelloApi();
				JOptionPane.showMessageDialog(null, l.dataInicioFim() + "\n", " Datas de inicio e fim de cada sprint ",
						JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton_4.setBounds(26, 307, 161, 45);
		frmApp.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("Data Inicio/Fim-Funções");
		btnNewButton_5.setToolTipText(
				"Aqui encontram-se as informações relativas às datas de início e de fim de cada função");
		btnNewButton_5.setForeground(SystemColor.info);
		btnNewButton_5.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnNewButton_5.setBackground(new Color(102, 51, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrelloApi l = new TrelloApi();
				JTextArea textArea = new JTextArea(l.datasTestesFuncoes());
				JScrollPane scrollPane = new JScrollPane(textArea);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				scrollPane.setPreferredSize(new Dimension(500, 500));
				JOptionPane.showMessageDialog(null, scrollPane, " teste ", JOptionPane.PLAIN_MESSAGE);
			}
		});
		btnNewButton_5.setBounds(26, 363, 161, 45);
		frmApp.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("Horas Previstas/Gastas");
		btnNewButton_6.setToolTipText(
				"Aqui encontram-se as informações relativas às horas previstas a serem gastas e as que foram realmente gastas");
		btnNewButton_6.setForeground(SystemColor.info);
		btnNewButton_6.setBackground(new Color(102, 51, 0));
		btnNewButton_6.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TrelloApi l = new TrelloApi();

				DefaultPieDataset pieDataset3 = new DefaultPieDataset();
				for (Member m : l.getmemberlist()) {
					double[] horas = l.horasPrevistasGastas1(m);

					pieDataset3.setValue(m.getUsername() + "\nTotalSprint Spent", (horas[6]));
					pieDataset3.setValue(m.getUsername() + "\nTotalSprint Estimated", (horas[7]));

				}
				JFreeChart chart3 = (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset3, true, true,
						true);
				PiePlot p3 = (PiePlot) ((org.jfree.chart.JFreeChart) chart3).getPlot();
				ChartFrame frame3 = new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart3);
				frame3.setVisible(true);
				frame3.setSize(650, 700);

				DefaultPieDataset pieDataset2 = new DefaultPieDataset();
				for (Member m : l.getmemberlist()) {
					double[] horas = l.horasPrevistasGastas1(m);

					pieDataset2.setValue(m.getUsername() + "\nSprint3 Spent", (horas[4]));
					pieDataset2.setValue(m.getUsername() + "\nSprint3 Estimated", (horas[5]));

				}
				JFreeChart chart2 = (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset2, true, true,
						true);
				PiePlot p2 = (PiePlot) ((org.jfree.chart.JFreeChart) chart2).getPlot();
				ChartFrame frame2 = new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart2);
				frame2.setVisible(true);
				frame2.setSize(650, 700);

				DefaultPieDataset pieDataset1 = new DefaultPieDataset();
				for (Member m : l.getmemberlist()) {
					double[] horas = l.horasPrevistasGastas1(m);

					pieDataset1.setValue(m.getUsername() + "\nSprint2 Spent", (horas[2]));
					pieDataset1.setValue(m.getUsername() + "\nSprint2 Estimated", (horas[3]));

				}
				JFreeChart chart1 = (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset1, true, true,
						true);
				PiePlot p1 = (PiePlot) ((org.jfree.chart.JFreeChart) chart1).getPlot();
				ChartFrame frame1 = new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart1);
				frame1.setVisible(true);
				frame1.setSize(650, 700);

				DefaultPieDataset pieDataset = new DefaultPieDataset();
				for (Member m : l.getmemberlist()) {
					double[] horas = l.horasPrevistasGastas1(m);

					pieDataset.setValue(m.getUsername() + "\nSprint1 Spent", (horas[0]));
					pieDataset.setValue(m.getUsername() + "\nSprint1 Estimated", (horas[1]));

				}
				JFreeChart chart = (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);
				PiePlot p = (PiePlot) ((org.jfree.chart.JFreeChart) chart).getPlot();
				ChartFrame frame = new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart);
				frame.setVisible(true);
				frame.setSize(650, 700);

			}
		});
		btnNewButton_6.setBounds(26, 419, 161, 45);
		frmApp.getContentPane().add(btnNewButton_6);

		JLabel lblNewLabel_2 = new JLabel("v1.0");
		lblNewLabel_2.setBackground(SystemColor.info);
		lblNewLabel_2.setBounds(26, 621, 67, 15);
		frmApp.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setForeground(new Color(102, 51, 0));
		lblNewLabel_2.setFont(new Font("Microsoft Tai Le", Font.PLAIN, 11));

		JButton btnNewButton_8 = new JButton("Custo");
		btnNewButton_8.setToolTipText("Aqui encontram-se as informações relativas ao custo dos recursos humanos");
		btnNewButton_8.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 11));
		btnNewButton_8.setForeground(new Color(255, 255, 240));
		btnNewButton_8.setBackground(new Color(102, 51, 0));
		btnNewButton_8.setOpaque(true);
		btnNewButton_8.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				TrelloApi l = new TrelloApi();
				if (textField.getText().isEmpty()) {
					custoHora = 20;

				} else {
					try {
						custoHora = Integer.valueOf(textField.getText());
					} catch (Exception y) {
						System.out.println("Só recebe Valores numéricos");

					}
				}
				DefaultPieDataset pieDataset3 = new DefaultPieDataset();
				for (Member m : l.getmemberlist()) {
					double[] horas = l.horasPrevistasGastas1(m);

					pieDataset3.setValue(m.getUsername() + "\nTotalSprint Spent", (horas[6] * custoHora));

				}
				JFreeChart chart3 = (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset3, true, true,
						true);
				PiePlot p3 = (PiePlot) ((org.jfree.chart.JFreeChart) chart3).getPlot();
				ChartFrame frame3 = new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart3);
				frame3.setVisible(true);
				frame3.setSize(650, 700);

				DefaultPieDataset pieDataset2 = new DefaultPieDataset();
				for (Member m : l.getmemberlist()) {
					double[] horas = l.horasPrevistasGastas1(m);

					pieDataset2.setValue(m.getUsername() + "\nSprint3 Spent", (horas[4] * custoHora));

				}
				JFreeChart chart2 = (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset2, true, true,
						true);
				PiePlot p2 = (PiePlot) ((org.jfree.chart.JFreeChart) chart2).getPlot();
				ChartFrame frame2 = new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart2);
				frame2.setVisible(true);
				frame2.setSize(650, 700);

				DefaultPieDataset pieDataset1 = new DefaultPieDataset();
				for (Member m : l.getmemberlist()) {
					double[] horas = l.horasPrevistasGastas1(m);

					pieDataset1.setValue(m.getUsername() + "\nSprint2 Spent", (horas[2] * custoHora));

				}
				JFreeChart chart1 = (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset1, true, true,
						true);
				PiePlot p1 = (PiePlot) ((org.jfree.chart.JFreeChart) chart1).getPlot();
				ChartFrame frame1 = new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart1);
				frame1.setVisible(true);
				frame1.setSize(650, 700);

				DefaultPieDataset pieDataset = new DefaultPieDataset();
				for (Member m : l.getmemberlist()) {
					double[] horas = l.horasPrevistasGastas1(m);

					pieDataset.setValue(m.getUsername() + "\nSprint1 Spent", (horas[0] * custoHora));

				}
				JFreeChart chart = (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);
				PiePlot p = (PiePlot) ((org.jfree.chart.JFreeChart) chart).getPlot();
				ChartFrame frame = new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart);
				frame.setVisible(true);
				frame.setSize(650, 700);

			}

		});
		btnNewButton_8.setBounds(26, 475, 161, 45);
		frmApp.getContentPane().add(btnNewButton_8);

		textField = new JTextField();
		textField.setBounds(197, 483, 135, 26);
		frmApp.getContentPane().add(textField);
		textField.setColumns(10);
	}
}
