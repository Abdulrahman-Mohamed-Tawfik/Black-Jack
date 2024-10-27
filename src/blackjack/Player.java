package blackjack;

public class Player
{
    String Name;
    int Score = 0;
    Card[] Player_hand_Cards = new Card[11];//Player_Cards = Player_in_hand_Cards
//11 is max num of cards that one player can have in his hand
 
    public Player(String name, int score) {
        this.Name = name;
        this.Score = score;
    }
     public int getScore() {
        return Score;
    }
Player(){}//used in game class

    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public void setScore(int score) {
        this.Score = score;
    }
}
