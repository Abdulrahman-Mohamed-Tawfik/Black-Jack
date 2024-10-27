package blackjack;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.io.*;
public class BlackJack {
    static Game game = new Game();
    //for better console look
    public static final String green = "\u001B[32m";//to make text in green color
    public static final String red = "\u001B[31m";//to make text in red color
    public static final String blue = "\u001B[34m";//to make text in red color
    public static final String cyan = "\u001B[36m";//to make text in cyan color
    public static final String yellow = "\u001B[33m";//to make text in yellow color
    public static final String purple = "\u001B[35m";//to make text in purple color
    public static String winner_name = null ;
    public static int winner_number = 0;
    public static int y = 0;
    public static void main(String[] args) 
    {

        GUI gui = new GUI();        
        Scanner IN = new Scanner(System.in);

        game.generate_Cards();
        game.generate_Players();
        gui.runGUI(game.cards, game.players[0].Player_hand_Cards, game.players[1].Player_hand_Cards, game.players[2].Player_hand_Cards, game.players[3].Player_hand_Cards );
        int x = 2;
        int choice;


        Card ca;
        
        for(int i = 1; i < 4; i++){
             System.out.println(yellow+"Player"+ i +" \""+game.players[i-1].getName() +"\""+ " current score = "  + game.players[i - 1].Score);
             System.out.println("Type \"1\" for hit or type \"2\" for stand:");
             choice = IN.nextInt();
             if(choice == 2){//stand
                 x = 2;
                 continue;
             }
             else if(choice == 1){//hit
            ca = new Card();
            ca = game.choose_Card_randomly();
            game.players[i-1].Player_hand_Cards[x] = ca;
            gui.updatePlayerHand(game.players[i-1].Player_hand_Cards[x], i-1);
            game.players[i-1].Score += ca.value;
            game.up_to_date();}
             else{System.err.println("invalid input (please enter 1 or 2 only) ");}//neither hit nor stand
             
            if(game.players[i - 1].Score==21 )
            {
                System.out.println("player "+game.players[i - 1].getName()+" gets "+green+"BlackJack!");
                x = 2;
                continue;
            }
            if(game.players[i - 1].Score > 21){
                System.out.println(red+"player "+game.players[i - 1].getName()+" is busted!  (by score = "+game.players[i - 1].Score+")");
                x = 2;
                continue;
            }
            
            x++;
            i--;
        }
        
        x = 2;
        System.out.println("\n"+yellow+"Dealer's turn:");
        while(game.players[3].Score < 21){
            ca = game.choose_Card_randomly();
            game.players[3].Player_hand_Cards[x] = ca;
            gui.updateDealerHand(game.players[3].Player_hand_Cards[x], game.cards);
            game.players[3].Score += ca.value;
            game.up_to_date();
            x++;
            System.out.println("Dealer's score become "+game.players[3].Score);
            if(game.players[3].Score>21){
                System.out.println(red+"Dealer is Busted! (by score = " +game.players[3].Score+")");
            }
            if(game.players[3].Score==21){
                System.out.println(green+"Dealer gets blackjack!");
            }
            System.out.print("\n");
        }

        for(int i = 0; i < 4; i++){
           game.get_winner();
            if(game.winnerScore == game.players[i].Score){
                winner_name=game.players[i].getName();
               winner_number = i+1;
               y++;
           }
           
        }
        System.out.println(cyan+"_____________\n"+cyan+"the result :\n"+cyan+"_____________");
        if(y > 1)//found 2 players that have the same max score
        {
            System.out.println(blue+"Push!");
        }
        else if(y ==1){
            
            System.out.println(green+"Winner is Player" + winner_number +" \""+winner_name+"\" (by score = "+game.winnerScore+")\n");

        }

        System.out.println(purple+"_________end of game_______ ");
    }
    
}
