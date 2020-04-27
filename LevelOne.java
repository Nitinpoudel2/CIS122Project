package game;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.EventQueue;

/* Nitin coding
 * main frame of the java coding the tab format and text sizes 
 * 
 */
class Beginner extends javax.swing.JFrame implements java.awt.event.ActionListener 
{

	boolean player1 = true;
	int  s = 0; 
	int t = 0;
	boolean buttonPress = false;
	int next = -1;
	boolean unavoidable = false;
	static String Name1;
	int alternate = 0;

	//creating a frame for the tab of the gaming
	Font f = new java.awt.Font("Arial Black", 3, 25);
	// also assigning a varible font f 
	Font f1 = new java.awt.Font("Arial Black", 3, 16);
	// creating another variable with the coding 
	JTextField turn = new JTextField(19);
	//here the JTextFieldis  lightweight component that allows the editing of a single line of text 
	int[][] MainInterface= new int[3][3];
	// defining a array of two dimension that is it creates 3X3 tab in the coding 
	int[][][] game = new int[9][3][3];
	// another variable assigned for the array we will be needing 3 dimensional array
	JButton[][] button = new JButton[9][9];
	//JButton generally represents a button that, when clicked by the user, carries out a particular action.
	javax.swing.JPanel[][] a = new javax.swing.JPanel[3][3];
	/*
	 *  creating a array pannel to store the coding in the main game memory
	 *
	 *helps in layouts which can store all the components of the coding and gives organized storage of the components
	 */
	javax.swing.JPanel np = new javax.swing.JPanel();

	//creating a private class of the game which is only accessible by the members 
	private Beginner() {
		//creating a class in the coding 
		super(Name1 + "vs AI");
		// the main interface of the coding game 
		setLayout(new java.awt.FlowLayout());
		/*here the setLayout is used to set the layout of the container in the coding which often 
		* often JPanel, FlowLayout, BorderLayout, GridLayout, null layout, or whatever layout desired
		*
		*/
		np.setLayout(new java.awt.GridLayout(3, 3));
		// here the coding gridlayout actually arranges the components in the rectangular grid where they are displayed in rectangle
		for ( int i= 0 ; i <= 2; i++)
		{// here we are using a for loop in the coding to align the tabs int he coding 
			for(int j=0; j <= 2; j++)
			{
				a[i][j] = new javax.swing.JPanel();
				//assigning variable for the Jpanel in the javax swing JPanel
				// assigning array list in the coding for the 
				a[i][j].setLayout(new java.awt.GridLayout(3, 3));
				// here it sets up the layout as the 3X3 format of the coding 
				np.add(a[i][j]);
				// we are assigning a new variable and again assigning it to another variable to make a call in the coding later 
				a[i][j].setBorder(new javax.swing.border.LineBorder(java.awt.Color.YELLOW, 3, true));
				// here we set the layout of bars and border of the java game
				
			}
		}
		for( int i = 0; i < 9; i++ )
			// here we are using another for loop inside of the for loop to set the 
		{
			for(int j = 0; j < 9;j++ )
			{
				button[i][j] = new JButton();
				// assigning variable for the array list that is 2 dimensional in the coding game 
				button[i][j].setFont(f);
				// here we are calling the variable f font 
				button[i][j].setText(" ");
				// here we are adding two buttons in the loop and diving it into 3 types
				a[(i / 3)][(j /3)].add(button[i][j]);
				button[i][j].addActionListener(this);
				//here add ActionListener takes the current class object as a parameter and this" key word simply means "this object I'm working in right now"
				button[i][j].setBackground(new java.awt.Color(255, 255, 153));
				// now we are setting the background of the two dimensional array in the background 
			}
		}
		initialise();
		/* initializing the code here by defining all the border font , 
		*fore background and everything that we will be using  
		**/
		turn.setBorder(new javax.swing.border.LineBorder(java.awt.Color.GREEN, 2, true));
		// we set the JTextField variable as turn in the 
		turn.setFont(f);;
		// here we are calling the turn variable java TextField and using the method setFont to call variable f in the turn 
		turn.setBackground(new java.awt.Color(255,255,153));
		// here rwe are setting the background color of the java game 
		turn.setForeground(java.awt.Color.BLUE);
		// here we are setting the foreground as blue which shows the color of the gamers in the code
		turn.setHorizontalAlignment(0);
		turn.setText(Name1 + " turn");
		// here we are making this thing pop up in the tab by putting the user input name and turn in the game
		turn.setEditable(false);
		//indicate whether or not this TextComponent should be editable and the property change could be done in the game.
		add(turn);
		// now here we are adding and calling the turn varibale which stores the data in the gaming
		add(np);
		//adding this in the gming code and calling it with array
		np.setVisible(true);
		//this method makes the method visible and is able to access later in the game to override 
		//end of nitins part.............
	}

}
