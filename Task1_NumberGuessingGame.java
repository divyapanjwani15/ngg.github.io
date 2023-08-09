package com.company;

import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener{
	Container c;
	JLabel label1;
	JLabel enterNumber;
	JTextField input;
	JButton btn;
	int randomNo;
	int attempsLeft;
	int noOfGuesses = 0;
	
	public MyFrame(){
		window();
		generateNumber();
	}
	
	public void window() {
		c = this.getContentPane();
		c.setLayout(null);
		
		Font f1 = new Font("Times New Roman", Font.BOLD, 25);
		
		label1 = new JLabel("You've got 5 attempts to guess the correct number!");
		label1.setBounds(20,50,600,30);
		label1.setFont(f1);
		c.add(label1);
		
		enterNumber = new JLabel("Enter the number between 1 to 100");
		enterNumber.setBounds(100,100,500,30);
		enterNumber.setFont(f1);
		c.add(enterNumber);
		
		
		input = new JTextField();
		input.setBounds(210, 150, 150, 30);
		input.setHorizontalAlignment(JTextField.CENTER);
		Font f2 = new Font("Arial", Font.PLAIN, 20);
		input.setFont(f2);
		c.add(input);
		
		btn = new JButton("Guess");
		btn.setBounds(232, 200, 100, 30);
		Font f3 = new Font("Arial", Font.BOLD, 20);
		btn.setFont(f3);
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		btn.setCursor(cursor);
		btn.setBackground(Color.LIGHT_GRAY);
		btn.addActionListener(this);
		c.add(btn);
	}
	public void actionPerformed(ActionEvent e) {
		JFrame f = new JFrame();
		f.setBounds(100,200,600,300);
		try {
			int userNo = Integer.parseInt(input.getText());
			if(userNo >=1 && userNo <= 100) {
				isCorrectNumber(userNo);
			}
		}
		catch(NumberFormatException ex) {
			System.out.println("Please enter a valid number");
		}
	}
	public void generateNumber() {
		Random r = new Random();
		randomNo = r.nextInt(100);
		attempsLeft = 5;
	}
	public int getNoOfGuesses() {
		return noOfGuesses;
	}
	public void setNoOfGuesses(int noOfGuesses) {
		this.noOfGuesses = noOfGuesses;
	}
	public void isCorrectNumber(int userNo) {
		attempsLeft--;
		noOfGuesses++;
		if(userNo == randomNo) {
			System.out.println("Congratulations! You guessed it right");
			System.out.println("You guessed it in " + noOfGuesses + " attempts");
//			resetGame();
		}
		else if(attempsLeft == 0) {
			System.out.println("Sorry you've run out of attemps. The correct answer was " + randomNo);
			resetGame();
		}
		else if(userNo < randomNo) {
			System.out.println("Too low! Try again");
			System.out.println("Attemps left : " + attempsLeft);
			reset();
			
		}
		else if(userNo > randomNo) {
			System.out.println("Too high! Try again");
			System.out.println("Attemps left : " + attempsLeft);
			reset();
		}
		
	}
	public void resetGame() {
		generateNumber();
		attempsLeft = 5;
		noOfGuesses = 0;
		input.setText("");
	}
	public void reset() {
		input.setText("");
	}
}

public class Task1_NumberGuessingGame {
	public static void main(String[] args) {
		
		MyFrame frame = new  MyFrame();
		frame.setBounds(100,200,600,300);
		frame.setTitle("Guess the Number Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
