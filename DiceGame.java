package com;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DiceGame extends Gambling {
	
	static Scanner input = new Scanner(System.in);
	static int diceNum, win, loss;
	
	public static void preGame() throws FileNotFoundException {
		
		gameName = "The Dice Game";
		loadGame();
	}
	
	public static void loadDice() {
		String ans = null;
		
		print("Would you like to play " + gameName + "?", GameType.game);
		ans = input.next();
		
		if(ans.toLowerCase().equals("yes")) {
			rollDice();
		} else {
			print("Thank you for playing.", GameType.game);
		}
	}
	
	public static void rollDice() {
		diceNum = (int) (Math.random() * 100) + 1;
		 
		print("You rolled a " + diceNum, GameType.table);
		
		if(diceNum < 55) {
			print("You lose..", GameType.game);
			loss++;
			money = money - bet;
			reRoll();
		}
		if(diceNum > 55) {
			print("You win..", GameType.game);
			
			if(diceNum == 55) {
				print("You get x3 your bet for rolling a " + diceNum, GameType.cashier);				
				money = money + (bet * 3);
			} else {
				money = money + (bet * 2);
			}
			win++;
			reRoll();
		}
	}
	
	public static void reRoll() {
		String ans = null;
		print("You have " + money + ".", GameType.cashier);
		print("Would you like to play again?", GameType.table);
		ans = input.next();
		
		if(ans.toLowerCase().equals("yes") || ans.toLowerCase().equals("y")) {
			rollDice();
		} else {
			close();
		}
		
	}
	
	public static void close() {
		print("You won " + win + " times and Loss " + loss + " times.", GameType.game);
		input.close();
	}

}
