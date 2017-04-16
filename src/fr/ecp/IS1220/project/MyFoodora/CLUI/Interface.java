package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.util.Scanner;

public class Interface {
	/*
	 * This class respect the open-closed principle
	 */
	private static Scanner sc;

	public static void main(String[] args) {
		//The interpreter might ask things
		Interpreter interpreter = new Interpreter(sc);
		
		//Open message
		interpreter.open();
		
		sc = new Scanner(System.in);
		//Commands are permanently executed
		while (interpreter.executeCommand(sc.nextLine())){}
		
		//Exit message
		interpreter.close();
	}
}
