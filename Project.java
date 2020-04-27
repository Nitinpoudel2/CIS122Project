package game;

public class Project {

	
	
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
}