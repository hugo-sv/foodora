package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.Scanner;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;
import fr.ecp.IS1220.project.MyFoodora.core.menu.FullMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Starter;

public class UseCase {
	// Use Case scenario
	public static void main(String[] args) {
		// The following use case scenario describe examples of how the
		// MyFoodora should function.
		// Startup scenario
		// 1. the system loads all registered users: at least 2 manager (the CEO
		// and his deputy
		// i.e. ajoint), 5 restaurants and 2 couriers, 7 customers, 4 full-meals
		// per restaurant...
		MyFoodora foodora = new MyFoodora(0.5, 0.05, 1);
		Manager CEO = new Manager("Mary", "mary", "boss47");
		foodora.addUser(CEO);

		Manager Deputy = new Manager("John", "john", "jojojo");
		foodora.addUser(Deputy);

		Restaurant Macdo = new Restaurant("MacDonald", "macdonald", 15, -20);
		foodora.addUser(Macdo);

		MainDish Drink = new MainDish("Drink", 0.5, true, true);
		MainDish BigMac = new MainDish("BigMac", 5, false, false);
		Starter Salad = new Starter("Salad", 1, true, true);
		Dessert MacFlurry = new Dessert("McFlurry", 2, true, false);

		FullMeal F1 = new FullMeal("F1", Salad, BigMac, MacFlurry);
		HalfMeal F2 = new HalfMeal("F2", Salad, Drink);

		Macdo.addMeal(F1);
		Macdo.addMeal(F2);

		Restaurant Quick = new Restaurant("Quick", "quick", 105, 74);
		foodora.addUser(Quick);
		FullMeal F3 = new FullMeal("F3", Salad, new MainDish("Nuggets", 4, false, true),
				new Dessert("Donut", 2, true, false));
		HalfMeal F4 = new HalfMeal("F4", new MainDish("Nuggets", 4, false, true), new Dessert("Donut", 2, true, false));
		Quick.addMeal(F3);
		Quick.addMeal(F4);

		Restaurant Sushi = new Restaurant("SushiWorld", "sushi", 5, -50);
		foodora.addUser(Sushi);
		FullMeal F5 = new FullMeal("F5", new Starter("Sushi2", 4, false, true), new MainDish("Sushi1", 4, false, true),
				new Dessert("Dessert", 2, true, false));
		HalfMeal F6 = new HalfMeal("F6", new MainDish("Sushi3", 4, false, true),
				new Dessert("Dessert2", 2, true, false));
		Sushi.addMeal(F5);
		Sushi.addMeal(F6);

		Restaurant KFC = new Restaurant("KFC", "kfc", 40, 10);
		foodora.addUser(KFC);
		FullMeal F7 = new FullMeal("F7", new Starter("Saucisson", 4, false, true),
				new MainDish("Chicken", 4, false, true), new Dessert("IceCream", 2, true, false));
		HalfMeal F8 = new HalfMeal("F8", new MainDish("Chicken2", 4, false, true),
				new Dessert("BetterIceCream", 2, true, false));
		KFC.addMeal(F7);
		KFC.addMeal(F8);

		Restaurant Bio = new Restaurant("BioFast", "biofast", -40, -10);
		foodora.addUser(Bio);
		FullMeal F9 = new FullMeal("F9", new Starter("SaucissonBio", 4, false, true),
				new MainDish("ChickenBio", 4, false, true), new Dessert("IceCreamBio", 2, true, false));
		HalfMeal F10 = new HalfMeal("F10", new MainDish("Chicken2Bio", 4, false, true),
				new Dessert("BetterIceCreamBio", 2, true, false));
		Bio.addMeal(F9);
		Bio.addMeal(F10);

		Courier Fred = new Courier("Fred", "fredo", "fred", 0, 10, "Fred@laposte.net", "0612345678");
		foodora.addUser(Fred);
		Courier Carole = new Courier("Carole", "Coco", "~Xxcaroledu58xX~", 0, 10, "Carole@laposte.net", "0612345678");
		foodora.addUser(Carole);
		Customer A = new Customer("A", "A", "a", 22, -24, "0654312456", "A@laposte.net");
		foodora.addUser(A);
		Customer B = new Customer("B", "B", "b", 42, 14, "0654617456", "B@laposte.net");
		foodora.addUser(B);
		Customer C = new Customer("C", "C", "c", 52, -14, "0654312456", "C@laposte.net");
		foodora.addUser(C);
		Customer D = new Customer("D", "D", "d", -22, 42, "0658318456", "D@laposte.net");
		foodora.addUser(D);
		Customer E = new Customer("E", "E", "e", -12, 64, "0654312956", "E@laposte.net");
		foodora.addUser(E);
		Customer F = new Customer("F", "F", "f", -2, -4, "0614372456", "F@laposte.net");
		foodora.addUser(F);
		Customer G = new Customer("G", "G", "g", 0, 47, "0654312456", "G@laposte.net");
		foodora.addUser(G);

		// 2. the system sends alerts to the customers that agreed to be
		// notified of special offers
		foodora.notifyObservers("You agreed to be notified.");

		// Register a user
		// 1. a user start using the system because she wants to register
		Scanner sc = new Scanner(System.in);
		int action;
		do {
			System.out.println("What would you like to do :");
			System.out.println("1 - Register");
			System.out.println("2 - Connect");
			action = Integer.parseInt(sc.nextLine());
		} while (action != 1 && action != 2);

		if (action == 1) {
			// 2. the user inserts his first-name, his last-name, his username,
			// his
			// address, his birth-
			// date...
			System.out.println("Registering process...");
			String name;
			String surname;
			String username;
			double addressX;
			double addressY;
			System.out.println("Enter name :");
			name = sc.nextLine();
			System.out.println("Enter surname :");
			surname = sc.nextLine();
			System.out.println("Enter username :");
			username = sc.nextLine();
			System.out.println("Enter address :");
			addressX = Double.parseDouble(sc.nextLine());
			addressY = Double.parseDouble(sc.nextLine());
			int type;
			User c;
			do {
				System.out.println("Enter type of user :");
				System.out.println("1 - Customer");
				System.out.println("2 - Courier");
				type = Integer.parseInt(sc.nextLine());
			} while (type != 1 && type != 2);
			if (type == 1) {

				c = (Customer) new Customer(name, surname, username, addressX, addressY);
			} else {
				c = (Courier) new Courier(name, surname, username, addressX, addressY);
			}
			foodora.addUser(c);

			// 3. the user starts inserting a contact info with the type and the
			// value (e.g. email, phone)
			// • the user repeats step 3 since he ends to inserts his contact
			// info
			int contact;
			do {
				System.out.println("Inserting contact info : ");
				System.out.println("1 - email");
				System.out.println("2 - phone");
				System.out.println("3 - stop");
				contact = Integer.parseInt(sc.nextLine());
				if (contact == 1) {
					System.out.println("Adding email address");
					c.setEmail(sc.nextLine());
				}
				if (contact == 2) {
					System.out.println("Adding phone number");
					c.setPhoneNumber(sc.nextLine());
				}

			} while (contact != 3);

			// 4. if the user is a customer she sets the agreement about the
			// special
			// offer contact (by
			// default it is no)

			if (c instanceof Customer) {
				String response;
				do {
					System.out.println("Do you want to be informed of special offers ? (y/N)");
					response = sc.nextLine();
				} while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n") && !response.isEmpty());
				if (response.equalsIgnoreCase("y")) {
					((Customer) c).register();
				}
			}
			// 5. the user is a customer selects the contact to be used to send
			// the
			// offers (by default it
			// is the e-mail if exists)
			if (c instanceof Customer) {
				int response;
				do {
					System.out.println("Select contact method for offers :");
					System.out.println("1 - email (default)");
					System.out.println("2 - phone number");
					response = Integer.parseInt(sc.nextLine());
				} while (response != 1 && response != 2 && response != 0);
				if (response == 2) {
					((Customer) c).setNotifyMean(c.getPhoneNumber());
				} else {
					((Customer) c).setNotifyMean(c.getEmail());
				}
			}

			// 6. if the user is a courier he sets his current duty status
			// (default
			// off-duty)

			if (c instanceof Courier) {
				String response;
				do {
					System.out.println("Do you want to be seen as on-duty ? (y/N)");
					response = sc.nextLine();
				} while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n") && !response.isEmpty());
				if (response.equalsIgnoreCase("y")) {
					((Courier) c).setOnDuty(true);
				} else {
					((Courier) c).setOnDuty(false);
				}
			}

			// 7. the user specify to save the account

			String response;
			do {
				System.out.println("Do you wish to save your account ? (Y/n)");
				response = sc.nextLine();
			} while (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("n") && !response.isEmpty());
			if (response.equalsIgnoreCase("n")) {
				foodora.removeUser(c);
			}
		}
		// Login user
		// 1. a user wants to login
		else {
			User user=null;
			do {
				// 2. the user inserts username (and password : not implemented)
				System.out.println("Enter Username:");
				String username = sc.nextLine();
				for (User u : foodora.getUserList().values()){
					if (username.equals(u.getUsername())){
						user=u;
					}
				}
			} while (!(user==null));
			// 3. the system handles the login and presents to the user the
			// available operations according to his role
			System.out.println("Voilà ce que tu peux faire :");
		}
		// Ordering a meal
		// 1. a client start using the system because she wants to order a meal
		// 2. the client inserts his credentials (username and password)
		// 3. the system recognizes the client and proposes the available
		// restaurants
		// 4. the client select a restaurant and compose an order either by
		// selecting dishes à la
		// carte or by selecting meals from the restaurant menu. For each item
		// in the order the
		// client specifies the quantity.
		// 5. Once the order is completed the client selects the end
		// 6. the system shows the summary of the ordered dishes and the total
		// price of the order
		// taking into account the pricing rules
		// Inserting a meal or dish in a restaurant menu
		// 1. a restaurant person start using the system because she wants to
		// insert a new meal
		// 2. she inserts the restaurant credentials (username and password)
		// Page 8IS1220 - Object Oriented Software Design
		// Project March-April 2017
		// 3. the system recognizes the restaurant and shows the list of dishes
		// and meals in the
		// menu
		// 4. the restaurant selects the insert new meal (or dish) operations
		// 5. the restaurant inserts the name of the new meal (or dish) to be
		// added and specify
		// whether it is an half-meal or a full-meal or a meal-of-the-week
		// 6. in case of a dish the restaurant specify the unit price and the
		// category its category
		// (starter, main dish, dessert)
		// 7. in case of meal
		// • the restaurant inserts the dishes of the meal
		// • the restaurant compute and save the price of the meal
		// 8. the restaurant saves the new created meal (or dish) in the menu
		// Adding a meal of the week special offer
		// 1. a restaurant staff starts using the system and inserts the
		// restaurant credentials
		// 2. the system shows all restaurant’s available meals
		// 3. the restaurant selects the meal to be set as meal of the week
		// 4. the system automatically updates the price of selected meal of the
		// week, by application
		// of special discount factor
		// 5. the system notifies the users (that agreed to be notified of
		// special offers) about the
		// new offer
		// Removing a meal of the week special offer
		// 1. a restaurant staff starts using the system and inserts the
		// restaurant credentials
		// 2. the system shows all restaurant’s available meals
		// 3. the restaurant selects a meal in the meal of the week list and
		// selects the remove from
		// its special offer state.
	}
}
