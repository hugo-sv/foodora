package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.util.Scanner;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;

public class Interface {
	/*
	 * This class respect the open-closed principle
	 */
	private static Scanner sc;
	
	

	public Interface(String fileName) throws FileNotFoundException {
		super();
		sc = new Scanner(new FileInputStream(fileName));
	}
	
	public Interface() {
		super();
		sc = new Scanner(System.in);
	}


	public static void main(String[] args) throws FileNotFoundException {



		//Load .ini file
		MyFoodora foodora = new MyFoodora(0, 0, 0);
		FileInputStream initFile = new FileInputStream("foodora.ini");
		Scanner initsc = new Scanner(initFile);
		Interpreter initInterpreter = new Interpreter(initsc , foodora, true);
		while (initInterpreter.executeCommand(initsc.nextLine())){}


		//The interpreter might ask things and need Myfoodora environment
		Interpreter interpreter = new Interpreter(sc,foodora);

		//Open message
		Interpreter.open();

		//Commands are permanently executed
		while (interpreter.executeCommand(sc.nextLine())){}

		//Exit message
		Interpreter.close();
	}


	public String readTextFileLineByLine(String fileName) throws IOException {
		FileReader file = null;
		BufferedReader reader = null;
		try {
			file = new FileReader(fileName);
			reader = new BufferedReader(file);
			while ((reader.readLine()) != null) { // read the file line by line
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
	}
		reader.close();
		file.close();
		return "";
	}
}

