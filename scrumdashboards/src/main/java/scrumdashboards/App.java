package ESGRUPO8.esgrupo8;

import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.julienvey.trello.domain.Member;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;

public class App2<JFreeChart, PiePlot, PieDataset> extends JFrame {

	
	private JFrame frame;
	public int custoHora;
	private JTextField custo;
	private JTextField textField;
	
//	public App2(String appTitle, String chartTitle) {
	//	PieDataset dataset = createDataset();
	//	JFreeChart chart = createChart(dataset,chartTitle);
	//	ChartPanel chartPanel = new ChartPanel(chart);
	//	chartPanel.setPreferredSize(new java.awt.Dimension(500,300));
	//	setContentPane(chartPanel);
		
//	}
	//private PieDataset createDataset() {
	//	DefaultPieDataset result = new DefaultPieDataset();
	//}

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
				TrelloApi l= new TrelloApi();
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
				TrelloApi l= new TrelloApi();
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
				TrelloApi l= new TrelloApi();
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
			TrelloApi l= new TrelloApi();
			JOptionPane.showMessageDialog(null, l.dataInicioFim() + "\n", " Datas de inicio e fim de cada sprint " ,JOptionPane.PLAIN_MESSAGE);
		}
	});
	btnNewButton_4.setBounds(26, 194, 227, 56);
	frame.getContentPane().add(btnNewButton_4);
	
	JButton btnNewButton_5 = new JButton("Data de Inicio e Fim das Funções");
	btnNewButton_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			TrelloApi l= new TrelloApi();
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
	
	JButton btnNewButton_6 = new JButton("PrevistasGastas");
	btnNewButton_6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			TrelloApi l= new TrelloApi();
			//l.horasPrevistasGastas1();
			DefaultPieDataset pieDataset = new DefaultPieDataset();
			for(Member m : l.getmemberlist()) {
				double[] horas=l.horasPrevistasGastas1(m);
			
			pieDataset.setValue(m.getUsername() + "\nSprint1 Spent", (horas[0]));
			pieDataset.setValue(m.getUsername() + "\nSprint1 Estimated", (horas[1]));
		
			}
			JFreeChart chart= (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);
			PiePlot p=(PiePlot)((org.jfree.chart.JFreeChart) chart).getPlot();
			ChartFrame frame=new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart);
			frame.setVisible(true);
			frame.setSize(650,700);
			
			
			DefaultPieDataset pieDataset1 = new DefaultPieDataset();
			for(Member m : l.getmemberlist()) {
				double[] horas=l.horasPrevistasGastas1(m);
			
			pieDataset1.setValue(m.getUsername() + "\nSprint2 Spent", (horas[2]));
			pieDataset1.setValue(m.getUsername() + "\nSprint2 Estimated", (horas[3]));
			
			}
			JFreeChart chart1= (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset1, true, true, true);
			PiePlot p1=(PiePlot)((org.jfree.chart.JFreeChart) chart1).getPlot();
			ChartFrame frame1=new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart1);
			frame1.setVisible(true);
			frame1.setSize(650,700);
			
			
			
			DefaultPieDataset pieDataset2 = new DefaultPieDataset();
			for(Member m : l.getmemberlist()) {
				double[] horas=l.horasPrevistasGastas1(m);
			
			pieDataset1.setValue(m.getUsername() + "\nSprint3 Spent", (horas[4]));
			pieDataset1.setValue(m.getUsername() + "\nSprint3 Estimated", (horas[5]));
			
			}
			JFreeChart chart2= (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset2, true, true, true);
			PiePlot p2=(PiePlot)((org.jfree.chart.JFreeChart) chart1).getPlot();
			ChartFrame frame2=new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart2);
			frame2.setVisible(true);
			frame2.setSize(650,700);
			
			
			
			DefaultPieDataset pieDataset3 = new DefaultPieDataset();
			for(Member m : l.getmemberlist()) {
				double[] horas=l.horasPrevistasGastas1(m);
			
			pieDataset3.setValue(m.getUsername() + "\nTotalSprint Spent", (horas[6]));
			pieDataset3.setValue(m.getUsername() + "\nTotalSprint Estimated", (horas[7]));
			
			}
			JFreeChart chart3= (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset3, true, true, true);
			PiePlot p3=(PiePlot)((org.jfree.chart.JFreeChart) chart3).getPlot();
			ChartFrame frame3=new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart3);
			frame3.setVisible(true);
			frame3.setSize(650,700);
			
					
				
		}
	});
	btnNewButton_6.setBounds(26, 261, 103, 56);
	frame.getContentPane().add(btnNewButton_6);
	
	JButton btnNewButton_7 = new JButton("Conteúdo do README");
	btnNewButton_7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			GitHubApi g= new GitHubApi();
			try {
				JOptionPane.showMessageDialog(null, g.getReadme(), " teste " ,JOptionPane.PLAIN_MESSAGE);
			} catch (HeadlessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
	});
	btnNewButton_7.setBounds(253, 224, 89, 23);
	frame.getContentPane().add(btnNewButton_7);
	
	
	JButton btnNewButton_8 = new JButton("Custo");
	btnNewButton_8.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent e) {
			TrelloApi l = new TrelloApi();
			if(textField.getText().isEmpty()) {
				custoHora=20;
				
			}else {
				try {
					custoHora= Integer.valueOf(textField.getText());
				}catch(Exception y) {
					System.out.println("Só recebe Valores numéricos");
					
				}
			}
			DefaultPieDataset pieDataset = new DefaultPieDataset();
			for(Member m : l.getmemberlist()) {
				double[] horas=l.horasPrevistasGastas1(m);
			
			pieDataset.setValue(m.getUsername() + "\nSprint1 Spent", (horas[0]*custoHora));
			pieDataset.setValue(m.getUsername() + "\nSprint1 Estimated", (horas[1]*custoHora));
		
			}
			JFreeChart chart= (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset, true, true, true);
			PiePlot p=(PiePlot)((org.jfree.chart.JFreeChart) chart).getPlot();
			ChartFrame frame=new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart);
			frame.setVisible(true);
			frame.setSize(650,700);
			
			
			DefaultPieDataset pieDataset1 = new DefaultPieDataset();
			for(Member m : l.getmemberlist()) {
				double[] horas=l.horasPrevistasGastas1(m);
			
			pieDataset1.setValue(m.getUsername() + "\nSprint2 Spent", (horas[2]*custoHora));
			pieDataset1.setValue(m.getUsername() + "\nSprint2 Estimated", (horas[3]*custoHora));
			
			}
			JFreeChart chart1= (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset1, true, true, true);
			PiePlot p1=(PiePlot)((org.jfree.chart.JFreeChart) chart1).getPlot();
			ChartFrame frame1=new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart1);
			frame1.setVisible(true);
			frame1.setSize(650,700);
			
			
			
			DefaultPieDataset pieDataset2 = new DefaultPieDataset();
			for(Member m : l.getmemberlist()) {
				double[] horas=l.horasPrevistasGastas1(m);
			
			pieDataset1.setValue(m.getUsername() + "\nSprint3 Spent", (horas[4]*custoHora));
			pieDataset1.setValue(m.getUsername() + "\nSprint3 Estimated", (horas[5]*custoHora));
			
			}
			JFreeChart chart2= (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset2, true, true, true);
			PiePlot p2=(PiePlot)((org.jfree.chart.JFreeChart) chart1).getPlot();
			ChartFrame frame2=new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart2);
			frame2.setVisible(true);
			frame2.setSize(650,700);
			
			
			
			DefaultPieDataset pieDataset3 = new DefaultPieDataset();
			for(Member m : l.getmemberlist()) {
				double[] horas=l.horasPrevistasGastas1(m);
			
			pieDataset3.setValue(m.getUsername() + "\nTotalSprint Spent", (horas[6]*custoHora));
			pieDataset3.setValue(m.getUsername() + "\nTotalSprint Estimated", (horas[7]*custoHora));
			
			}
			JFreeChart chart3= (JFreeChart) ChartFactory.createPieChart("Pie Chart", pieDataset3, true, true, true);
			PiePlot p3=(PiePlot)((org.jfree.chart.JFreeChart) chart3).getPlot();
			ChartFrame frame3=new ChartFrame("Pie Chart", (org.jfree.chart.JFreeChart) chart3);
			frame3.setVisible(true);
			frame3.setSize(650,700);
			
			
	}
		
	});
	btnNewButton_8.setBounds(199, 106, 146, 45);
	frame.getContentPane().add(btnNewButton_8);
	
	textField = new JTextField();
	textField.setBounds(209, 165, 135, 45);
	frame.getContentPane().add(textField);
	textField.setColumns(10);
	}
	
}
	

	