package ESGRUPO8.esgrupo8;

import java.util.List;

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


public class Aplicacao 
{
    private static final String Token_utilizador = "e7343a347547e46213b153251f83183fc676a1cfd681016161bc0c10aada20ba";
    private static final String Key_utilizado = "9c85119a6d1dbcf03a104a12056029b7";
    private static final Trello trelloApi = new TrelloImpl(Key_utilizado, Token_utilizador, new ApacheHttpClient());
    public static void main( String[] args ){
        String trelloKey="Key_utilizador";
        String trelloAccessToken="Token_utilizador";
        
      
        Board board;
        Card card;
        List<Board> member=trelloApi.getMemberBoards("franciscoluz9"); //podem consultar o vosso nome_utilizador na opção "profile and visibility" da vossa conta no trello
        for (Board  quadro: member) {
            board = trelloApi.getBoard(quadro.getId());
            List<TList> lists = board.fetchLists();
            idprojeto();
            members();
            //prodbcklog();
            getSprintText();
            idSprints();
         
            
            
            List<Card> prodbcklog = board.fetchCards();  
                  
            
           
            
            
          // for (TList lista : lists) {
         //     System.out.println(lista.getName()+"- "+ lista.getId()+"-"+lista.getIdBoard());
         //  }
  
        }

    }
    public static void idSprints() {
   	 List<TList> lists = trelloApi.getBoardLists("6155b26a5aee2e1b21969f73");
   	 for( TList t : lists) {
   		 System.out.println(t.getName()+"- "+ t.getId());
   		 
   	 }
   	
   }
    
    public static String idprojeto() {
        Trello trelloApi = new TrelloImpl(Key_utilizado, Token_utilizador, new ApacheHttpClient());
        Board quadro = trelloApi.getBoard("6155b26a5aee2e1b21969f73");
         System.out.println(quadro.getName()+ "-" +quadro.getId());
         return "IDprojeto: " + quadro.getId();
    }
    
    
    public static String members() {
		String a = "";
          List<Member> memberlist = trelloApi.getBoardMembers("6155b26a5aee2e1b21969f73");
         
        for(Member m : memberlist) {
    		System.out.println(m.getUsername());
                a = a + m.getUsername() + "\n";	       	               
       }
        return "membros do grupo:" + "\n" + a;
       
    }
    
    
    public static String dataInicio() {
    	List<Card> data = trelloApi.getListCards("61a97c7f7d33d9301d5d0064");
      	return data.get(0).getDesc();
    }
   
    
    
    
    public static String dataInicioFim() {
    	String datas= "";
    	List<Card> timebetween = trelloApi.getListCards("617bee0ca4773838c00d646e");
    	for(Card time : timebetween) {
    		datas += time.getName() + "\n";
    	}
    	return datas;
    }
    
  

	public static String prodbcklog() {
		String items = "";
		List<Card> prodbacklog1 = trelloApi.getListCards("61aa6b9fc29fa014a7a3c9e7");
		List<TList> prodbacklog0 = trelloApi.getBoardLists("6155b26a5aee2e1b21969f73");
		
		for (TList t : prodbacklog0) {
			if(t.getId().equals("61aa6b9fc29fa014a7a3c9e7") ) {
			items = t.getName() + "\n";
			for (Card c : prodbacklog1) {
				
				items += c.getName() + "\n";
			}
			}
		}

		List<Card> prodbacklog2 = trelloApi.getListCards("61aa6bfd527a431a8928f582");

		for (TList t : prodbacklog0) {
			if(t.getId().equals("61aa6bfd527a431a8928f582") ) {
				items += "\n" +  t.getName() + "\n";
				for (Card c : prodbacklog2) {
					items += c.getName() + "\n";	
			}
			
			}

		}
		List<Card> prodbacklog3 = trelloApi.getListCards("61aba3b7044015198fecc95b");

		for (TList t : prodbacklog0) {
			if(t.getId().equals("61aba3b7044015198fecc95b") ) {
				items += "\n" +t.getName() + "\n";
				for (Card c : prodbacklog3) {
					items += c.getName() + "\n";
			}
			

			}

		}
		return items;
	}

    
	public static String datasTestesFuncoes() {
		String dataFuncoes = "";
		List<Card> functions = trelloApi.getListCards("6179c501e90a71294b548e59");
		
		for(Card fct : functions) {
			List<Label> label = fct.getLabels();
			for(Label l : label) {
				if(l.getName().equals("função")) {
					dataFuncoes += fct.getName() + "\n" + fct.getDesc() + "\n\n";
				}
				
			}
		}
		return dataFuncoes;
	}
    
  
    public static String getSprintText() {
        String sprintText = "SPRINT RETROSPECTIVE: \n";
        int x = 1;
        int y = 1;
        int z = 1;
        // String retrospective = "Sprint Retrospective";
       
        
        List<Card> pack = trelloApi.getListCards("6179c48c8ee4243dba9b4e5c");
        for(Card p : pack) {
            
           // sprintText +=  c.getName() + ":" + c.getDesc() + "\n";
            sprintText += "Sprint " + x + ":" + p.getDesc() + "\n";
            x++;
    }
        //System.out.println(" ");
        List<Card> pac = trelloApi.getListCards("6179c40a56110a54344a4526");
        sprintText += "\nSPRINT REVIEW: \n";
        for(Card p : pac) {            
            sprintText += "Sprint " + y + ":" + p.getDesc() + "\n";
           y++;
    }
        //System.out.println(" ");
        List<Card> pa = trelloApi.getListCards("617bee0ca4773838c00d646e");
        sprintText += "\nSPRINT PLANNING: \n";
        for(Card p : pa) {
        	sprintText += "Sprint " + z + ":" + p.getDesc() + "\n";
        	z++;
    }
        return sprintText;
}
    public static String horasPrevistasGastas() {
    	String horas="";
    	double spent = 0;
    	double estimated = 0;
    	List<Card> cardtime = trelloApi.getListCards("6179c501e90a71294b548e59");
    	for(Card prev : cardtime ) {
    		List<Action> acao = prev.getActions();
    		System.out.println(prev.getActions());
    		for(Action a : acao) {
    			if( a.getData().getText() != null && a.getData().getText().contains("plus!")  ) {
    			String str = a.getData().getText();
    	        String[] arrOfStr = str.split(" ", 2);
    	        String[] arrOfStr1 = arrOfStr[1].split("/", 2);
    			System.out.println(arrOfStr1[0] + " " +arrOfStr1[1]);
    			spent +=  Double.parseDouble(arrOfStr1[0]);
    			estimated += Double.parseDouble(arrOfStr1[1]);
    		}
    		}
    	}
    	horas = "Spent: " + spent + " Estimated: " + estimated;
    	System.out.println(spent);
    	System.out.println(estimated);
    	return horas;
    	
    }
            
		}
        
    }