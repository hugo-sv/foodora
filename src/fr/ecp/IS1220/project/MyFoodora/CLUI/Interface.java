package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;

public class Interface {
	/*
	 * This class respect the open-closed principle
	 */
	private static Scanner sc = new Scanner(System.in);


	public static void main(String[] args) {
		//Load .ini file
		MyFoodora foodora = new MyFoodora(1, 0.2, 2);
		try {
			FileInputStream initFile = new FileInputStream("eval/my_foodora.ini");
			Scanner initsc = new Scanner(initFile);
			Interpreter initInterpreter = new Interpreter(initsc , foodora, true, false);
			while (initInterpreter.executeCommand(initsc.nextLine())){}
		} catch (FileNotFoundException e) {
			System.out.println("Init file not found, system not initialized");
		}


		//The interpreter might ask things and need Myfoodora environment
		Interpreter interpreter = new Interpreter(sc,foodora);

		//Open message
		interpreter.open();

		//Commands are permanently executed
		while (interpreter.executeCommand(sc.nextLine())){}

		//Exit message
		interpreter.close();
	}
}

