package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.util.Scanner;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.User;

public class Interpreter {
	/*
	 * This class interpret Interface commands
	 */
	private Scanner sc;
	private User user;
	private MyFoodora foodora;

	public Interpreter(Scanner sc, MyFoodora foodora) {
		super();
		this.sc = sc;
		this.user = null;
		this.foodora = foodora;
	}

	static void open() {
		// Generic message
		System.out.println("Hello, welcome on MyFoodora.\n");
		System.out.println("To login, type login <username> <password>");
		System.out.println("To suscribe, type suscribe");
		System.out.println("For any help, type help.");
	}

	static void close() {
		// Generic message
		System.out.println("GoodBye !");
	}

	static void incorrect() {
		// Generic message
		System.out.println("Incorrect input, please try again.");
	}

	static void forbidden() {
		// Generic message
		System.out.println("You are not allowed to execute this command");
	}

	static void unknown() {
		// Generic message
		System.out.println("Unknow command, use the help command.");
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
			Interpreter.incorrect();
			answer = sc.nextLine();
		}
	}

	private boolean canUse(String command) {
		// Check if the User can execute the command. If not, return a message
		// Easier to complete if a user is added

		return false;
	}

	private void showCourierDeliveries() {
		// TODO Auto-generated method stub

	}

	private void showRestaurantTop() {
		// TODO Auto-generated method stub

	}

	private void showCustomers() {
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

	private void login(String[] arguments) {
		// TODO Auto-generated method stub

	}

	private void showTotalProfit(String[] arguments) {
		/*
		 * try { (Manager)user.computeProfit(null, null);
		 * 
		 * } catch (IOException e) {// Erreur parceque user n'est pas un manager
		 * System.out.println("You can't do that."); }
		 */

	}

	private void help() {
		// Depending on the user, Help propose differents commands
		if (user == null) {
			System.out.println("login <username> <password> : to login");
			System.out.println("quit <> : to quit");
			System.out.println("suscribe <> : to suscribe");
			System.out.println("help <> : For help");
		}
		if (false) {
			// Si l'utilisateur est manager...
		}
	}

	private boolean quit() {
		// To quit the interface
		System.out.println("Are you sure you want to quit ? [yes]/no]");
		String answer = this.askFor(new String[] { "yes", "no", "" });
		if (answer == "no") {
			return true;
		}
		return false;

	}

	private void suscribe() {
		// To suscribe to MyFoodora
		System.out.println("Interpreter.suscribe()");
	}

	public boolean executeCommand(String command) {
		// Execute the given command
		// Split the arguments
		String[] arguments = command.split(" ");
		switch (arguments[0]) {
		case "login":
			this.login(arguments);
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
			this.showCourierDeliveries();
			break;
		case "showRestaurantTop":
			this.showRestaurantTop();
			break;
		case "showCustomers":
			this.showCustomers();
			break;
		case "showMenuItem":
			this.showMeal(arguments);
			break;
		case "showTotalProfit":
			this.showTotalProfit(arguments);
			break;
		case "runTest":
			this.offDuty(arguments);
			break;
		case "help":
			this.help();
			break;
		case "suscribe":
			this.suscribe();
			break;
		case "quit":
			return this.quit();
		default:
			Interpreter.unknown();
		}
		System.out.println("");
		return true;
	}

}