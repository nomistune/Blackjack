import java.io.*;
import java.util.*;

public class Main
{
    /* public variables */
    static Stack deck = new Stack();
    static String[] p1 = new String[5];
    static String[] p2 = new String[5];
    static String[] dealer = new String[5];
    
    static void shuffle() {
        
        ArrayList<Integer> RandomNumbers = new ArrayList<Integer>(52);
        
        // the deck
        String cards[] = {"AH", "AS", "AC", "AD", "2H", "2S", "2C", "2D", "3H", "3S", "3C", 
        "3D", "4H", "4S", "4C", "4D", "5H", "5S", "5C", "5D", "6H", "6S", "6C", "6D", "7H",
        "7S", "7C", "7D", "8H", "8S", "8C", "8D", "9H", "9S", "9C", "9D", "10H", "10S",
        "10C", "10D", "JH", "JS", "JC", "JD", "QH", "QS", "QC", "QD", "KH", "KS", "KC", "KD"};
		
		int i;
		int RN;
		
		for(i=0;i<52;i++){
		    RN = (int)(Math.random()*(51 + 1));
		    while(RandomNumbers.contains(RN)){
		        RN = (int)(Math.random()*(51 + 1));
		}
		    RandomNumbers.add(RN);
		    deck.push(cards[RandomNumbers.get(i)]);
		    
		}
		
	}
	// Pops card off of the stack and assigns the card to each player, thrice
	static void card_deal(){
	    p1[0]=deck.pop().toString();
	    p1[1]=deck.pop().toString();
	    p1[2]=" ";
	    p1[3]=" ";
	    p1[4]=" ";
	    p2[0]=deck.pop().toString();
	    p2[1]=deck.pop().toString();
	    p2[2]=" ";
	    p2[3]=" ";
	    p2[4]=" ";
	    dealer[0]=deck.pop().toString();
	    dealer[1]=deck.pop().toString();
	    dealer[2]=" ";
	    dealer[3]=" ";
	    dealer[4]=" ";
	    
	    System.out.println("Cards P1: " + Arrays.toString(p1));
	    System.out.println("Cards P2: " + Arrays.toString(p2));
	    System.out.println("Dealer's: " + Arrays.toString(dealer));
    }

    public static int total(String[] inputCards) {
    
    int total;
    int i;
    
    total = 0;
    
    // Obtaining a total
    for (i=0;i<5;i++){  
        switch (inputCards[i].substring(0,1)){
            case "A":
                total=total+11;
        break;
            case "K":
                total=total+10;
        break;
            case "Q":
                total=total+10;
        break;
            case "J":
                total=total+10;
        break;
            case "1":
                total=total+10;
        break;
            case "9":
                total=total+9;
        break;
            case "8":
                total=total+8;
        break;
            case "7":
                total=total+7;
        break;
            case "6":
                total=total+6;
        break;
            case "5":
                total=total+5;
        break;
            case "4":
                total=total+4;
        break;
            case "3":
                total=total+3;
        break;
            case "2":
                total=total+2;
        break;
            }
        }
        return total;
    }
    
    // Twist or stick method, displays your total and asks each player to either twist or stick
	static void twist_stick(){
	    Scanner input = new Scanner(System.in);
	    
	    String choice;
	    String choice2;
	    String choice3;
	    
	    int count;
	    
        // Player 1's twist or stick loop
        
        System.out.println("Player 1, Your total is " + total(p1) + " Would you like to Twist Or Stick?");
        
        choice = input.nextLine();
        count = 2;
        
        while (count < 5 && choice.equals("Twist") || choice.equals("T") || choice.equals("twist")){
            p1[count]=deck.pop().toString();
            System.out.println("Your cards: " + Arrays.toString(p1));
            System.out.println("Your new total is: " + total(p1));
            
                if (total(p1)>21){
                    System.out.println("Bust!");
                    break;
                }
                
            System.out.println("Twist or Stick?");
            choice = input.nextLine();
            
                if (choice.equals("Stick") || choice.equals("S") || choice.equals("s")){
                    break;
            }
            
            count++;
    }
        
        // Player 2's twist or stick loop
        System.out.println("Player 2, Your total is " + total(p2) + " Would you like to Twist Or Stick?");
        
        choice2 = input.nextLine();
        count = 2; // reset counter for next player
        
        while (count < 5 && choice2.equals("Twist") || choice2.equals("T") || choice2.equals("twist")){
            p2[count]=deck.pop().toString();
            System.out.println("Your cards: " + Arrays.toString(p2));
            System.out.println("Your new total is: " + total(p2));
            
                if (total(p2)>21){
                    System.out.println("Bust!");
                    break;
                }
                
            System.out.println("Twist or Stick?");
            choice2 = input.nextLine();
            
                if (choice2.equals("Stick") || choice2.equals("S") || choice2.equals("s")){
                    break;
                }
                
                count++;
    }
        
        // Dealer's twist or stick loop
        System.out.println("Dealer, Your total is " + total(dealer) + " Would you like to Twist Or Stick?");
        
        choice3 = input.nextLine();
        count = 2;
        
        while (count < 5 && choice3.equals("Twist") || choice3.equals("T") || choice3.equals("twist")){
            dealer[count]=deck.pop().toString();
            System.out.println("Your cards: " + Arrays.toString(dealer));
            System.out.println("Your new total is: " + total(dealer));
            
                if (total(dealer)>21){
                    System.out.println("Bust!");
                    break;
                }
                
            System.out.println("Twist or Stick?");
            choice3 = input.nextLine();
            
                if (choice3.equals("Stick") || choice3.equals("S") || choice3.equals("s")){
                    break;
                }
                
            count++;
            
        }
        
	}
	
	static void logic(){
	    
	    int TP1;
	    int TP2;
	    int Dealer;
	    
	    TP1 = total(p1);
	    TP2 = total(p2);
	    Dealer = total(dealer);
	    
	    //if statements to rule out busts
	    if (TP1 > 21){
	        TP1 = 0;
	    }

	    if (TP2 > 21){
	        TP2 = 0;
	    }
	    
	    if (Dealer > 21){
	        Dealer = 0;
	    }
	    
	    //if statements to dictate the winner                                   **Add a if statements to cancel out busts**
	    
	    if (TP1 < 22 && TP1 > TP2 && TP1 > Dealer){
	        System.out.println("Player 1 Wins with a Total of " + TP1 + "!!!");
	    }
	    
	    if (TP2 < 22 && TP2 > TP1 && TP2 > Dealer){
	        System.out.println("Player 2 Wins with a Total of " + TP2 + "!!!");
	    }
	    
	    if (Dealer < 22 && Dealer > TP1 && Dealer > TP2){
	        System.out.println("The Dealer Wins with a Total of " + Dealer + "!!!");
	    }
	    
	    if (TP1 == TP2 && TP1 > Dealer){
	        System.out.println("Players 1 & 2 Tie!!!");
	    }
	    
	    if (TP1 < 22 && TP1 == Dealer && TP1 > TP2){
	        System.out.println("Player 1 Wins with a Total of " + TP1 + "!!!");
	    }
	    
	    if (TP2 < 22 && TP2 == Dealer && TP2 > TP1){
	        System.out.println("Player 1 Wins with a Total of " + TP2 + "!!!");
	    }
	    
	    if (TP1 > 21 && TP2 > 21 && Dealer > 21){
	        System.out.println("Nobody Wins... :(");
	    }
	    
	}

	public static void main(String[] args) {
		System.out.println("Blackjack:");
		
		shuffle();
		card_deal();
		twist_stick();
		logic();
	}
}





