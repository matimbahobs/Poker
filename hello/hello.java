


//I am having a problem with my IDE it cannot import libraries and thats why i cant use the pocker library and everything done manually
/*
import org.junit.Test;
import static org.junit.Assert.assertEquals;
*/

public class hello {

	public static void main(String[] args) {

		//Suits S - Spade, D- Diamonds, H- hearts , etc
		String[] suits = {"S", "C", "D", "H", "f"};
		//Ranks 
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10","J","Q", "K", "A"};
		String[] Deck = new String[52];
		//for counting numbers of Js in a hand
		int countJ=0;
		
		//will use these to count the numbers repeating in one's hand
		int CountS = 1, CountH=1, CountD =1, CountC=1;
	
		for (int i = 0; i < Deck.length; i++) {
			Deck[i] = ranks[i%13]+ suits[i/13];
		}
		
		String temp="";
		//Shuffle the cards]
		System.out.println("Shuffling... Shufflinf.. Shuffling..");
		for (int i = 0; i < Deck.length; i++) 
		{
			int index = (int) (Math.random()*Deck.length);
			
			temp = Deck[i];
			Deck[i] = Deck[index];
			Deck[index] = temp;
		
		}
		

		//store hand cards
		String[] hand = new String[5];
		//handing 5 cards to the player
//	used this for testing my hand evaluations
//		hand[0] = "1S";
//		hand[1] = "2S";
//		hand[2] = "3S";
//		hand[3] = "4S";
//		hand[4] = "5S";
		for (int i = 0; i < 5; i++) {
			
			hand[i] = Deck[i];
		}
		System.out.println("Your hand");
		for (int i = 0; i < 5; i++) {
			
			System.out.println(hand[i]);
		}
		
		String [] arr = new String [5];   
		String [] arr2 = new String [5];
        
		for (int i = 0; i < hand.length; i++) {
			
			arr[i] = hand[i].substring(0,1);
			if(hand[i].length()==2)
			arr2[i] = hand[i].substring(1);
			
			else
				arr2[i] = hand[i].substring(2);
			
			
		}
		
		//Validating the strength of the hand		
     
        int straight = 0;
        //Searches for duplicate card numbers and Suits
        int sum =0;
        for(int i = 0; i < arr.length; i++) 
        {  
            for(int j =  i+1; j < hand.length; j++) {  
                if(arr[i].equalsIgnoreCase(arr[j]))  
                {
                 
                   sum++; 
                   
                   if(arr[i].equals("A"))
                   {
                	   arr[i] = "1";
                   }
                   
                	
               
                }
                
                if(arr[i].equalsIgnoreCase("J"))  
                {
                    
                	countJ++;
               
                }
                
                
                if(arr2[i].equals(arr2[j]))  
                {
                	//Count the number of similar Suits in hand
//                	System.out.println(arr2[j]);  
                	
                	if(arr2[j].equalsIgnoreCase("S"))
                		CountS++;
     
                	if(arr2[j].equalsIgnoreCase("D"))
                		CountD++;	
                		
                	if(arr2[j].equalsIgnoreCase("H"))
                		CountH++;	
                	
                	if(arr2[j].equalsIgnoreCase("C"))
                		CountC++;	
                	
                		
                }
                
                if(arr[i].equals("J")||arr[i].equals("K")||arr[i].equals("Q")||arr[i].equals("A"))
                	arr[i]="0";
            }  
        }  
	
        
        
/*
  This is my hand evaluation, i couldnt use a library since i am using a notepad so i had to code everything from scratch   
*/
        
        if(sum==1)
        {
        	System.out.println("You have one pair");
        }
        
        if(sum==2)
        {
        	System.out.println("You have two pair");
        }
        

        
        if(sum==6 && countJ!=1)
        {
        	System.out.println("You have 4 of a kind ");
        }
        
        if(sum==4)
        {
        	System.out.println("You have a full house ");
        }
        
        
        if(sum==3)
        {
        	System.out.println("You have 3 of a kind ");
        }
        
        

        boolean clubs = false;
        if(CountS==11||countJ==11||CountD==11||CountC==11)
        {
        	System.out.println("You have a Flush");
        	clubs = true;
        }
        boolean strait = false;
        
        	  if(Integer.parseInt(arr[4]) - Integer.parseInt(arr[3]) == 1 && Integer.parseInt(arr[3]) - Integer.parseInt(arr[2])==1 
              		&& Integer.parseInt(arr[2]) - Integer.parseInt(arr[1])==1
              		&&Integer.parseInt(arr[1])- Integer.parseInt(arr[0])==1)
              {
              	System.out.println("You have a Straight");
              	strait = true;
              }

      
        if(clubs== true && strait == true)
        {
        	System.out.println("you have a straight flush");
        }
        
        boolean chk = false;
        
    
        	  if(Integer.parseInt(arr[4]) - Integer.parseInt(arr[3]) == 1 || Integer.parseInt(arr[3]) - Integer.parseInt(arr[2])==1 
              		|| Integer.parseInt(arr[2]) - Integer.parseInt(arr[1])==1
              		||Integer.parseInt(arr[1])- Integer.parseInt(arr[0])==1)
              {
              	chk =true;
              }
			
		
        
        if(sum==0&& strait == false&& chk == true) 
        {
        	System.out.println("You have a High card ");
        }
        
        
	}
	
	

}
