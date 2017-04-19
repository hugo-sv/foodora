package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.util.Scanner;

import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;

public class Interface {
	/*
	 * This class respect the open-closed principle
	 */
	private static Scanner sc;

	public static void main(String[] args) {
		
		//Load .ini file
		MyFoodora foodora = new MyFoodora(0, 0, 0);
		
		
		sc = new Scanner(System.in);
		//The interpreter might ask things and need Myfoodora environment
		Interpreter interpreter = new Interpreter(sc,foodora);
		
		//Open message
		Interpreter.open();
		
		//Commands are permanently executed
		while (interpreter.executeCommand(sc.nextLine())){}
		
		//Exit message
		Interpreter.close();
	}
}
