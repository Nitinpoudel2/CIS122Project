	/*
	 * 
	 * anubhavs coding 
	 * 
	 */

	//designates the boolean primitive type which are only two possible values TRUE or FALSE only.
	/**
	 * @param r
	 * @param c
	 * @return
	 * we are parameterizing the variable r and c and returning a value in the i
	 * iterating a for loop in the private int bytemark which is called later in the coding for the value 
	 */

	private boolean isNear(int x, int y) {
		//the x and y coordinate of the points of the playoff.
		int playoff = playoffNumber(x, y);
		int[] position = positionInBoard(x, y);
		if (game[playoff][position[0]][position[1]] < 0)
			return false;
		return true;
		//returning true of false
	}

	////designates the boolean primitive type which are only two possible values TRUE or FALSE only.
	private boolean playoffisSolved(int playoff)
	{

		//hpm stores integers.
		int[] position = hpm(playoff);
		//using if statement if it comes less or equals to 0, to get the return value.
		if (mainInterface[position[0]][position[1]] >= 0)
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
			boolean GameOver = true;
			// here we are defining variable as a boolean to later invoke and use it in the coding 
			for (int x = 0; x <= 2; x++)
			{// trying to iteraete the for loop for the game playoff between 2 dimensional array in the coding 
				if (game[playoff][x][x] != player)
					// given if the statement is not satisfied print false
					GameOver = false;
				///conforming the game if it is true or false by the user input
			}
			if (GameOver) {
				// here the if method is iterated and the variable isSolved is called upon
				return player;
				// if this is satisfied then it returns the player in the coding 

			}
			GameOver = true;
			// if satisfied then the variable is true 
			for (int x = 0; x <= 2; x++)
			{
				if (game[playoff][x][(2 - x)] != player)
					GameOver = false;
				//here the game variable is refering it to the arrays int x and given a loop
			}
			if (GameOver) {
				// given the loop the variable player is called 
				return player;
				// variable player is returned 
			}
			for (int x = 0; x <= 2; x++)
			{// for a given loop x is equal to 2 then the given loop iterates
				GameOver = true;
				// if the variable is true then it iterates in the loop 
				//using for loop for the result in the coding if another value then it goes in the loop 
				for (int y = 0; y <= 2; y++)
				{
					if (game[playoff][x][y] != player)
						GameOver = false;
				}
				if (GameOver) {
					return player;
				}
				GameOver = true;
				for (int y = 0; y <= 2; y++)
				{
					if (game[playoff][y][x] != player)
						GameOver = false;
				}
				if (GameOver)
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
	//variables that are visible only to the class to which they belong
	// and these variable only accessible by GameOver 
	{
		int playerReturning = -1;
		// 
		for (int player = 0; player <= 1; player++)
		{
			boolean GameOver = true;
			for (int x = 0; x <= 2; x++)
			{
				if ((mainInterface[x][x] != 2) && (mainInterface[x][x] != player))
					GameOver = false;
			}
			if (GameOver)
			{
				if (playerReturning == 0)
					return 2;
				playerReturning = player;
			}
			else
			{
				GameOver = true;
				for (int x = 0; x <= 2; x++)
				{
					if ((mainInterface[x][(2 - x)] != 2) && (mainInterface[x][(2 - x)] != player))
						GameOver = false;
				}
				if (GameOver)
				{
					if (playerReturning == 0)
						return 2;
					playerReturning = player;
				}
				else
				{
					for (int x = 0; x <= 2; x++)
					{
						GameOver = true;
						for (int y = 0; y <= 2; y++)
						{
							if ((mainInterface[x][y] != 2) && (mainInterface[x][y] != player))
								GameOver = false;
						}
						if (GameOver)
						{
							if (playerReturning == 0)
								return 2;
							playerReturning = player;
							break;
						}

						GameOver = true;
						//// for loop for integer y starting at 0, ending at greater or equals to 2, increasing
						for (int y = 0; y <= 2; y++)
						{
							if ((mainInterface[y][x] != 2) && (mainInterface[y][x] != player))
								GameOver = false;
						}
						if (GameOver)
						{
							if (playerReturning == 0)
								return 2;
							playerReturning = player;
							break;
						}
					}
				} } }
		return playerReturning;
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
