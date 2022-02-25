// Required imports
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;


/**
 *  ColourGame class
 *   - it will help us to demonstrate the Colour game
 * 
 */
class ColourGame {
	
	private int totalGuess; // to store total number of time the player can make guesses
	
	private String secretCode; // to store secret colour code selected by Code Maker
	
	private Map<Character, Integer> secretMap; // to map the colours in the secret colour code with their position in the secret colour code
	
	
	private BufferedReader reader; // to take inputs
	
	/**
     *  Feedback class
     *  - this nested class will help us -
     *     to achieve Feedback result everytime player guess some colours
     */
	private class Feedback {
		
		public int correctPosition; // to store number of correct colours at correct positions gussed by the player
		
		public int wrongPosition; // to store number of correct colours but at wrong positions gussed by the player
		
		
        /**
         *  Parameterized Constructor
         * 
         * @param correctPosition : int
         * @param wrongPosition : int
         */
		Feedback (int correctPosition, int wrongPosition) {
			
			this.correctPosition = correctPosition;
			
			this.wrongPosition = wrongPosition;
			
		}
        
        /**
         *  toString function (Override)
         * 
         * @return : String : String representation of Feedback object 
         */
        @Override
        public String toString () {
			
			return "(" + correctPosition + "," + wrongPosition + ")";
			
		}
	
	}

    
    /**
     *  Non-parameterized Constructor
     * 
     *  initialize required objects
     */
	ColourGame () {
		
		reader = new BufferedReader( new InputStreamReader( System.in ) );// BufferedReader object initialization
		
		secretMap = new HashMap<>(); // Map object initialization
		
	}
	
	/**
     *  helps Code Maker to set total time and secret colour code
     * 
     * @throws IOException : if given bad input
     */
	public void setGame () throws IOException {
		
		totalGuess = Integer.parseInt( reader.readLine().trim() ); // total number of time the player can make guesses
		
		secretCode = reader.readLine().trim(); // secret colour code selected by Code Maker
		
        // map the colours in the secret colour code
        // with their position in the secret colour code
		for(int index = 0; index < 4; ++index){ 
			
			secretMap.put(secretCode.charAt(index), index);
			
		}
		
	}
	
	
	/**
     *  helps a player to play the game
     * 
     * @throws IOException : if given bad input
     */
	public void playGame () throws IOException {
		
		int remainingGuess = totalGuess; // to store remaining number of guesses
		
		// until remaining number of guesses become zero
        // the player can guess
		while ( remainingGuess > 0 ) {
			
			String userGuess = reader.readLine().trim(); // player's guessed colour code
			
			Feedback feedback = getFeedback( userGuess ); // feedback according to user guess
			
			System.out.println( feedback ); // show feedback
			
            // if user guessed all the colour 
            // and their correct position
            // that means the the player wins!!
			if( feedback.correctPosition == 4 ) {
				
				System.out.println("You Win!");
				
				return;
			}
			
            // as 1 guess has been made
            // remaining number of guesses decreased by 1
			remainingGuess--;
			
		}
		
		// player couldn't able to guess -
        // the right colour code in the given number of guesses
        // so the player loses
		System.out.println("You Lose!");
		
	}
	
	
	/**
     *  returns a Feedback based on -
     *   players's guessed code and Code Maker's secret code
     * 
     * @param userGuess : String : player's guessed colour code
     * @return : Feedback : feedback as per the guess
     */
	private Feedback getFeedback ( String userGuess ) {
		
		int correctPosition = 0; // to store number of correct colours at correct positions gussed by the player
		
		int wrongPosition = 0;// to store number of correct colours but at wrong positions gussed by the player
		

        // calculates the value of correctPosition and wrongPosition
		for(int index = 0; index < 4; ++index) {
			
			char currentColour = userGuess.charAt(index);
			
            // the colour present in the secret code
			if(secretMap.containsKey(currentColour)) {
				
                // the colour is present and their position is same
				if(secretMap.get(currentColour) == index) {

					correctPosition++;
					
				}
                // the colour is present but their position is different
				else {
					
					wrongPosition++;
					
				}
				
			}
			
		}
		
        // return Feedback
		return new Feedback( correctPosition, wrongPosition );
		
	}
	
}



public class Colordle {
	
	public static void main (String[] args) throws IOException {
		
		ColourGame game = new ColourGame(); // ColourGame object initialization
		
		game.setGame(); // Code Maker sets the game
		
		game.playGame(); // the player starts playing
	}
	  
}