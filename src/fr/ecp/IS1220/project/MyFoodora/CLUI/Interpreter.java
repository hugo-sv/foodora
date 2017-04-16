package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.util.ArrayList;
import java.util.Scanner;

import fr.ecp.IS1220.project.MyFoodora.core.User;

public class Interpreter {
	private Scanner sc;
	private User user = null;

	public Interpreter(Scanner sc) {
		super();
		this.sc = sc;
	}

	public void open() {
		System.out.println("Hello, welcome on MyFoodora.\n");
		System.out.println("To connect, type connect <username> <password>");
		System.out.println("To suscribe, type suscribe");
		System.out.println("For any help, type help.");
	}

	public void close() {
		System.out.println("GoodBye !");
	}

	private void help() {
		System.out.println("Interpreter.help()");
	}

	public boolean executeCommand(String command) {

		// split command for each space ########################
		String action = command;
		ArrayList<String> arguments = null;
		switch (action) {
		case "help":
			this.help();
			break;
		case "suscribe":
			this.suscribe();
			break;
		case "connect":
			this.connect(arguments);
			break;
		case "quit":
			return this.quit();
		case "showTotalProfit":
			// un exemple de fonction pas autorisée à tous
			this.showTotalProfit();
			break;
		default:
			System.out.println("Unknow command, use the help command.");
		}
		System.out.println("");
		return true;
	}

	private void showTotalProfit() {
		//J'arrive pas a faire ce que je veux, need help :p  #############
		try{
			((Manager) user).computeProfit(null, null);
		}
		catch{//Erreur parceuqe user n'est pas un manager ###################
		System.out.println("You can't do that.");	
		}
		

	}

	private void connect(ArrayList<String> arguments) {
		// TODO Auto-generated method stub
		// change user
	}

	private boolean quit() {
		System.out.println("Are you sure you want to quit ? [yes]/no]");
		// Comment on instancie directement un tableau ? ##################
		String answer = this.askFor(new ArrayList<String>("yes", "no", ""));
		if (answer == "no") {
			return true;
		}
		return false;

	}

	private void suscribe() {
		System.out.println("Interpreter.suscribe()");
		// TODO Auto-generated method stub

	}

	private String askFor(ArrayList<String> asked) {
		// Ask to the user for one of the proposed arguments
		String answer = sc.nextLine();
		while (true) {
			if (asked.contains(answer)) {
				return answer;
			}
			System.out.println("Incorrect input, please try again.");
		}
	}
}
