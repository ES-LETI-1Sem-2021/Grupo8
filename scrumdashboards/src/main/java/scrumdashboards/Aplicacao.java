package ESGRUPO8.esgrupo8;

import java.util.List;

import com.julienvey.trello.Trello;
import com.julienvey.trello.domain.Argument;
import com.julienvey.trello.domain.Board;
import com.julienvey.trello.domain.Card;
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
            prodbcklog();
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
    public static String prodbcklog() {
    	String items= "";
    	List<Card> prodbacklog = trelloApi.getListCards("6179c4f431d63652d2dd088d"); 
    	
    	 for (Card c : prodbacklog) {
    		items += c.getDesc() + "\n";
    		 
    		 //System.out.println(c.getDesc());
    	 }
    	 return items;
    	    
        
    }
    public static String idprojeto() {
        Trello trelloApi = new TrelloImpl(Key_utilizado, Token_utilizador, new ApacheHttpClient());
        Board quadro = trelloApi.getBoard("6155b26a5aee2e1b21969f73");
         System.out.println(quadro.getName()+ "-" +quadro.getId());
         return "IDprojeto: " + quadro.getId();
    }
    
    public static String dataInicio() {
    	List<Card> data = trelloApi.getListCards("61a97c7f7d33d9301d5d0064");
      	return data.get(0).getDesc();
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
    public static String getSprintText() {
        String sprintText = "";

        List<Card> pack = trelloApi.getListCards("6179c48c8ee4243dba9b4e5c");
            for(Card c : pack) {
                
                sprintText += c.getName() + ":" + c.getDesc() + "\n";
                
        }
            System.out.println(" ");
            List<Card> pac = trelloApi.getListCards("6179c40a56110a54344a4526");
            for(Card c : pac) {
                System.out.println(c.getName() + ": " + c.getDesc());
                sprintText += c.getName() + ":" + c.getDesc() + "\n";

        }
            System.out.println(" ");
            
            List<Card> pa = trelloApi.getListCards("617bee0ca4773838c00d646e");
            for(Card c : pa) {
            	sprintText += c.getName() + ":" + c.getDesc() + "\n";

        }
            return sprintText;
    }

        
    }