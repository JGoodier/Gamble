package com;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class Gambling {
	
	static double money = 0, bet = 0;
	static Scanner s = new Scanner(System.in);
	static String gameName = null;
	
	public static void loadGame() throws FileNotFoundException {
		File pswrd = new File("./dat/password.dat");
		Scanner sf = new Scanner(pswrd);
		
		String passwordReader = null, passwordInput = null;
		
		passwordReader = sf.next();
		
		print("Welcome to " + gameName, GameType.game);
		print("Please input your password.", GameType.game);
		
		passwordInput = s.next();
		
		if(passwordInput.equals(passwordReader)) {
			print("Input your amount of money.", GameType.admin);
			money = s.nextDouble();
			print("Input the amout of your bet.", GameType.admin);
			bet = s.nextDouble();
			
			startGame();
		} else {
			money = 500.0;
			bet = 25.0;
			print("You have " + money + "." , GameType.cashier);
			print("You have placed " + bet + " amount to bet." , GameType.table);
			sf.close();
			
			startGame();
		}
	}
	
	public static void startGame() throws FileNotFoundException {
		DiceGame.loadDice();
	}
	
	public static void print(String s, GameType t) {
		switch(t) {
		case game:
			System.out.println("Game: " + s);
			return;
		case admin:
			System.out.println("Admin: " + s);
			return;
		case cashier:
			System.out.println("Cashier: " + s);
			return;
		case table:
			System.out.println("Table: " + s);
			return;
		default:
			System.out.println("Default: " + s);
			break;
		}
	}
	
	public static void print(String s) {
			System.out.println("Default: " + s);
	}


}
