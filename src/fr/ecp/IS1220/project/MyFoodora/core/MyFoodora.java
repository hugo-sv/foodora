package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;
import fr.ecp.IS1220.project.MyFoodora.core.menu.FullMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Starter;
import fr.ecp.IS1220.project.MyFoodora.core.policy.DeliveryPolicy;
import fr.ecp.IS1220.project.MyFoodora.core.policy.OrderSortingPolicy;
import fr.ecp.IS1220.project.MyFoodora.core.policy.TargetPolicy;

public class MyFoodora {
	private HashMap<Long, User> userList;
	private ArrayList<Order> completedOrder_List;
	private ArrayList<Order> currentOrder_List;
	private double serviceFee;
	private double markupPourcentage;
	private double deliveryCost;
	private TargetPolicy targetPolicy;
	private DeliveryPolicy deliveryPolicy;
	private OrderSortingPolicy orderSortingPolicy;
	private ArrayList<Customer> observers;
	private double money = 0;

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
		
		MainDish Drink=new MainDish("Drink",0.5,true,true);
		MainDish BigMac=new MainDish("BigMac", 5, false, false);
		Starter Salad=new Starter("Salad", 1, true, true);
		Dessert MacFlurry=new Dessert("McFlurry",2,true,false);
		
		FullMeal F1 = new FullMeal("F1", Salad, BigMac, MacFlurry);
		HalfMeal F2 = new HalfMeal("F2", Salad, Drink);
		
		Macdo.addMeal(F1);
		Macdo.addMeal(F2);
		
		Restaurant Quick = new Restaurant("Quick", "quick", 105, 74);
		foodora.addUser(Quick);
		FullMeal F3 = new FullMeal("F3", Salad, new MainDish("Nuggets", 4, false, true), new Dessert("Donut", 2, true, false));
		HalfMeal F4 = new HalfMeal("F4",new MainDish("Nuggets", 4, false, true), new Dessert("Donut", 2, true, false));
		Quick.addMeal(F3);
		Quick.addMeal(F4);
		
		Restaurant Sushi = new Restaurant("SushiWorld", "sushi", 5, -50);
		foodora.addUser(Sushi);
		FullMeal F5 = new FullMeal("F5", new Starter("Sushi2", 4, false, true), new MainDish("Sushi1", 4, false, true), new Dessert("Dessert", 2, true, false));
		HalfMeal F6 = new HalfMeal("F6",new MainDish("Sushi3", 4, false, true), new Dessert("Dessert2", 2, true, false));
		Sushi.addMeal(F5);
		Sushi.addMeal(F6);
		
		Restaurant KFC = new Restaurant("KFC", "kfc", 40, 10);
		foodora.addUser(KFC);
		FullMeal F7 = new FullMeal("F7", new Starter("Saucisson", 4, false, true), new MainDish("Chicken", 4, false, true), new Dessert("IceCream", 2, true, false));
		HalfMeal F8 = new HalfMeal("F8",new MainDish("Chicken2", 4, false, true), new Dessert("BetterIceCream", 2, true, false));
		KFC.addMeal(F7);
		KFC.addMeal(F8);
		
		Restaurant Bio = new Restaurant("BioFast", "biofast", -40, -10);
		foodora.addUser(Bio);
		FullMeal F9 = new FullMeal("F9", new Starter("SaucissonBio", 4, false, true), new MainDish("ChickenBio", 4, false, true), new Dessert("IceCreamBio", 2, true, false));
		HalfMeal F10 = new HalfMeal("F10",new MainDish("Chicken2Bio", 4, false, true), new Dessert("BetterIceCreamBio", 2, true, false));
		Bio.addMeal(F9);
		Bio.addMeal(F10);
		
		
		Courier Fred = new Courier("Fred", "fredo", "fred", 0, 10,"Fred@laposte.net" ,"0612345678");
		foodora.addUser(Fred);
		Courier Carole = new Courier("Carole", "Coco", "~Xxcaroledu58xX~", 0, 10,"Carole@laposte.net" ,"0612345678");
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
		// 2. the user inserts his first-name, his last-name, his username, his
		// address, his birth-
		// date...
		// Page 7IS1220 - Object Oriented Software Design
		// Project March-April 2017
		Scanner sc = new Scanner(System.in);
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
		if (type ==1) {
			
			c = (Customer) new Customer(name, surname, username, addressX, addressY);
		} else {
			c = (Courier) new Courier(name, surname, username, addressX, addressY);
		}
		foodora.addUser(c);
			
		
		
		 
		// 3. the user starts inserting a contact info with the type and the
		// value (e.g. email, phone)
		// • the user repeats step 3 since he ends to inserts his contact info
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

		
		
		// 4. if the user is a customer she sets the agreement about the special
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
		// 5. the user is a customer selects the contact to be used to send the
		// offers (by default it
		// is the e-mail if exists)
		if (c instanceof Customer) {
			int response;
			do {
				System.out.println("Do you want to be informed of special offers ? (y/N)");
			} while (true);
		
		// 6. if the user is a courier he sets his current duty status (default
		// off-duty)
		// 7. the user specify to save the account
		// Login user
		// 1. a user wants to login
		// 2. the user inserts username and password
		// 3. the system handles the login and presents to the user the
		// available operations ac-
		// cording to his role
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

	// Constructor
	public MyFoodora(double serviceFee, double markupPourcentage, double deliveryCost) {
		super();
		this.serviceFee = serviceFee;
		this.markupPourcentage = markupPourcentage;
		this.deliveryCost = deliveryCost;
		this.userList = new HashMap<Long, User>();
		this.completedOrder_List = new ArrayList<Order>();
		this.currentOrder_List = new ArrayList<Order>();
		this.observers = new ArrayList<Customer>();
	}

	public void give(Order order) {
		// Registered customers make their own selection and they are charged a
		// total fee which is cashed by MyFoodora and that includes also the
		// cost of delivery. The total fee is broken down into: 1) the price of
		// the order (which is set by each restaurant) plus 2) a service-fee
		// which is set by the MyFoodora manager. In order to guarantee an
		// income MyFoodora also apply a markup percentage (“percentage de
		// marge”) to the price of an order. The markup percentage represents
		// the percentage of money retained by MyFoodora from the price of an
		// order placed to a given restaurant. The MyFoodora system must. then
		// payback both the restaurants as well as the courriers. Restaurants
		// compile their own menus and may set up special offers. Once an order
		// is placed (and payed for) the system is in charge for managing the
		// delivery of the order, that is, the system will find an available
		// deliverer amongst a fleet of available couriers.
		if (!currentOrder_List.contains(order)) {
			currentOrder_List.add(order);
		}
		Courier courier = deliveryPolicy.chooseCourier(this, order);
		courier.propose(order);

	}

	public void registerObserver(Customer c) {
		if (observers.contains(c)) {
			c.notify("You have already accepted to be notified whenever a new special offer is set by any restaurant");
		} else {
			observers.add(c);
			c.notify("You accepted to be notified whenever a new special offer is set by any restaurant");
		}
	}

	public void unregisterObserver(Customer c) {
		if (observers.contains(c)) {
			observers.remove(c);
			c.notify("You refused to be notified whenever a new special offer is set by any restaurant");
		} else {
			c.notify("You have already refused to be notified whenever a new special offer is set by any restaurant");
		}
	}

	public void notifyObservers(String message) {
		for (Customer c : observers) {
			c.notify(message);
		}
	}

	public void addUser(User user) {
		user.setMyFoodora(this);
		userList.put(user.getiD(), user);
	}

	public void removeUser(User user) {
		user.setMyFoodora(null);
		userList.remove(user.getiD());
	}

	public void activateUser(User user) {
		if (userList.containsKey(user.getiD())) {
			user.setActivated(true);
		}
	}

	public void disactivateUser(User user) {
		if (userList.containsKey(user.getiD())) {
			user.setActivated(false);
		}
	}

	public void addCourier(Courier courier) {
		courier.setMyFoodora(this);
		userList.put(courier.getiD(), courier);
	}

	public void removeCourier(Courier courier) {
		courier.setMyFoodora(null);
		userList.remove(courier.getiD());
	}

	public double getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(double serviceFee) {
		this.serviceFee = serviceFee;
	}

	public double getMarkupPourcentage() {
		return markupPourcentage;
	}

	public void setMarkupPourcentage(double markupPourcentage) {
		this.markupPourcentage = markupPourcentage;
	}

	public double getDeliveryCost() {
		return deliveryCost;
	}

	public void setDeliveryCost(double deliveryCost) {
		this.deliveryCost = deliveryCost;
	}

	public ArrayList<Order> getCompletedOrder_List() {
		return completedOrder_List;
	}

	public ArrayList<Order> getCurrentOrder_List() {
		return currentOrder_List;
	}

	public double computeTotalIncome(Time begin, Time end) {
		double income = 0;
		for (Order order : completedOrder_List) {
			income += order.getPrice() * order.getMarkupPourcentage() + order.getServiceFee();
		}
		return income;
	}

	public double computeTotalProfit(Time begin, Time end) {
		double profit = 0;
		for (Order order : completedOrder_List) {
			profit += order.getPrice() * order.getMarkupPourcentage() + order.getServiceFee() - order.getDeliveryCost();
		}
		return profit;
	}

	public void setTargetPolicy(TargetPolicy targetPolicy) {
		this.targetPolicy = targetPolicy;
	}

	public TargetPolicy getTargetPolicy() {
		return targetPolicy;
	}

	public ArrayList<Courier> getCourierList() {
		ArrayList<Courier> courierList = new ArrayList<Courier>();
		for (User user : userList.values()) {
			if (user instanceof Courier) {
				courierList.add((Courier) user);
			}
		}
		return courierList;
	}

	public Courier mostActiveCourier() {
		HashMap<Long, Integer> activeCourier = new HashMap<Long, Integer>();
		for (Courier courier : getCourierList()) {
			activeCourier.put(courier.getiD(), 0);
		}
		for (Order order : getCompletedOrder_List()) {
			long id = order.getCourier().getiD();
			if (activeCourier.containsKey(id)) {
				activeCourier.put(id, activeCourier.get(id) + 1);
			}
			activeCourier.put(id, 1);
		}
		long idm = -1;
		double m = -1;
		for (Long id : activeCourier.keySet()) {
			if (idm < 0 || activeCourier.get(id) > m) {
				m = activeCourier.get(id);
				idm = id;
			}
		}
		return (Courier) userList.get(idm);
	}

	public Courier leastActiveCourier() {
		HashMap<Long, Integer> activeCourier = new HashMap<Long, Integer>();
		for (Courier courier : getCourierList()) {
			activeCourier.put(courier.getiD(), 0);
		}
		for (Order order : getCompletedOrder_List()) {
			long id = order.getCourier().getiD();
			if (activeCourier.containsKey(id)) {
				activeCourier.put(id, activeCourier.get(id) + 1);
			}
			activeCourier.put(id, 1);
		}
		long idm = -1;
		double m = -1;
		for (Long id : activeCourier.keySet()) {
			if (idm < 0 || activeCourier.get(id) < m) {
				m = activeCourier.get(id);
				idm = id;
			}
		}
		return (Courier) userList.get(idm);
	}

	public DeliveryPolicy getDeliveryPolicy() {
		return deliveryPolicy;
	}

	public void setDeliveryPolicy(DeliveryPolicy deliveryPolicy) {
		this.deliveryPolicy = deliveryPolicy;
	}

	public HashMap<Long, User> getUserList() {
		return userList;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

}