package blackjack;
import java.util.*;
public class Game
{
    Scanner IN = new Scanner(System.in);
    Player[] players = new Player[4];
    Card[] cards = new Card[52];
    int index_of_card = 0;
    int winnerScore;
    
    public void generate_Cards()
    {
        for (int i = 0; i < 52; i++)
            cards[i] = new Card();
        
            for (int i = 0; i < 4; i++)
            {
                for (int j = 0; j <= 12; j++)
                {
                    cards[index_of_card].setSuit(i);
                    cards[index_of_card].setRank(j);
                    
                    if (j + 1 == 11 || j + 1 == 12 || j + 1 == 13){
                        cards[index_of_card].setValue(10);
                    }
                    else{                                           
                        cards[index_of_card].setValue(j + 1);  
                    }
                    index_of_card++;
               }
        }
    }
    
    
     public Card choose_Card_randomly()
    {
        Random rand = new Random();
        Card random_card;
        int random_choice = rand.nextInt(52);
        while (cards[random_choice] == null){
            
            random_choice = rand.nextInt(52);
            
        }
        random_card = cards[random_choice];
        cards[random_choice] = null;

        return random_card;
    }
    
     
public int get_winner(){
        for(int i=0;i<=3;i++){
    if(players[i].Score>21){
        players[i].Score=0;
    }
}
winnerScore = Math.max(Math.max(players[0].Score, players[1].Score),Math.max(players[2].Score, players[3].Score));

return winnerScore;
        }

    public void generate_Players()
    {
        for (int i = 0; i < 4; i++) {
            players[i] = new Player();

            System.out.println("Enter Player"+(i+1)+" Name :" );
            if(i==3){
                players[3].setName("Dealer");
            }
            else{
            players[i].setName(IN.next());
            }
            players[i].Player_hand_Cards[0] = choose_Card_randomly();
            players[i].Score += players[i].Player_hand_Cards[0].value;
            players[i].Player_hand_Cards[1] = choose_Card_randomly();
            players[i].Score += players[i].Player_hand_Cards[1].value;
        }
    }
    
    
    public void up_to_date(){
        int p1 = players[0].Score, p2 = players[1].Score, p3 = players[2].Score, D = players[3].Score;
        if(players[0].Score > 21){
            p1 = 0;
        }
         if(players[1].Score > 21){
            p2 = 0;
        }
          if(players[2].Score > 21){
            p3 = 0;
        }
           if(players[3].Score > 21){
            D = 0;
        }


        
}
}