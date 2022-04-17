


// Importing the java.awt package for things like graphics. This imports the whole package not sub-packages.
import java.awt.*;
// Importing the java.awt.event. this is we can have an event listener, this registers with an event source to receive notifications about the events of a particular type.
import java.awt.event.*;
// Importing all the classes of the utility package in the program.
import java.util.*;
// Imports packages so that can allow us to build a GUI. 
import javax.swing.*;

// This is a public class which can be accessed by other classes. This will contain buttons frame design, notifications etc. 
public class toeTacTic implements ActionListener {
	
	// Creating instances of our classes from which we imported.
	int xScore = 0;
	char oScore = 0; 
	Random randomizer = new Random();
	JFrame gameFrame = new JFrame();
	JPanel titleFrame = new JPanel();
	JPanel buttonFrame = new JPanel();
	JLabel textContainer = new JLabel();
	JButton[] allButtons = new JButton[9];
	JButton rsetButton = new JButton("Reset");
	JLabel scoreBoard = new JLabel();
	boolean isItPlayerOneTurn;
	boolean winWin = false; 
	// Constructor method, this will be called when we create a new instance of toeTacTic.
	toeTacTic(){
		
		// Using our gameFrame object to exit the game upon close. 
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Setting frame size to 900*900.
		gameFrame.setSize(1000,1000);
		// Setting background color to grey. 
		gameFrame.getContentPane().setBackground(new Color(220,220,220));
		// Setting the layout of the container. 
		gameFrame.setLayout(new BorderLayout());
		// Setting so frame can be visible on screen.
		gameFrame.setVisible(true);
		
		// Setting text container background color.
		textContainer.setBackground(new Color(169,169,169));
		// Setting text container foreground color.
		textContainer.setForeground(new Color(0,0,0));
		// Setting the text container to a font that I want.
		textContainer.setFont(new Font("Franchise",Font.BOLD,80));
		// Setting the alignment to the center. 
		textContainer.setHorizontalAlignment(JLabel.CENTER);
		// Setting the title text to Toe-Tac-Tic.
		textContainer.setText("Toe-Tac-Tic");
		// Setting it so it is not transparent. 
		textContainer.setOpaque(true);
		
		scoreBoard.setBackground(new Color(169,169,169));
		// Setting text container foreground color.
		scoreBoard.setForeground(new Color(0,0,0));
		// Setting the text container to a font that I want.
		scoreBoard.setFont(new Font("Franchise",Font.BOLD,80));
		// Setting the alignment to the center. 
		scoreBoard.setHorizontalAlignment(JLabel.CENTER);
		// Setting the title text to Toe-Tac-Tic.
		scoreBoard.setText("SCORE BOARD");
		// Setting it so it is not transparent. 
		scoreBoard.setOpaque(true);
		
		titleFrame.add(scoreBoard, BorderLayout.SOUTH);
		
		// Setting the layout for title frame. 
		titleFrame.setLayout(new BorderLayout());
		// Setting position and size of the component manually.
		titleFrame.setBounds(0,0,800,100);
		// Setting layout for button frame object.
		buttonFrame.setLayout(new GridLayout(3,3));
		// Setting background color for button frame. 
		buttonFrame.setBackground(new Color(255,255,255));
		
		rsetButton.setBackground(new Color(169,169,169));
		
		rsetButton.setPreferredSize(new Dimension(-1,40));
		
		rsetButton.setFont(new Font("Franchise", Font.BOLD,30));
		
		gameFrame.add(rsetButton, BorderLayout.SOUTH);
		
		rsetButton.addActionListener(this);
		
		// This is a for loop, this for loop takes the array allButtons and variable x and creates a new JButton until it reaches 9. 
		// It also adds allButtons to the buttonFrame sets focusable to false.
		// Then takes actionlistener (this) meaning the object you are working in currently right now.  
		
		
		for(int a=0;a<9;a++) {
			
			allButtons[a] = new JButton();
			buttonFrame.add(allButtons[a]);
			allButtons[a].setFont(new Font("Franchise", Font.BOLD,130));
			allButtons[a].setFocusable(false);
			allButtons[a].addActionListener(this);
			allButtons[a].setBackground(Color.black);
			allButtons[a].setForeground(Color.black);
			
		}
		
		titleFrame.add(textContainer);
		gameFrame.add(titleFrame,BorderLayout.NORTH);
		gameFrame.add(buttonFrame);
		
		
		turnNumone();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int a=0; a<9; a++) {
			if (e.getSource()==allButtons[a]) {
				if(isItPlayerOneTurn) {
					if(allButtons[a].getText()=="") {
						allButtons[a].setForeground(new Color(105,105,105));
						allButtons[a].setText("X");
						isItPlayerOneTurn = false;
						textContainer.setText("O turn");
						checkWin();
						
					}
				}else {
					if(allButtons[a].getText()=="") {
						allButtons[a].setForeground(new Color(255,255,255));
						allButtons[a].setText("O");
						isItPlayerOneTurn = true;
						textContainer.setText("X turn");
						checkWin();
					}
				}
				
			}
			
		}
		
		if(e.getSource()==rsetButton) {
			
			gameFrame.dispose();
			new toeTacTic();
			
		}
	}
	
	
	public void turnNumone() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if(randomizer.nextInt(2) == 0) {
			isItPlayerOneTurn = true;
			textContainer.setText("X goes first");		
		}
		else {
			isItPlayerOneTurn = false;
			textContainer.setText("O goes first");
		}
		
	}
	
	public void checkWin() {
		
		if(
				(allButtons[0].getText()=="X") &&
				(allButtons[1].getText()=="X") &&
				(allButtons[2].getText()=="X")
				) {
			winnerX(0,1,2);
		}
		else if(
				(allButtons[3].getText()=="X") &&
				(allButtons[4].getText()=="X") &&
				(allButtons[5].getText()=="X")
				) {
			winnerX(3,4,5);
		}
		else if(
				(allButtons[6].getText()=="X") &&
				(allButtons[7].getText()=="X") &&
				(allButtons[8].getText()=="X")
				) {
			winnerX(6,7,8);
		}
		else if(
				(allButtons[0].getText()=="X") &&
				(allButtons[3].getText()=="X") &&
				(allButtons[6].getText()=="X")
				) {
			winnerX(0,3,6);
		}
		else if(
				(allButtons[1].getText()=="X") &&
				(allButtons[4].getText()=="X") &&
				(allButtons[7].getText()=="X")
				) {
			winnerX(1,4,7);
		}
		else if(
				(allButtons[2].getText()=="X") &&
				(allButtons[5].getText()=="X") &&
				(allButtons[8].getText()=="X")
				) {
			winnerX(2,5,8);
		}
		else if(
				(allButtons[0].getText()=="X") &&
				(allButtons[4].getText()=="X") &&
				(allButtons[8].getText()=="X")
				) {
			winnerX(0,4,8);
		}
		else if(
				(allButtons[2].getText()=="X") &&
				(allButtons[4].getText()=="X") &&
				(allButtons[6].getText()=="X")
				) {
			winnerX(2,4,6);
		}
		//check O win conditions
		else if(
				(allButtons[0].getText()=="O") &&
				(allButtons[1].getText()=="O") &&
				(allButtons[2].getText()=="O")
				) {
			winnerO(0,1,2);
		}
		else if(
				(allButtons[3].getText()=="O") &&
				(allButtons[4].getText()=="O") &&
				(allButtons[5].getText()=="O")
				) {
			winnerO(3,4,5);
		}
		else if(
				(allButtons[6].getText()=="O") &&
				(allButtons[7].getText()=="O") &&
				(allButtons[8].getText()=="O")
				) {
			winnerO(6,7,8);
		}
		else if(
				(allButtons[0].getText()=="O") &&
				(allButtons[3].getText()=="O") &&
				(allButtons[6].getText()=="O")
				) {
			winnerO(0,3,6);
		}
		else if(
				(allButtons[1].getText()=="O") &&
				(allButtons[4].getText()=="O") &&
				(allButtons[7].getText()=="O")
				) {
			winnerO(1,4,7);
		}
		else if(
				(allButtons[2].getText()=="O") &&
				(allButtons[5].getText()=="O") &&
				(allButtons[8].getText()=="O")
				) {
			winnerO(2,5,8);
		}
		else if(
				(allButtons[0].getText()=="O") &&
				(allButtons[4].getText()=="O") &&
				(allButtons[8].getText()=="O")
				) {
			winnerO(0,4,8);
		}
		else if(
				(allButtons[2].getText()=="O") &&
				(allButtons[4].getText()=="O") &&
				(allButtons[6].getText()=="O")
				) {
			winnerO(2,4,6);
			

	        }
		
		int a = 0;
        while (allButtons[a].getText() != "") {
            if (a == allButtons.length -1) {
                drawGame();
            }
            a++;
        }
        
		}
		
	
	public void winnerX(int w, int x, int z) {
		allButtons[w].setBackground(Color.GREEN);
		allButtons[x].setBackground(Color.GREEN);
		allButtons[z].setBackground(Color.GREEN);
		
		for(int a=0;a<9;a++) {
			allButtons[a].setEnabled(false);
		}
		winWin = true;
		textContainer.setText("X has prevailed");
				
	}
	
	public void winnerO(int w, int x, int z) {
		allButtons[w].setBackground(Color.GREEN);
		allButtons[x].setBackground(Color.GREEN);
		allButtons[z].setBackground(Color.GREEN);
		
		for(int a=0;a<9;a++) {
			allButtons[a].setEnabled(false);
		}
		winWin = true; 
		textContainer.setText("O has prevailed");
	}
	
	public void drawGame() {
        for (int a = 0; a < allButtons.length; a++) {
            allButtons[a].setEnabled(false);
            allButtons[a].setBackground(Color.RED);
        }
        textContainer.setText("DRAW!");
    }
	
}


