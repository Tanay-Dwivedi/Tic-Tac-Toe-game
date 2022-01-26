import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
	
	Random random = new Random();
	JFrame jframe = new JFrame();
	JPanel titlePanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton buttons[] = new JButton[9];
	boolean ply1Turn;
	boolean ply2Turn;
	
	TicTacToe() {
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.setSize(800,800);
		jframe.getContentPane().setBackground(new Color(50,50,50));
		jframe.setLayout(new BorderLayout());
		jframe.setVisible(true);
		
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Mochiy Pop P One", Font.BOLD,80));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("TIC-TAC-TOE");
		textField.setOpaque(true);
		
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBounds(0,0,800,100);
		
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i=0; i<9; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Rubik Beastly", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		titlePanel.add(textField);
		jframe.add(titlePanel, BorderLayout.NORTH);
		jframe.add(buttonPanel);
		
		firstTurn();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0; i<9; i++) {
			if(e.getSource()==buttons[i]) {
				if(ply1Turn) {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(255,0,0));
						buttons[i].setText("X");
						ply1Turn = false;
						textField.setText("Player 2 (O's) turn");
						check();
					}
				}
				else {
					if(buttons[i].getText()=="") {
						buttons[i].setForeground(new Color(0,0,255));
						buttons[i].setText("O");
						ply1Turn = true;
						textField.setText("Player 1 (X's) turn");
						check();
					}
				}
			}
		}
		
	}
	
	// A method to check whose turn will be first.
	public void firstTurn () {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(random.nextInt(2) == 0) {
			ply1Turn = true;
			textField.setText("Player 1 (X's) turn");
		}
		else {
			ply1Turn = false;
			textField.setText("Player 2 (O's) turn");
		}
		
	}
	
	// A method to check if a player has won.
	public void check() {
		
		// Checking X win condition
		if(     (buttons[0].getText() == "X") && 
				(buttons[1].getText() == "X") && 
				(buttons[2].getText() == "X")
				) {
			xWins(0,1,2);
		}
		if(     (buttons[3].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[5].getText() == "X")
				) {
			xWins(3,4,5);
		}
		if(     (buttons[6].getText() == "X") && 
				(buttons[7].getText() == "X") && 
				(buttons[8].getText() == "X")
				) {
			xWins(6,7,8);
		}
		if(     (buttons[0].getText() == "X") && 
				(buttons[3].getText() == "X") && 
				(buttons[6].getText() == "X")
				) {
			xWins(0,3,6);
		}
		if(     (buttons[1].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[7].getText() == "X")
				) {
			xWins(1,4,7);
		}
		if(     (buttons[2].getText() == "X") && 
				(buttons[5].getText() == "X") && 
				(buttons[8].getText() == "X")
				) {
			xWins(2,5,8);
		}
		if(     (buttons[0].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[8].getText() == "X")
				) {
			xWins(0,4,8);
		}
		if(     (buttons[2].getText() == "X") && 
				(buttons[4].getText() == "X") && 
				(buttons[6].getText() == "X")
				) {
			xWins(2,4,6);
		}
		
		//checking O win condition
		if(     (buttons[0].getText() == "O") && 
				(buttons[1].getText() == "O") && 
				(buttons[2].getText() == "O")
				) {
			oWins(0,1,2);
		}
		if(     (buttons[3].getText() == "O") && 
				(buttons[4].getText() == "O") && 
				(buttons[5].getText() == "O")
				) {
			oWins(3,4,5);
		}
		if(     (buttons[6].getText() == "O") && 
				(buttons[7].getText() == "O") && 
				(buttons[8].getText() == "O")
				) {
			oWins(6,7,8);
		}
		if(     (buttons[0].getText() == "O") && 
				(buttons[3].getText() == "O") && 
				(buttons[6].getText() == "O")
				) {
			oWins(0,3,6);
		}
		if(     (buttons[1].getText() == "O") && 
				(buttons[4].getText() == "O") && 
				(buttons[7].getText() == "O")
				) {
			oWins(1,4,7);
		}
		if(     (buttons[2].getText() == "O") && 
				(buttons[5].getText() == "O") && 
				(buttons[8].getText() == "O")
				) {
			oWins(2,5,8);
		}
		if(     (buttons[0].getText() == "O") && 
				(buttons[4].getText() == "O") && 
				(buttons[8].getText() == "O")
				) {
			oWins(0,4,8);
		}
		if(     (buttons[2].getText() == "O") && 
				(buttons[4].getText() == "O") && 
				(buttons[6].getText() == "O")
				) {
			oWins(2,4,6);
		}
		
	}
	
	// A method to check if X wins
	public void xWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		// Disabling the buttons
		for (int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("Player 1 wins");
		
	}
	
	// A method to check if O wins
	public void oWins(int a, int b, int c) {
		
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		
		// Disabling the buttons
		for (int i=0; i<9; i++) {
			buttons[i].setEnabled(false);
		}
		textField.setText("Player 2 wins");
		
	}
}