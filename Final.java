package finalProject;


public class Beginner {
	public static void main(String[] args) //Start of the main method   
	{
	  String player1 = JOptionPane.showInputDialog("Enter Player 1: "); //pops up a dialog box and asks the user to input their name
	  if (player1 == null)
	  {  
	    return;
	  }
	  player1 = player1.trim(); //Trims spaces out of player name
	  Name1 = player1.length() <= 1 ? "Player1" : player1; //sets the variable Name1 to player1
	  Beginner object = new Beginner(); // creates a beginner object
	  object.setDefaultCloseOperation(3);
	  object.setVisible(true); //object window is visible
	  object.setSize(520, 515); //sets the size of the window object
	  object.setResizable(false); // object is not resizable to the user
	}

	class AIWork //Makes the AI work
	  extends java.util.TimerTask //A task that can be scheduled for one-time or repeated execution by a timer
	{
	  int[][] position; //creates a 2D int array position
	  
	  int gameBoard;
	  int aaa;			//created 3 different ints for AIWork
	  int bbb;
	  
	  AIWork() {} 
	  
	  public void take(int board, int aa, int bb) 
	  {
	    gameBoard = board;
	    aaa = aa;
	    bbb = bb;
	    position = Beginner.this.scale(gameBoard);
	  }

	  public void run() //method run is being created in AIWork
	  {
	    if (Fill())
	      return;
	    int a = -1;
	    int b = -1;
	    int low = 0;              //Int's created for use in run
	    int high = 8;
	    int low1 = 0;
	    int high1 = 8;
	    if (unavoidable)
	    {
	      low = position[0][0];
	      high = position[1][0];    //int's set equal to position arrays
	      low1 = position[0][1];
	      high1 = position[1][1];
	      int index = -1; //index is set to -1
	      boolean here = false; //here is set to false 
	      
	      for (int i = low; i <= high; i++) 
	      {
	        for (int j = low1; j <= high1; j++)
	        {
	          index++; 
	          if (index == gameBoard)	//index is set to gameBoard
	          {
	            if (Beginner.this.isNear(i, j)) //beginner.isNear is being called, set to (i, j) here becomes true
	            {
	              here = true; 
	            }
	            a = i; //a being set to i
	            b = j; // b is being set to j
	          }
	        }
	      }
	      if (here)
	      {
	        for (;;) // infinite loop
	        {
	          a = low + (int)(Math.random() * (high - low + 1)); //a is being calculated
	          b = low1 + (int)(Math.random() * (high1 - low1 + 1));	//b is being calculated
	          if (!Beginner.this.isNear(a, b)) { //Beginner.isNear is being called, a,b is the position selected // '!' makes the oposite happen
	            break; //breaks the infinite loop
	          }
	        }
	      }
	    }
	    else {
	      boolean finish = false; //finish is being set to false
	      
	      for (int allTheBoards = 0; allTheBoards <= 8; allTheBoards++) //int allTheBoards being created
	      {
	        if (!Beginner.this.playoffisSolved(allTheBoards)) //Beginner.playoffisSolved is being called, passing allTheBoards to playoffisSolvved
	        {
	          int[][] location = Beginner.this.scale(allTheBoards); //Beginner.scale is being called, location is the location in which the AI choose to put an O
	          int cc = location[0][0];
	          int dd = location[1][0]; 	
	          int cc1 = location[0][1];		//ints being created for location in the boxes
	          int dd1 = location[1][1];
	          int index = -1;
	          for (int r = cc; r <= dd; r++)  
	          {
	            for (int p = cc1; p <= dd1; p++)
	            {
	              index++; 
	              if (index == allTheBoards) //index is set to equal allTheBorads
	              {
	                if (!Beginner.this.isNear(r, p)) //beginner.isNear is being called, is set to (r, p), finish becomes true
	                {
	                  a = r; //a is being set to r
	                  b = p; //b is being set to p
	                  finish = true; 
	                }
	              }
	            }
	          }
	        }
	      }
	      if (!finish) 
	      {
	        for (;;) //infinite loop
	        {
	          a = low + (int)(Math.random() * (high - low + 1)); // a is being calculated 
	          b = low1 + (int)(Math.random() * (high1 - low1 + 1)); // b is being calculated
	          if ((!Beginner.this.isNear(a, b)) && (Beginner.this.GameOver(Beginner.access$300(Beginner.this, a, b)) < 0)) //beginner.isNear & beginner.GameOver nested beginner.access$300
	            break; //breaks the infinite loop
	        }
	      }
	    }
	    Beginner.this.enableAllplayoffs();
	    button[a][b].doClick(); // creates a click as if the user has in which the AI places an O
	  } // End run
	  
	  public int[] copy(int[] i) //creates an int array copy
	  {
	    int[] j = new int[i.length]; // int[] j is created as a new int with i.length as the parameter
	    for (int x = 0; x < i.length; x++)
	      j[x] = i[x];
	    return j;
	  }
	  
	  public int[][] copy(int[][] i) //creates a 2D int array copy
	  {
	    int[][] j = new int[i.length][i[0].length]; // int[][] j is created as a new int with i.length as the parameter
	    for (int x = 0; x < i.length; x++)
	      j[x] = copy(i[x]);
	    return j;
	  }
	  
	  public int[][][] copy(int[][][] i) //creates a 3D int array copy
	  {
	    int[][][] j = new int[i.length][i[0].length][i[0][0].length]; // int[][][] j is created as a new int with i.length as the parameter
	    for (int x = 0; x < i.length; x++)
	      j[x] = copy(i[x]);
	    return j;
	  }
	  
	  public boolean Fill() //method fill is being created inside of AIWork
	  {
	    for (int t = 0; t <= 2; t += 2)  
	    {
	      if (unavoidable) 
	      {
	        for (int x = position[0][0]; x <= position[1][0]; x++)
	        {
	          for (int y = position[0][1]; y <= position[1][1]; y++)
	          {
	            if (!Beginner.this.isNear(x, y)) //Beginner.isNear is being called
	            {
	              int[][][] final_game = copy(game); // a 3D int array final_game is being set to copy(game)
	              int[][] final_mainGame = copy(mainInterface); //a 2D int array final_mainGame is being set to copy(mainInterface)
	              Beginner.this.input(x, y, 0);
	              if ((Beginner.this.GameOver(gameBoard) == 0) || (Beginner.this.isB_Filled(gameBoard))) //Beginner.GameOver is being called gameboard being equal to 0 or beginner.isB_FIlled 
	              {
	                game = final_game; //game is set to final_game
	                mainInterface = final_mainGame; //mainInterface is being set to final_mainGame
	                Beginner.this.enableAllplayoffs(); //Beginner.enableAllplayoffs is being called
	                button[x][y].doClick(); // creates a click as if the user has thats where the AI sets an O
	                return true;
	              }
	              game = final_game; //game is being set to final_game
	              mainInterface = final_mainGame; //mainInterface is being set to final_mainGame
	            }
	            
	          }
	          
	        }
	      } else {
	        for (int x = 0; x <= 8; x++)
	        {
	          for (int y = 0; y <= 8; y++)
	          {
	        	  if ((!Beginner.this.isNear(x, y)) && (!Beginner.this.playoffisSolved(Beginner.access$300(Beginner.this, x, y)))) //!Beginner.isNear is being called & !Beginner.playoffisSolved nested in access$300
	            {
	              int[][][] keep_game = copy(game); //a 3D int array keep_game is created and set equal to copy(game)
	              int[][] keep_mainGame = copy(mainInterface); // a 2D int array keep_MainGame is created and set equal to copy(MainInterface)
	              Beginner.this.input(x, y, 0); //Beginner.input is called and has parameters
	                if ((Beginner.this.GameOver(Beginner.access$300(Beginner.this, x,y)) == 0) || (Beginner.this.isB_Filled(Beginner.access$300(Beginner.this, x, y))))
	              {
	                game = keep_game; //game is set equal to keep_game
	                mainInterface = keep_mainGame; // mainInterface is set equal to keep_mainGame
	                Beginner.this.enableAllplayoffs(); //Beginner.enableAllplayoffs is called 
	                button[x][y].doClick(); // creates a click as if the user has thats where the AI sets an O
	                return true;
	              }
	              game = keep_game; //game is set equal to keep_game
	              mainInterface = keep_mainGame; //mainInterface is set equal to keep_mainGame
	            }
	          }
	        }
	      }
	    }
	    return false;
	  }
	}
	//is a synthetic method has been created to provide its private String to the enclosing class. 
	public static int access$300(Beginner beginner, int x, int y) {
	    return 0; 
	    }
}
