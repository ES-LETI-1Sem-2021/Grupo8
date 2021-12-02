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


public class App 
{
    private static final String Token_utilizador = "e7343a347547e46213b153251f83183fc676a1cfd681016161bc0c10aada20ba";
    private static final String Key_utilizado = "9c85119a6d1dbcf03a104a12056029b7";
    private static final Trello trelloApi = new TrelloImpl(Key_utilizado, Token_utilizador, new ApacheHttpClient());
    public static void main( String[] args ){
        String trelloKey="Key_utilizador";
        String trelloAccessToken="Token_utilizador";
        
      
        Board board;
        List<Board> member=trelloApi.getMemberBoards("franciscoluz9"); //podem consultar o vosso nome_utilizador na opção "profile and visibility" da vossa conta no trello
        for (Board  quadro: member) {
            System.out.println(quadro.getName()+ "-" +quadro.getId());
            board = trelloApi.getBoard(quadro.getId());
            List<TList> lists = board.fetchLists();
            List<Member> memberlist = trelloApi.getBoardMembers(board.getId());
            
            //List<Card> prodbcklog =  trelloApi.getListCards("6179c4f431d63652d2dd088d",x);
           // System.out.println(prodbcklog);
         //  for( TList prodbckloglist :  lists ) {
//                if(prodbckloglist.getName() == "product backlog")
            //    System.out.println(prodbckloglist.getName() + "-" + prodbckloglist.getId());
           // }
            for (TList lista : lists) {
                System.out.println(lista.getName()+"- "+ lista.getId()+"-"+lista.getIdBoard());
            }
            for(Member m : memberlist) {
                System.out.println(m.getUsername());
                
           }
        }

    }
    public void idprojeto() {
        Trello trelloApi = new TrelloImpl(Key_utilizado, Token_utilizador, new ApacheHttpClient());
        Board quadro = trelloApi.getBoard("6155b26a5aee2e1b21969f73");
         System.out.println(quadro.getName()+ "-" +quadro.getId());
    }
    public void members() {
                
        List<Member> memberlist = trelloApi.getBoardMembers("6155b26a5aee2e1b21969f73");
            
  
            for(Member m : memberlist) {
                System.out.println(m.getUsername());
                
           }
        }

        
    }