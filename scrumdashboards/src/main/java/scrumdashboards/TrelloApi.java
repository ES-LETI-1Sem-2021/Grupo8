package ESGRUPO8.esgrupo8;

import java.util.List;

import javax.swing.JOptionPane;

import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Action;
import com.julienvey.trello.domain.Argument;
import com.julienvey.trello.domain.Board;
import com.julienvey.trello.domain.Card;
import com.julienvey.trello.domain.Label;
import com.julienvey.trello.domain.Member;
import com.julienvey.trello.domain.TList;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;

/**
 * 
 * @author Francisco Luz
 * @version 1.0
 *
 */
public class TrelloApi {
	private static final String Token_utilizador = "e7343a347547e46213b153251f83183fc676a1cfd681016161bc0c10aada20ba";
	private static final String Key_utilizado = "9c85119a6d1dbcf03a104a12056029b7";
	private static final Trello trelloApi = new TrelloImpl(Key_utilizado, Token_utilizador, new ApacheHttpClient());

	public static void main(String[] args) {
		String trelloKey = "Key_utilizador";
		String trelloAccessToken = "Token_utilizador";
		idLists();
	}

	/**
	 * Shows the id of all the Lists on the board
	 */
	public static void idLists() {
		List<TList> lists = trelloApi.getBoardLists("6155b26a5aee2e1b21969f73");
		for (TList t : lists) {
			System.out.println(t.getName() + "- " + t.getId());

		}

	}

	/**
	 * Shows the project id as a String
	 * 
	 * @return This method returns a String of the project id
	 */

	public static String idprojeto() {
		Trello trelloApi = new TrelloImpl(Key_utilizado, Token_utilizador, new ApacheHttpClient());
		Board quadro = trelloApi.getBoard("6155b26a5aee2e1b21969f73");
		System.out.println(quadro.getName() + "-" + quadro.getId());
		return "IDprojeto: " + quadro.getId();
	}

	/**
	 * Shows the members of the project as a String
	 * 
	 * @return This method returns a String of the integral members of the project
	 */

	public static String members() {
		String a = "";
		List<Member> memberlist = trelloApi.getBoardMembers("6155b26a5aee2e1b21969f73");

		for (Member m : memberlist) {
			System.out.println(m.getUsername());
			a = a + m.getUsername() + "\n";
		}
		return "membros do grupo:" + "\n" + a;

	}

	/**
	 * Shows the members of the project as a List
	 * 
	 * @return This method returns a List of the integral members of the project
	 */

	public static List<Member> getmemberlist() {
		return trelloApi.getBoardMembers("6155b26a5aee2e1b21969f73");
	}

	/**
	 * Shows the date the project started as a String
	 * 
	 * @return This method returns a String of the starting date
	 */

	public static String dataInicio() {
		List<Card> data = trelloApi.getListCards("61a97c7f7d33d9301d5d0064");
		return data.get(0).getDesc();
	}

	/**
	 * Shows the interval of time for each sprint as a String
	 * 
	 * @return This method returns a String which has the interval of time for each
	 *         sprint
	 */

	public static String dataInicioFim() {
		String datas = "";
		List<Card> timebetween = trelloApi.getListCards("617bee0ca4773838c00d646e");
		for (Card time : timebetween) {
			datas += time.getName() + "\n";
		}
		return datas;
	}

	/**
	 * Shows the items of the Product Backlog done on each Sprint as a String
	 * 
	 * @return This method returns a String which has accumulated the name of each
	 *         card for the respective list
	 */

	public static String prodbcklog() {
		String items = "";
		List<Card> prodbacklog1 = trelloApi.getListCards("61aa6b9fc29fa014a7a3c9e7");
		List<TList> prodbacklog0 = trelloApi.getBoardLists("6155b26a5aee2e1b21969f73");

		for (TList t : prodbacklog0) {
			if (t.getId().equals("61aa6b9fc29fa014a7a3c9e7")) {
				items = t.getName() + "\n";
				for (Card c : prodbacklog1) {

					items += c.getName() + "\n";
				}
			}
		}

		List<Card> prodbacklog2 = trelloApi.getListCards("61aa6bfd527a431a8928f582");

		for (TList t : prodbacklog0) {
			if (t.getId().equals("61aa6bfd527a431a8928f582")) {
				items += "\n" + t.getName() + "\n";
				for (Card c : prodbacklog2) {
					items += c.getName() + "\n";
				}

			}

		}
		List<Card> prodbacklog3 = trelloApi.getListCards("61aba3b7044015198fecc95b");

		for (TList t : prodbacklog0) {
			if (t.getId().equals("61aba3b7044015198fecc95b")) {
				items += "\n" + t.getName() + "\n";
				for (Card c : prodbacklog3) {
					items += c.getName() + "\n";
				}

			}

		}
		return items;
	}

	/**
	 * Shows the date when the functions were made as a String
	 * 
	 * @return This method returns a String which has accumulated the name of each
	 *         card with the label "function" and the respective description
	 */

	public static String datasTestesFuncoes() {
		String dataFuncoes = "";
		List<Card> functions = trelloApi.getListCards("6179c501e90a71294b548e59");

		for (Card fct : functions) {
			List<Label> label = fct.getLabels();
			for (Label l : label) {
				if (l.getName().equals("função")) {
					dataFuncoes += fct.getName() + "\n" + fct.getDesc() + "\n\n";
				}

			}
		}
		return dataFuncoes;
	}

	/**
	 * Shows the text of the sprints in the cards "SPRINT RETROSPECTIVE" "SPRINT
	 * REVIEW" "SPRINT PLANNING" as a String
	 * 
	 * @return This method returns a String which has accumulated the description of
	 *         each card from these specific lists.
	 */
	public static String getSprintText() {
		String sprintText = "SPRINT RETROSPECTIVE: \n";
		int x = 1;
		int y = 1;
		int z = 1;

		List<Card> pack = trelloApi.getListCards("6179c48c8ee4243dba9b4e5c");
		for (Card p : pack) {
			sprintText += "Sprint " + x + ":" + p.getDesc() + "\n";
			x++;
		}

		List<Card> pac = trelloApi.getListCards("6179c40a56110a54344a4526");
		sprintText += "\nSPRINT REVIEW: \n";
		for (Card p : pac) {
			sprintText += "Sprint " + y + ":" + p.getDesc() + "\n";
			y++;
		}

		List<Card> pa = trelloApi.getListCards("617bee0ca4773838c00d646e");
		sprintText += "\nSPRINT PLANNING: \n";
		for (Card p : pa) {
			sprintText += "Sprint " + z + ":" + p.getDesc() + "\n";
			z++;
		}
		return sprintText;
	}

	/**
	 * Shows the spent and estimated time for each Sprint and the total as a String
	 * 
	 * @return This method returns a String which has the sum of all the time spent
	 *         and the estimated time
	 */
	public static String horasPrevistasGastas() {
		String horasTotal = "";
		double spent = 0;
		double estimated = 0;
		double sprint1spent = 0;
		double sprint1estimated = 0;
		double sprint2spent = 0;
		double sprint2estimated = 0;
		double sprint3spent = 0;
		double sprint3estimated = 0;
		List<Card> cardtime1 = trelloApi.getListCards("61aa6b9fc29fa014a7a3c9e7");
		List<Member> membro = trelloApi.getBoardMembers("6155b26a5aee2e1b21969f73");
		for (Member m : membro) {
			spent = 0;
			estimated = 0;
			sprint1spent = 0;
			sprint1estimated = 0;
			sprint2spent = 0;
			sprint2estimated = 0;
			sprint3spent = 0;
			sprint3estimated = 0;
			for (Card prev1 : cardtime1) {
				List<Action> acao = prev1.getActions();
				System.out.println(prev1.getActions());
				for (Action a : acao) {
					if (a.getData().getText() != null && a.getData().getText().contains("plus!")) {
						String str = a.getData().getText();
						String[] arrOfStr = str.split(" ", 3);
						String[] arrOfStr1 = arrOfStr[2].split("/", 2);
						String arrOfStr2 = arrOfStr[1];
						if (arrOfStr2.contains(m.getUsername())) {
							System.out.println(arrOfStr1[0] + " " + arrOfStr1[1]);
							sprint1spent += Double.parseDouble(arrOfStr1[0]);
							sprint1estimated += Double.parseDouble(arrOfStr1[1]);
							spent += Double.parseDouble(arrOfStr1[0]);
							estimated += Double.parseDouble(arrOfStr1[1]);
						}
					}
				}
			}

			List<Card> cardtime2 = trelloApi.getListCards("61aa6bfd527a431a8928f582");
			for (Card prev2 : cardtime2) {
				List<Action> acao = prev2.getActions();
				System.out.println(prev2.getActions());
				for (Action a : acao) {
					if (a.getData().getText() != null && a.getData().getText().contains("plus!")) {
						String str = a.getData().getText();
						String[] arrOfStr = str.split(" ", 3);
						String[] arrOfStr1 = arrOfStr[2].split("/", 2);
						String arrOfStr2 = arrOfStr[1];
						if (arrOfStr2.contains(m.getUsername())) {
							System.out.println(arrOfStr1[0] + " " + arrOfStr1[1]);
							sprint2spent += Double.parseDouble(arrOfStr1[0]);
							sprint2estimated += Double.parseDouble(arrOfStr1[1]);
							spent += Double.parseDouble(arrOfStr1[0]);
							estimated += Double.parseDouble(arrOfStr1[1]);
						}
					}
				}
			}
			List<Card> cardtime3 = trelloApi.getListCards("61aba3b7044015198fecc95b");
			for (Card prev3 : cardtime3) {
				List<Action> acao = prev3.getActions();
				System.out.println(prev3.getActions());
				for (Action a : acao) {
					if (a.getData().getText() != null && a.getData().getText().contains("plus!")) {
						String str = a.getData().getText();
						String[] arrOfStr = str.split(" ", 3);
						String[] arrOfStr1 = arrOfStr[2].split("/", 2);
						String arrOfStr2 = arrOfStr[1];
						if (arrOfStr2.contains(m.getUsername())) {
							System.out.println(arrOfStr1[0] + " " + arrOfStr1[1]);
							sprint3spent += Double.parseDouble(arrOfStr1[0]);
							sprint3estimated += Double.parseDouble(arrOfStr1[1]);
							spent += Double.parseDouble(arrOfStr1[0]);
							estimated += Double.parseDouble(arrOfStr1[1]);
						}
					}
				}

			}
			String info = ("Sprint1:\n" + "Spent: " + sprint1spent + " Estimated: " + sprint1estimated + "\nSprint2:\n"
					+ "Spent: " + sprint2spent + " Estimated: " + sprint2estimated + "\nSprint3:\n" + "Spent: "
					+ sprint3spent + " Estimated: " + sprint3estimated + "\ntotal:\n" + "Spent: " + spent
					+ " Estimated: " + estimated);
			JOptionPane.showMessageDialog(null, info, m.getUsername(), JOptionPane.PLAIN_MESSAGE);
		}
		horasTotal = "Sprint1:\n" + "Spent: " + sprint1spent + " Estimated: " + sprint1estimated + "\nSprint2:\n"
				+ "Spent: " + sprint2spent + " Estimated: " + sprint2estimated + "\nSprint3:\n" + "Spent: "
				+ sprint3spent + " Estimated: " + sprint3estimated + "\ntotal:\n" + "Spent: " + spent + " Estimated: "
				+ estimated;

		return horasTotal;

	}

	/**
	 * Shows the spent and estimated time for each Sprint and the total as a double
	 * in the appearance of a pieChart
	 * 
	 * @return This method returns a vector of doubles which includes the values of
	 *         the time spent, estimated time and the total
	 */

	public static double[] horasPrevistasGastas1(Member m) {
		double horasTotal[] = new double[8];
		double spent = 0;
		double estimated = 0;
		double sprint1spent = 0;
		double sprint1estimated = 0;
		double sprint2spent = 0;
		double sprint2estimated = 0;
		double sprint3spent = 0;
		double sprint3estimated = 0;
		List<Card> cardtime1 = trelloApi.getListCards("61aa6b9fc29fa014a7a3c9e7");
		List<Member> membro = trelloApi.getBoardMembers("6155b26a5aee2e1b21969f73");

		spent = 0;
		estimated = 0;
		sprint1spent = 0;
		sprint1estimated = 0;
		sprint2spent = 0;
		sprint2estimated = 0;
		sprint3spent = 0;
		sprint3estimated = 0;
		for (Card prev1 : cardtime1) {
			List<Action> acao = prev1.getActions();

			for (Action a : acao) {
				if (a.getData().getText() != null && a.getData().getText().contains("plus!")) {
					String str = a.getData().getText();
					String[] arrOfStr = str.split(" ", 3);
					String[] arrOfStr1 = arrOfStr[2].split("/", 2);
					String arrOfStr2 = arrOfStr[1];
					if (arrOfStr2.contains(m.getUsername())) {
						System.out.println(arrOfStr1[0] + " " + arrOfStr1[1]);
						sprint1spent += Double.parseDouble(arrOfStr1[0]);
						sprint1estimated += Double.parseDouble(arrOfStr1[1]);
						spent += Double.parseDouble(arrOfStr1[0]);
						estimated += Double.parseDouble(arrOfStr1[1]);
					}
				}
			}
		}

		List<Card> cardtime2 = trelloApi.getListCards("61aa6bfd527a431a8928f582");
		for (Card prev2 : cardtime2) {
			List<Action> acao1 = prev2.getActions();

			for (Action a : acao1) {
				if (a.getData().getText() != null && a.getData().getText().contains("plus!")) {
					String str = a.getData().getText();
					String[] arrOfStr = str.split(" ", 3);
					String[] arrOfStr1 = arrOfStr[2].split("/", 2);
					String arrOfStr2 = arrOfStr[1];
					if (arrOfStr2.contains(m.getUsername())) {
						System.out.println(arrOfStr1[0] + " " + arrOfStr1[1]);
						sprint2spent += Double.parseDouble(arrOfStr1[0]);
						sprint2estimated += Double.parseDouble(arrOfStr1[1]);
						spent += Double.parseDouble(arrOfStr1[0]);
						estimated += Double.parseDouble(arrOfStr1[1]);
					}
				}
			}
		}

		List<Card> cardtime3 = trelloApi.getListCards("61aba3b7044015198fecc95b");
		for (Card prev3 : cardtime3) {
			List<Action> acao2 = prev3.getActions();

			for (Action a : acao2) {
				if (a.getData().getText() != null && a.getData().getText().contains("plus!")) {
					String str = a.getData().getText();
					String[] arrOfStr = str.split(" ", 3);
					String[] arrOfStr1 = arrOfStr[2].split("/", 2);
					String arrOfStr2 = arrOfStr[1];
					if (arrOfStr2.contains(m.getUsername())) {
						System.out.println(arrOfStr1[0] + " " + arrOfStr1[1]);
						sprint3spent += Double.parseDouble(arrOfStr1[0]);
						sprint3estimated += Double.parseDouble(arrOfStr1[1]);
						spent += Double.parseDouble(arrOfStr1[0]);
						estimated += Double.parseDouble(arrOfStr1[1]);
					}
				}
			}
		}
		horasTotal[0] = sprint1spent;
		horasTotal[1] = sprint1estimated;
		horasTotal[2] = sprint2spent;
		horasTotal[3] = sprint2estimated;
		horasTotal[4] = sprint3spent;
		horasTotal[5] = sprint3estimated;
		horasTotal[6] = spent;
		horasTotal[7] = estimated;

		return horasTotal;

	}
}