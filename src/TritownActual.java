import java.util.Random;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class TritownActual {
	public static int boardSize = 6; // The game is based on a 6*6 Gridpane

	// The board to store data and combine them
	public static int[][] board = new int[boardSize][boardSize];	
	
    public static int nextValue; // A random number that determines the input
    public static int Score; // A universal variable to store scores
    
    // A decent long array to store the trace of cats
    public static int[] CatPos= new int [30]; 
       
    public static int count = 0;
    
    // Define the object as following number
    public static final int tree1 = 1;
    public static final int tree2 = 2;
    public static final int tree3 = 3;
    public static final int house = 4;
    public static final int cat = 8;
    
    /**
     * Initial the board with some random numbers
     */
    public static void initialGame() {
    	// To restrict the number of the initial board
    	int grassNum = 5;
    	int bushNum = 2;
    	int treeNum = 1;
    	
    	int numBlanks = boardSize * boardSize; // Starts with 6*6 blank grids
    	int nextSlot = 0;
    	int slots = 0;
    	
    	// Generate a new random number
    	Random rand = new Random();
    	nextSlot = rand.nextInt(numBlanks - 1); 
    	
    	// If the condition is satisfied, generate a new number
    	// Same for the next two loops
    	for (int i = 0; i < grassNum; i++) {
    		for (int j = 0; j < boardSize; j++) {
    			for (int k = 0; k < boardSize; k++) {
    				if (board[j][k] == 0 && nextSlot == slots) {
    						board[j][k] = 1;
    						numBlanks--;
    						nextSlot = rand.nextInt(numBlanks - 1) + 1; 
    						slots = 0;
    					}
    				slots++;
    				}
    			}
    		}
    	
    	slots = 0; // Return the slot to 0 to start forming next element
    	for (int i = 0; i < bushNum; i++) {
    		for (int j = 0; j < boardSize; j++) {
    			for (int k = 0; k < boardSize; k++) {
    				if (board[j][k] == 0 && nextSlot == slots) {
    						board[j][k] = 2;
    						//count++;
    						numBlanks--;
    						nextSlot = rand.nextInt(numBlanks - 1) + 1; 
    						slots = 0;
    					}
    				slots++;
    				}
    			}
    		}
    	
    	slots = 0;
    	for (int i = 0; i < treeNum; i++) {
    		for (int j = 0; j < boardSize; j++) {
    			for (int k = 0; k < boardSize; k++) {
    				if (board[j][k] == 0 && nextSlot == slots) {
    						board[j][k] = 3;
    						//count++;
    						numBlanks--;
    						nextSlot = rand.nextInt(numBlanks - 1) + 1; 
    						slots = 0;
    					}
    				slots++;
    				}
    			}
    		}
    	
    	board[0][0] = 0; //Ensure the point (0,0) is 0
    }
	
    /**
     * Calculate the number of blank plots in the board
     * 
     * @return blank - the number of blank plots
     */
    public static int getBlankPlots() {
    	int blank = 0;
    	for(int i = 0; i < boardSize; i++) {
    		for (int j = 0; j < boardSize; j++) {
    			if (board[i][j] ==0) {
    				blank++;
    			}
    		}
    	}
    	return blank;
    }
   

    /**
     * Start the calculate of game
     * Called when user second-click the same grid
     * 
     * @param y - the actual x-position of the grid
     * @param x - the actual y-position of the grid
     */
    public static void Algorithm(int y, int x) {
    	
    	// Check if the input position is legal
    	if (board[x][y] == 0 || board[x][y] >= 8) {
    		board[x][y] = nextValue;
    	} 
    	else { 
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Illegal Place");
    		alert.setHeaderText(null);
    		alert.setContentText("You should not put on an existing item");
    		alert.showAndWait();
    	}
    	
    	// Set the cats run randomly
    	int count = 0;
    	// Set every element in the array to zero before computing a new one
     	for(int i = 0; i < CatPos.length; i++) {
    		CatPos[i] = 0;
    	}
    		
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board.length; j++) {
    			if (board[i][j] == 8) {
    				CatRun.catRun(i, j);
    				CatPos[count] = CatRun.nextX;
    				CatPos[count+1] = CatRun.nextY;
    				count+=2;
    			}   				
    		}
    	}

    		
    	for (int i = 0; i < CatPos.length; i+=2) {
    		if (CatPos[i] != 0 || CatPos[i+1] != 0) {
    			board[CatPos[i]][CatPos[i+1]] = 8;
    		}
    		else {break;}
    	}

    	// Repeat four times to get the ultimate result	
    	for (int a = 0; a < 4; a++) { 
    		
    		// Call the method in combine to transform the board
    		Combine.InitialNumSame();
    		Combine.StartPoint(x, y);
    		Combine.SameObject(x, y);
    		
    		// Get the number of same objects
    		int sameNum = Combine.ReturnSame();
    		
    		// Increase the score based on the value of grid
    		Score += sameNum*board[x][y]*board[x][y]; 
    		
    		// Increase the value by 1 if there are more than three same objects
    		if (sameNum > 2) {
    			board[x][y] = Combine.ReturnValue()+1;
	    	}
	    		
    		// The two same objects remain the same
    		else if (sameNum == 2){
    			board[x][y] = Combine.ReturnValue();
    			board[Combine.ReturnX2()][Combine.ReturnY2()] 
    					= Combine.ReturnValue();
	    	}
    		// Do not make a change if there is only one object
    		else {
    			board[x][y] = Combine.ReturnValue();
	    	}
    	}
    }
    
    /**
     * Generate a new random number and assign it to "nextValue"
     * The "if" judgments set the possibility of the next value
     */
    public static void nextObject() {
    	Random rand = new Random();
	    
		int k = rand.nextInt(140);
		if (k >= 0 && k < 80) {			
			nextValue = tree1;
		}
		else if (k >= 80 && k < 110) {
			nextValue = tree2;
		}
		else if (k >= 110 && k < 125) {
			nextValue = tree3;
		}
		else if (k >= 125 && k < 135) {
			nextValue = house;
		}
		else {
			nextValue = cat;
		}
    }
}



