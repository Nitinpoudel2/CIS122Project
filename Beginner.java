package game;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Beginner extends javax.swing.JFrame implements java.awt.event.ActionListener
{
	//creating a frame for the tab of the gaming
	java.awt.Font f = new java.awt.Font("Arial Black", 3, 25);
	// also assigning a varible font f 
	java.awt.Font f1 = new java.awt.Font("Arial Black", 3, 16);
	// creating another variable with the coding 
	JTextField turn = new JTextField(19);
	//here the JTextFieldis  lightweight component that allows the editing of a single line of text 
	int[][] mainInterface = new int[3][3];
	// defining a array of two dimension that is it creates 3X3 tab in the coding 
	int[][][] game = new int[9][3][3];
	// another variable assigned for the array we will be needing 3 dimensional array
	JButton[][] button = new JButton[9][9];
	//JButton generally represents a button that, when clicked by the user, carries out a particular action.
	javax.swing.JPanel[][] p = new javax.swing.JPanel[3][3];
	/*
	 *  creating a array pannel to store the coding in the main game memory
	 *
	 *helps in layouts which can store all the components of the coding and gives organized storage of the components
	 */ 
	javax.swing.JPanel np = new javax.swing.JPanel();
	//creating a private class of the game which is only accessible by the members 
	boolean player1 = true;
	
	int r = 0; int h = 0;
	
	boolean buttonPressed = false;
	
	int next = -1;
	
	boolean unavoidable = false;
	
	static String Name1;
	int alternate = 0;

	private Beginner() {
		//creating a class in the coding 
		super("The Ultimate Tic-Tac-Toe");
		
		setLayout(new java.awt.FlowLayout());
		
		np.setLayout(new java.awt.GridLayout(3, 3));
		// here the coding gridlayout actually arranges the components in the rectangular grid where they are displayed in rectangle

		for (int x = 0; x <= 2; x++)
		{// here we are using a for loop in the coding to align the tabs int he coding 
			for (int y = 0; y <= 2; y++)
			{
				p[x][y] = new javax.swing.JPanel();
				//assigning variable for the Jpanel in the javax swing JPanel
				// assigning array list in the coding for the 
				p[x][y].setLayout(new java.awt.GridLayout(3, 3));
				// here it sets up the layout as the 3X3 format of the coding 
				np.add(p[x][y]);
				// we are assigning a new variable and again assigning it to another variable to make a call in the coding later 
				p[x][y].setBorder(new javax.swing.border.LineBorder(java.awt.Color.BLACK, 3, true));
				// here we set the layout of bars and border of the java game
			}
		}

		for (int x = 0; x < 9; x++)
		{ // here we are using another for loop inside of the for loop to set the
			for (int y = 0; y < 9; y++)
			{
				button[x][y] = new JButton();
				// assigning variable for the array list that is 2 dimensional in the coding game 
				button[x][y].setFont(f);
				// here we are calling the variable f font 
				button[x][y].setText("  ");
				// here we are adding two buttons in the loop and diving it into 3 types
				p[(x / 3)][(y / 3)].add(button[x][y]);
				button[x][y].addActionListener(this);
				//here add ActionListener takes the current class object as a parameter and this" key word simply means "this object I'm working in right now"
				button[x][y].setBackground(new java.awt.Color(255, 255, 153));
				// now we are setting the background of the two dimensional array in the background 
			}
		}
		initial();
		/* initializing the code here by defining all the border font , 
		*fore background and everything that we will be using  
		**/
		turn.setBorder(new javax.swing.border.LineBorder(java.awt.Color.BLACK, 2, true));
		// we set the JTextField variable as turn in the coding
		turn.setFont(f);
		// here we are calling the turn variable java TextField and using the method setFont to call variable f in the turn 
		turn.setBackground(new java.awt.Color(255, 255, 153));
		// here rwe are setting the background color of the java game
		turn.setForeground(java.awt.Color.BLUE);
		// here we are setting the foreground as blue which shows the color of the gamers in the code
		turn.setHorizontalAlignment(0);
		turn.setText(Name1 + "'s turn");
		// here we are making this thing pop up in the tab by putting the user input name and turn in the game
		turn.setEditable(false);
		// now here we are adding and calling the turn varibale which stores the data in the gaming
		add(turn);
		add(np);
		//adding this in the gming code and calling it with array
		np.setVisible(true);
		//this method makes the method visible and is able to access later in the game to override
	}
	private int[] hpm(int playoff)
	{
		int i = -1;
		int[] ar = { -1, -1 };
		for (int x = 0; x <= 2; x++)
		{
			for (int y = 0; y <= 2; y++)
			{
				i++;
				if (playoff == i)
				{
					ar[0] = x;
					ar[1] = y;
				}
			}
		}
		return ar;
	}




	private int byteMark(int r, int c)
	{
		int i = -1;
		for (int x = 0; x <= 2; x++)
		{
			for (int y = 0; y <= 2; y++)
			{
				i++;
				if ((x == r) && (y == c))
					return i;
			}
		}
		return i;
	}

	private void initial()
	//here it is defining all the border font
	{
		//In this code snippet there are two loops, 
		//for playoff =0, inside loop iterates for play off greater than 9. 
		for (int playoff = 0; playoff < 9; playoff++)
			//Using for loop here for the integer.
			//Drawing the pieces for the board.
		{
			for (int x = 0; x <= 2; x++)
			{
				for (int y = 0; y <= 2; y++) {
					game[playoff][x][y] = -1;
				}
			}
			//using nested for loop 
		}
		//In this code snippet there are two loops, 
		//for x =0, inside loop iterates for three times and printing sum of the value of x and y. 
		for (int x = 0; x <= 2; x++)
		{
			for (int y = 0; y <= 2; y++) {
				mainInterface[x][y] = -1;
			}//method of using nested for loop again
		}
	}
	//designates the boolean primitive type which are only two possible values TRUE or FALSE only.
	private boolean isNear(int x, int y) {
		//the x and y coordinate of the points of the playoff.
		int playoff = playoffNumber(x, y);
		int[] pos = positionInBoard(x, y);
		if (game[playoff][pos[0]][pos[1]] < 0)
			return false;
		return true;
		//returning true of false
	}

	////designates the boolean primitive type which are only two possible values TRUE or FALSE only.
	private boolean playoffisSolved(int playoff)
	{
		//hpm stores integers.
		int[] pos = hpm(playoff);
		//using if statement if it comes less or equals to 0, to get the return value.
		if (mainInterface[pos[0]][pos[1]] >= 0)
			return true;
		return false;
		//returning true of false statement
	}



	///This method finds the sum of digits of odd places
	private boolean isB_Filled(int playoff)
	{
		//using for loop here
		////In this code snippet there are two loops, 
		//for x =0, inside loop iterates for three times and printing sum of the value of x and y. 
		for (int x = 0; x <= 2; x++)
		{
			for (int y = 0; y <= 2; y++)
			{
				if (game[playoff][x][y] < 0)
					return false;
			}//using nested for loop
		}
		return true;
		//returning the value if it is true
	}

	private int GameOver(int playoff)
	{
		//using for loop method to end the game here
		for (int player = 0; player <= 1; player++)
		{
			boolean isSolved = true;
			// here we are defining variable as a boolean to later invoke and use it in the coding 
			for (int x = 0; x <= 2; x++)
			{// trying to iteraete the for loop for the game playoff between 2 dimensional array in the coding 
				if (game[playoff][x][x] != player)
					// given if the statement is not satisfied print false
					isSolved = false;
				///conforming the game if it is true or false by the user input
			}
			if (isSolved) {
				// here the if method is iterated and the variable isSolved is called upon
				return player;
				// if this is satisfied then it returns the player in the coding 
				
			}
			isSolved = true;
			// if satisfied then the variable is true 
			for (int x = 0; x <= 2; x++)
			{
				if (game[playoff][x][(2 - x)] != player)
					isSolved = false;
				//here the game variable is refering it to the arrays int x and given a loop
			}
			if (isSolved) {
				// given the loop the variable player is called 
				return player;
				// variable player is returned 
			}
			for (int x = 0; x <= 2; x++)
			{// for a given loop x is equal to 2 then the given loop iterates
				isSolved = true;
				// if the variable is true then it iterates in the loop 
				//using for loop for the result in the coding if another value then it goes in the loop 
				for (int y = 0; y <= 2; y++)
				{
					if (game[playoff][x][y] != player)
						isSolved = false;
				}
				if (isSolved) {
					return player;
				}
				isSolved = true;
				for (int y = 0; y <= 2; y++)
				{
					if (game[playoff][y][x] != player)
						isSolved = false;
				}
				if (isSolved)
					return player;
			}
		}
		return -1;
		//
	}
	/*
	 * creating a method in the game for the game over part of the coding 
	 * calling the variable  for the boolean value and connecting it the main game of the coding  
	 * if the loop is satisfied it the game is over and if not then it goes into another loop in the game 
	 * 
	 */
	private int GameOver()
	//Method to give an access modifier
	{
		int return_player = -1;

		for (int player = 0; player <= 1; player++)
		{
			boolean isSolved = true;
			for (int x = 0; x <= 2; x++)
			{
				if ((mainInterface[x][x] != 2) && (mainInterface[x][x] != player))
					isSolved = false;
			}
			if (isSolved)
			{
				if (return_player == 0)
					return 2;
				return_player = player;
			}
			else
			{
				isSolved = true;
				for (int x = 0; x <= 2; x++)
				{
					if ((mainInterface[x][(2 - x)] != 2) && (mainInterface[x][(2 - x)] != player))
						isSolved = false;
				}
				if (isSolved)
				{
					if (return_player == 0)
						return 2;
					return_player = player;
				}
				else
				{
					for (int x = 0; x <= 2; x++)
					{
						isSolved = true;
						for (int y = 0; y <= 2; y++)
						{
							if ((mainInterface[x][y] != 2) && (mainInterface[x][y] != player))
								isSolved = false;
						}
						if (isSolved)
						{
							if (return_player == 0)
								return 2;
							return_player = player;
							break;
						}

						isSolved = true;
						//// for loop for integer y starting at 0, ending at greater or equals to 2, increasing
						for (int y = 0; y <= 2; y++)
						{
							if ((mainInterface[y][x] != 2) && (mainInterface[y][x] != player))
								isSolved = false;
						}
						if (isSolved)
						{
							if (return_player == 0)
								return 2;
							return_player = player;
							break;
						}
					}
				} } }
		return return_player;
	}

	/*designates the boolean primitive type which are only two possible values 
		TRUE or FALSE only			private boolean playoffisSolved(int playoff)
	 * 
	 * 
	 */
	private int playoffNumber(int x, int y)
	//access a private modifier  
	{
		if (x < 3)
		{
			if (y < 3)
				return 0;
			if (y < 6)
				return 1;
			return 2;
		}
		if (x < 6)
		{
			if (y < 3)
				return 3;
			if (y < 6)
				return 4;
			return 5;
		}
		if (y < 3)
			return 6;
		if (y < 6)
			return 7;
		return 8;
		// returnig the only true and false boolean value of the coding .
	}
	// method that gives the game dimensions based on what tic-tack-toe section you are on
		private int[][] scale(int playoff)
		{
			// starting off every variable at -1
			int a = -1;int b = -1;int c = -1;int d = -1;
			if (playoff == 0)
			{ //if its the first tic-tack-toe board, the variables get assigned to these values
				a = 0;
				b = 0;
				c = 2;
				d = 2;
			}
			if (playoff == 1)
			{//if its the 2nd tic-tack-toe board, the variables get assigned to these values
				a = 0;
				b = 3;
				c = 2;
				d = 5;
			}
			if (playoff == 2)
			{//if its the 3rd tic-tack-toe board, the variables get assigned to these values
				a = 0;
				b = 6;
				c = 2;
				d = 8;
			}
			if (playoff == 3)
			{//if its the 4th tic-tack-toe board, the variables get assigned to these values
				a = 3;
				b = 0;
				c = 5;
				d = 2;
			}
			if (playoff == 4)
			{//if its the 5th tic-tack-toe board, the variables get assigned to these values
				a = 3;
				b = 3;
				c = 5;
				d = 5;
			}
			if (playoff == 5)
			{//if its the 6th tic-tack-toe board, the variables get assigned to these values
				a = 3;
				b = 6;
				c = 5;
				d = 8;
			}
			if (playoff == 6)
			{//if its the 7th tick-tack-toe board, the variables get assigned to these values
				a = 6;
				b = 0;
				c = 8;
				d = 2;
			}
			if (playoff == 7)
			{//if its the 8th tick-tack-toe board, the variables get assigned to these values
				a = 6;
				b = 3;
				c = 8;
				d = 5;
			}
			if (playoff == 8)
			{//if its the 9th tic-tack-toe board, the variables get assigned to these values
				a = 6;
				b = 6;
				c = 8;
				d = 8;
			}
			// returns a 2D array with the specific variable values related to which playoff you are on
			int[][] ar = { { a, b }, { c, d } };
			return ar;
		}

	// position in board method that returns an array, indicating where you are in the ultimate tic-tack-toe board

		private int[] positionInBoard(int r, int c)
		{
			// takes two integers runs them through a method called PlayoffNumber, which takes the integers and based on their values,
			// returns a specific integer
			int playoff = playoffNumber(r, c);
			int[][] pos = scale(playoff);
			int a = 0;
			int[] ar = { -1, -1 };
			for (int x = pos[0][0]; x <= pos[1][0]; a++)
			{
				int b = 0;
				for (int y = pos[0][1]; y <= pos[1][1]; b++)
				{
					if ((r == x) && (y == c))
					{
						ar[0] = a;
						ar[1] = b;
						return ar;
					}
					// both x and y get increased
					y++;
				}
				x++;
			}
			return ar;
		}

		// non returnable method called input that takes 3 integers as parameters
		private void input(int x, int y, int number)
		{
			//finds which playoff the values are from
			int playoff = playoffNumber(x, y);
			// locates the position in the board
			int[] pos = positionInBoard(x, y);
			game[playoff][pos[0]][pos[1]] = number;
		}

		// simple yes or no method that takes into account if all spots are taken
		private boolean mainInterfaceFull()
		{
			// integer x is on a for loop
			for (int x = 0; x <= 2; x++)
			{ // integer y is on a for loop
				for (int y = 0; y <= 2; y++)
				{  //checks to see if the game at indexes x and y are less than zero
					// if so, return false
					if (mainInterface[x][y] < 0)
						return false;
				}
			} // otherwise return true
			return true;
		}
	// no returnable method that disables the playoffs that your not allowed to play in
		private void disableAllplayoffs(boolean color)
		{		// for loop for integer x starting at 0, ending at 9
			for (int x = 0; x < 9; x++)
			{	// for loop for integer x starting at 0, ending at 9
				for (int y = 0; y < 9; y++)
				{ // using a tool button that doesn't allow a mouse click in that area
					button[x][y].setEnabled(false);
				}
			}
			if (color) { //is a color is passed, it calls the method below
				finishedColor();
			}
		}
	private void finishedColor() {
		for (int q = 0; q <= 8; q++)
		{
			colorPlayOff(q, 4);
		}
		
	}
	// non returnable method that opens all playoffs for the user to play in
		private void enableAllplayoffs() {
			// for loop for integer x starting at 0, ending at 9, increasing
			for (int x = 0; x < 9; x++)
			{   // for loop for integer y starting at 0, ending at 9, increasing
				for (int y = 0; y < 9; y++)
				{	//tool uses to enable click action within x and y
					button[x][y].setEnabled(true);
				}
			}
		}
	// method created to change the color of the tic-tac-toe board
		private void colorPlayOff(int playoff, int num)
		{
			if (((num == 4) || (num == 5) || (num == 3)) && (playoffisSolved(playoff)))
				return;
			int[][] pos = scale(playoff);
			for (int i = pos[0][0]; i <= pos[1][0]; i++)
			{
				for (int j = pos[0][1]; j <= pos[1][1]; j++)
				{
					if (num == 0)
						//if the number is equal to zero, use java.awt.color to change to a specific color
					{
						button[i][j].setBackground(new java.awt.Color(185, 220, 120));
					}
					else if (num == 1)
						//if the number is equal to zero, use java.awt.color to change to a specific color
					{
						button[i][j].setBackground(new java.awt.Color(200, 230, 250));
					}
					else if (num == 2)
						//if the number is equal to zero, use java.awt.color to change to a specific color
					{
						button[i][j].setBackground(new java.awt.Color(170, 120, 70));
					}
					else if (num == 3)
						//if the number is equal to zero, use java.awt.color to change to this grey-ish color
					{
						button[i][j].setBackground(new java.awt.Color(230, 230, 230));
						for (int g = 0; g <= 8; g++)
						{	// if integer g does not equal a playoff area to play
							if (g != playoff) {
								// calls the method colorPlayoff, using the g as a variable and 4 as an int value
								colorPlayOff(g, 4);
							}
						}
					} else if (num == 4)
						//if the number is equal to zero, use java.awt.color to this yellowish color
					{
						button[i][j].setBackground(new java.awt.Color(255, 255, 153));
					}
					else if (num == 5)
						//if the number is equal to five, use java.awt.color to change to this greyish color
					{
						button[i][j].setBackground(new java.awt.Color(230, 230, 230));
					}
				}
			}
		}
		
		
		
		
		// prasads code 
		
		
		
		
		public void actionPerformed(java.awt.event.ActionEvent evt) // Provides interfaces and classes for dealing with different types of events fired by AWT components.
		{ //// Contains all of the classes for creating user interfaces and for painting graphics and images.
			for (int i = 0; i < 9; i++) // loop
			{
				for (int j = 0; j< 9; j++) // loop
				{
					int playoff = playoffNumber(i, j); // shows the msg according to the wins/ placements where player can play
					if ((button[i][j] == evt.getSource()) && (!isNear(i, j)))
					{
						if ((unavoidable) && (buttonPressed) && (next != playoff))
						{
							if (player1) {
								JOptionPane.showMessageDialog(this, "It's not your turn , " + Name1 + "!"); // Player is playing on wrong board 
							} else
								JOptionPane.showMessageDialog(this, "It is not your turn , AI"); // AI: you are not in the right board
							return;
						}
						if (!buttonPressed) // dialogs part
							buttonPressed = true;
						if (GameOver(playoff) >= 0) 
						{
							if (player1) // its on the players turns 
							{
								if (GameOver(playoff) == 0) // // makes it easy to pop up a standard dialog box that prompts users
								{
									JOptionPane.showMessageDialog(this, "This playoff is already won by the AI"); // this is where player can not play because its won by AI
								}
								else if (GameOver(playoff) == 1) // on player side
								{
									JOptionPane.showMessageDialog(this, "This playoff is already won by you, " + Name1 + "!"); // this is where player cant play because player has already won on this board
								}


							}
							else if (GameOver(playoff) == 0) // on side of the AI
							{
								JOptionPane.showMessageDialog(this, "This playoff is already won by you, AI!"); // this board the already won by AI. thats why player can not play on this
							}
							else if (GameOver(playoff) == 1) // on player side
							{
								JOptionPane.showMessageDialog(this, "This playoff is already won by " + Name1 + "!"); // this is where player cant play because player has already won on this board 
							}

							return;
						}
						if (player1) // it add colours to the background  of "X"
						{
							button[i][j].setForeground(java.awt.Color.RED); // player plays as red color 
							button[i][j].setText("X"); 
							h += 1;
							input(i, j, 1);
							player1 = false;
							turn.setText("AI's TURN !!"); // done with players ,now its AI's turn
							turn.setForeground(java.awt.Color.RED); // bot dialog box colour
						}
						else // setup the color
						{
							button[i][j].setForeground(java.awt.Color.BLUE); // AI plays in the Colour blue ie "O"
							button[i][j].setText("0");
							this.r += 1;
							input(i, j, 0);
							player1 = true; // now its players turn
							turn.setText(Name1 + "'s TURN !!");
							turn.setForeground(java.awt.Color.RED); // dialog box colour is red
						}
						alternate += 1; // turns and positions alterations
						int[] position = hpm(playoff); // player position
						int r = position[0];int c = position[1]; // // bot position
						if (GameOver(playoff) >= 0) /// add more dialogs // when the board is won by anyone it shows/ pop up this dialog boxes 
						{
							if (GameOver(playoff) == 0) // AI won on this board 
							{
								colorPlayOff(playoff, 0);
								mainInterface[r][c] = 0;
								JOptionPane.showMessageDialog(this, "Bot Wins this playoff\nThis playoff will be counted as \"Bot's\"");
							}
							else if (GameOver(playoff) == 1)  // all the boxes are fill and the game is tied 
							{
								colorPlayOff(playoff, 1);
								mainInterface[r][c] = 1;
								JOptionPane.showMessageDialog(this, Name1 + " Wins this playoff\nThis playoff will be counted as \"" + Name1 + "'s\"");
							}
							if (!gameWork()) {}

						}
						else if (isB_Filled(playoff)) // shows the box is tied 
						{
							colorPlayOff(playoff, 2);
							mainInterface[r][c] = 2;
							JOptionPane.showMessageDialog(this, "This playoff is tied\nThis playoff will be counted for both players");
							if (gameWork())
								return;
							if (GameOver() >= 0) // final part
							{
								if (GameOver() == 0)  // AI wins the game
								{
									JOptionPane.showMessageDialog(this, "Bot wins the game!");
									turn.setText("Bot wins!");
									setVisible(false); // it marks the component visible
								
								}
								else if (GameOver() == 1) // player wins the game
								{
									JOptionPane.showMessageDialog(this, Name1 + " wins the game!");
									turn.setText(Name1 + " wins!");
									setVisible(false);
								
								}
								disableAllplayoffs(true);
								return;
							}
							if (mainInterfaceFull()) // its that the game is tied
							{
								disableAllplayoffs(true);
								turn.setText("Game tied!");
								setVisible(false);
							
							}
						}
						int[] ops = positionInBoard(i, j); // tracks the placements on board 
						int hog  = byteMark(ops[0], ops[1]);
						if (!playoffisSolved(hog))
						{
							next = hog; // Java Scanner class which finds and returns the next complete token
							colorPlayOff(hog, 3);
							unavoidable = true; // forced to use raw types in its method signatures and return types because the methods it overrides from a super type
						}
						else
						{
							unavoidable = false; //// forced to use raw types in its method signatures and will not return types because the methods it overrides from a super type
							for (int g = 0; g <= 8; g++) {
								colorPlayOff(g, 5);
							}
						}
						if (!player1)
						{
							disableAllplayoffs(false);
							java.util.Timer timer = new java.util.Timer(); // threads to schedule tasks for future execution in a background thread
							Beginner.AIWork timer1 = new Beginner.AIWork();
							timer1.take(hog, i, j);
							int wait; // instance method that's used for thread synchronization
							 if (alternate <= 30) { // set up the timer
								wait = 500 + (int)(Math.random() * 1501.0D); } 
							 else { 
								if ( alternate <= 60) {
									wait = 2000 + (int)(Math.random() * 1501.0D);
								} else
									wait = 3000 + (int)(Math.random() * 2001.0D); }
							 timer.schedule(timer1, wait);
						}
						return; // timer end
					}
				}
			}
		}

		private boolean gameWork() // boolean values which returns only true or false
		{
			int result = GameOver(); // end of game
			if (GameOver() >= 0)
			{
				switch (result)// sees who wins and shows the dialogs box accordingly 
				{
				case 0: // shows when AI wins the game
					JOptionPane.showMessageDialog(this, "AI wins the game!");
					turn.setText("AI wins!");
					setVisible(false);
					
				case 1: // shows when player wins the game
					JOptionPane.showMessageDialog(this, Name1 + " wins the game!");
					turn.setText(Name1 + " wins!");
					setVisible(false);
				
				case 2: // game is tied
					JOptionPane.showMessageDialog(this, " The game is tied. ");
					turn.setText("Game is tied!");
					setVisible(false);
					
				}

				disableAllplayoffs(true);
				return true; // end of the end of the game
			}
			if (mainInterfaceFull()) // its  boolean method
			{
				disableAllplayoffs(true);
				turn.setText("Game tied!");
				setVisible(false);
			}
			return false;// end
		}

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