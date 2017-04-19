package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import fr.ecp.IS1220.project.MyFoodora.core.Manager;
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
		// Split the arguments
		String[] arguments = command.split(" ");
		switch (arguments[0]) {
		case "help":
			this.help();
			break;
		case "logout":
			this.logout(arguments);
			break;
		case "registerRestaurant":
			this.registerRestaurant(arguments);
			break;
		case "registerCustomer":
			this.registerCourier(arguments);
			break;
		case "registerCourier":
			this.registerCourier(arguments);
			break;
		case "addDishRestauarantMenu":
			this.addDishRestauarantMenu(arguments);
			break;
		case "createMeal":
			this.createMeal(arguments);
			break;
		case "addDish2Meal":
			this.addDish2Meal(arguments);
			break;
		case "showMeal":
			this.showMeal(arguments);
			break;
		case "saveMeal":
			this.createMeal(arguments);
			break;
		case "setSpecialOffer":
			this.setSpecialOffer(arguments);
			break;
		case "removeFromSpecialOffer":
			this.removeFromSpecialOffer(arguments);
			break;
		case "createOrder":
			this.createOrder(arguments);
			break;
		case "addItem2Order":
			this.addItem2Order(arguments);
			break;
		case "endOrder":
			this.endOrder(arguments);
			break;
		case "onDuty":
			this.onDuty(arguments);
			break;
		case "offDuty":
			this.offDuty(arguments);
			break;
		case "findDeliverer":
			this.findDeliverer(arguments);
			break;
		case "setDeliveryPolicy":
			this.logout(arguments);
			break;
		case "setProfitPolicy":
			this.setProfitPolicy(arguments);
			break;
		case "associateCard":
			this.associateCard(arguments);
			break;
		case "showCourierDeliveries":
			this.showCourierDeliveries(arguments);
			break;
		case "showRestaurantTop":
			this.showRestaurantTop(arguments);
			break;
		case "showCustomers":
			this.showCustomers(arguments);
			break;
		case "showMenuItem":
			this.showMeal(arguments);
			break;
		case "showTotalProfit":
			this.showTotalProfit();
			break;
		case "runTest":
			this.offDuty(arguments);
			break;
		case "suscribe":
			this.suscribe();
			break;
		case "connect":
			this.connect(arguments);
			break;
		case "quit":
			return this.quit();
		default:
			System.out.println("Unknow command, use the help command.");
		}
		System.out.println("");
		return true;
	}

	private void showCourierDeliveries(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void showRestaurantTop(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void showCustomers(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void associateCard(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void setProfitPolicy(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void findDeliverer(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void offDuty(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void endOrder(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void onDuty(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void addItem2Order(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void createOrder(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void removeFromSpecialOffer(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void setSpecialOffer(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void showMeal(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void addDish2Meal(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void createMeal(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void registerRestaurant(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void addDishRestauarantMenu(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void registerCourier(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void logout(String[] arguments) {
		// TODO Auto-generated method stub
		
	}

	private void showTotalProfit() {
		/*
		 * try { (Manager)user.computeProfit(null, null);
		 * 
		 * } catch (IOException e) {// Erreur parceque user n'est pas un manager
		 * System.out.println("You can't do that."); }
		 */

	}

	private void connect(String[] arguments) {
		// TODO Auto-generated method stub
		// change user
	}

	private boolean quit() {
		System.out.println("Are you sure you want to quit ? [yes]/no]");
		String answer = this.askFor(new String[] { "yes", "no", "" });
		if (answer == "no") {
			return true;
		}
		return false;

	}

	private void suscribe() {
		System.out.println("Interpreter.suscribe()");
		// TODO Auto-generated method stub

	}

	private String askFor(String[] expected) {
		// Ask to the user for one of the proposed arguments
		String answer = sc.nextLine();
		while (true) {
			for (int i = 0; i < expected.length; i++) {
				if (expected[i].equals(answer)) {
					return answer;
				}
			}
			System.out.println("Incorrect input, please try again.");
			answer = sc.nextLine();
		}
	}
}