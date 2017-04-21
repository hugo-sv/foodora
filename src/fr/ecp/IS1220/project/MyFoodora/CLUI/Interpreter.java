package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.util.Scanner;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.Customer;
import fr.ecp.IS1220.project.MyFoodora.core.Manager;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;
import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;
import fr.ecp.IS1220.project.MyFoodora.core.User;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;
import fr.ecp.IS1220.project.MyFoodora.core.menu.FullMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Item;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Meal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Orderable;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Starter;
import fr.ecp.IS1220.project.MyFoodora.core.policy.FairOccupationPolicy;
import fr.ecp.IS1220.project.MyFoodora.core.policy.FastestPolicy;

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
		if (arguments.length>2) {
			System.out.println("Too many arguments");
		} else if (arguments.length<2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Manager)) {
				System.out.println("Permission denied");
			} else {
				if (!arguments[1].equalsIgnoreCase("fastest") && !arguments[1].equalsIgnoreCase("fair-occupation")) {
					System.out.println("Wrong policy name");
				} else {
					if (arguments[1].equalsIgnoreCase("fastest")) {
						((Manager) user).setDeliveryPolicy(new FastestPolicy());
					} else {
						((Manager) user).setDeliveryPolicy(new FairOccupationPolicy());
					}
				}
			}
		}
	}

	private void findDeliverer(String[] arguments) {
		if (arguments.length>2) {
			System.out.println("Too many arguments");
		} else if (arguments.length<2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Restaurant)) {
				System.out.println("Permission denied");
			} else {
				Order order = null;
				for (Order orderiter : foodora.getCurrentOrder_List()) {
					if (orderiter.equals(arguments[1])) {
						order = orderiter;
					}
				}
				if (order == null) {
					System.out.println("No order named "+arguments[1]);
				} else {
					foodora.getDeliveryPolicy().chooseCourier(foodora, order).propose(order);
				}
			}
		}
	}

	private void offDuty(String[] arguments) {
		if (arguments.length>2) {
			System.out.println("Too many arguments");
		} else if (arguments.length<2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Courier)) {
				System.out.println("Permission denied");
			} else {
				if (!user.getUsername().equals(arguments[1])) {
					System.out.println("Wrong username");
				} else {
					((Courier) user).setOnDuty(false);
				}
			}
		}
	}

	private void endOrder(String[] arguments) {
		if (arguments.length>3) {
			System.out.println("Too many arguments");
		} else if (arguments.length<3) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Customer)) {
				System.out.println("Permission denied");
			} else {
				Order order = null;
				for (Order orderiter : ((Customer) user).getCurrentOrders()) {
					if (orderiter.equals(arguments[1])) {
						order = orderiter;
					}
				}
				if (order == null) {
					System.out.println("No order named "+arguments[1]);
				} else {
					((Customer) user).payOrder(order);
					// TODO implement time
				}
			}
		}
	}

	private void onDuty(String[] arguments) {
		if (arguments.length>2) {
			System.out.println("Too many arguments");
		} else if (arguments.length<2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Courier)) {
				System.out.println("Permission denied");
			} else {
				if (!user.getUsername().equals(arguments[1])) {
					System.out.println("Wrong username");
				} else {
					((Courier) user).setOnDuty(true);
				}
			}
		}
	}

	private void addItem2Order(String[] arguments) {
		if (arguments.length>3) {
			System.out.println("Too many arguments");
		} else if (arguments.length<3) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Customer)) {
				System.out.println("Permission denied");
			} else {
				Order order = null;
				for (Order orderiter : ((Customer) user).getCurrentOrders()) {
					if (orderiter.equals(arguments[1])) {
						order = orderiter;
					}
				}
				if (order == null) {
					System.out.println("No order named "+arguments[1]);
				} else {
					Item item = null;
					Meal meal = null;
					for (Item itemiter : order.getRestaurant().getMenu().getItems()) {
						if (itemiter.equals(arguments[2])) {
							item = itemiter;
						}
					}
					for (Meal mealiter : order.getRestaurant().getMenu().getMeals()) {
						if (mealiter.equals(arguments[2])) {
							meal = mealiter;
						}
					}
					if (meal == null && item == null ) {
						System.out.println("Nothing found");
					} else {
						if (item != null) {
							order.addOrderable((Orderable) item); 
						} else {
							order.addOrderable((Orderable) meal);
						}
					}

				}
			}
		}
	}

	private void createOrder(String[] arguments) {
		if (arguments.length>2) {
			System.out.println("Too many arguments");
		} else if (arguments.length<2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Customer)) {
				System.out.println("Permission denied");
			} else {
				boolean t = true;
				for (Order order : ((Customer) user).getOrders()) {
					t = t && !order.getName().equals(arguments[1]);
				}
				if (t) {
					Restaurant restaurant = null;
					for (Restaurant restaurantiter : foodora.getRestaurantList()) {
						if (restaurantiter.getName().equals(arguments[1])) {
							restaurant = restaurantiter;
						}
					}
					if (restaurant == null) {
						System.out.println("No restaurant named "+arguments[1]);
					} else {
						Order order = new Order((Customer) user, restaurant, foodora.getServiceFee(), foodora.getMarkupPourcentage(), foodora.getDeliveryCost());
						((Customer) user).getOrders().add(order);
					}
				} else {
					System.out.println("This name is already used");
				}

			}
		}
	}

	private void removeFromSpecialOffer(String[] arguments) {
		if (arguments.length>2) {
			System.out.println("Too many arguments");
		} else if (arguments.length<2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Restaurant)) {
				System.out.println("Permission denied");
			} else {
				Meal meal = null;
				for (Meal mealiter : ((Restaurant) user).getMenu().getMeals()) {
					if (mealiter.getName().equals(arguments[1])) {
						meal = mealiter;
					}
				}
				if (meal == null) {
					System.out.println("No meal named "+arguments[1]);
				} else {
					if (((Restaurant) user).getMealsOfTheWeek().contains(meal)) {
						((Restaurant) user).removeMealOfTheWeek(meal);
					} else {
						System.out.println("This is not a meal of the week");
					}
				}
			}
		}
	}

	private void setSpecialOffer(String[] arguments) {
		if (arguments.length>2) {
			System.out.println("Too many arguments");
		} else if (arguments.length<2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Restaurant)) {
				System.out.println("Permission denied");
			} else {
				Meal meal = null;
				for (Meal mealiter : ((Restaurant) user).getMenu().getMeals()) {
					if (mealiter.getName().equals(arguments[1])) {
						meal = mealiter;
					}
				}
				if (meal == null) {
					System.out.println("No meal named "+arguments[1]);
				} else {
					((Restaurant) user).addMealOfTheWeek(meal);
				}
			}
		}
	}

	private void login(String[] arguments) {
		if (arguments.length>3) {
			System.out.println("Too many arguments");
		} else if (arguments.length<3) {
			System.out.println("Too few arguments");
		} else {
			for (User user : foodora.getUserList().values()) {
				if (user.getUsername()==arguments[1] && user.getPassword() == arguments[2]) {
					this.user = user;
				}
			}
			if (this.user == null) {
				System.out.println("Wrong username or password");
			}
		}
	}

	private void logout(String[] arguments) {
		if (user == null) {
			System.out.println("Not logged in");
		} else {
			System.out.println("Good bye "+user.getUsername());
			user = null;
		}
	}

	private void registerRestaurant(String[] arguments) {
		if (arguments.length>5) {
			System.out.println("Too many arguments");
		} else if (arguments.length<5) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Manager)) {
				System.out.println("Permission denied");
			} else {
				String[] address = arguments[2].split(",");
				if (address.length != 2) {
					System.out.println("Wrong address");
				} else {
					double addressX = Double.parseDouble(address[0]);
					double addressY = Double.parseDouble(address[1]);
					Restaurant restaurant = new Restaurant(arguments[1], arguments[3], addressX, addressY);
					restaurant.setPassword(arguments[4]);
					((Manager) user).addUser(restaurant);
				}
			}
		}
	}

	private void registerCustomer(String[] arguments) {
		if (arguments.length>6) {
			System.out.println("Too many arguments");
		} else if (arguments.length<6) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Manager)) {
				System.out.println("Permission denied");
			} else {
				String[] address = arguments[4].split(",");
				if (address.length != 2) {
					System.out.println("Wrong address");
				} else {
					double addressX = Double.parseDouble(address[0]);
					double addressY = Double.parseDouble(address[1]);
					Customer customer = new Customer(arguments[2], arguments[1], arguments[3], addressX, addressY);
					customer.setPassword(arguments[5]);
					((Manager) user).addUser(customer);
				}
			}
		}
	}

	private void registerCourier(String[] arguments) {
		if (arguments.length>6) {
			System.out.println("Too many arguments");
		} else if (arguments.length<6) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Manager)) {
				System.out.println("Permission denied");
			} else {
				String[] address = arguments[4].split(",");
				if (address.length != 2) {
					System.out.println("Wrong address");
				} else {
					double addressX = Double.parseDouble(address[0]);
					double addressY = Double.parseDouble(address[1]);
					Courier courier = new Courier(arguments[2], arguments[1], arguments[3], addressX, addressY);
					courier.setPassword(arguments[5]);
					courier.setOnDuty(true);
					((Manager) user).addUser(courier);
				}
			}
		}
	}

	private void addDishRestaurantMenu(String[] arguments) {
		if (arguments.length>5) {
			System.out.println("Too many arguments");
		} else if (arguments.length<5) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Restaurant)) {
				System.out.println("Permission denied");
			} else {
				if (!arguments[2].equalsIgnoreCase("starter") && !arguments[2].equalsIgnoreCase("main") && !arguments[2].equalsIgnoreCase("dessert")) {
					System.out.println("Wrong dish category");
				} else if (!arguments[3].equalsIgnoreCase("standard") && !arguments[3].equalsIgnoreCase("vegetarian") && !arguments[3].equalsIgnoreCase("gluten-free")) {
					System.out.println("Wrong food type");
				} else {
					Item item = null;
					if (arguments[2].equalsIgnoreCase("starter")) {
						item = new Starter(arguments[1], Double.parseDouble(arguments[4]), arguments[3].equalsIgnoreCase("vegetarian"), arguments[3].equalsIgnoreCase("gluten-free"));		
					} else if (arguments[2].equalsIgnoreCase("main")) {
						item = new MainDish(arguments[1], Double.parseDouble(arguments[4]), arguments[3].equalsIgnoreCase("vegetarian"), arguments[3].equalsIgnoreCase("gluten-free"));
					} else {
						item = new Dessert(arguments[1], Double.parseDouble(arguments[4]), arguments[3].equalsIgnoreCase("vegetarian"), arguments[3].equalsIgnoreCase("gluten-free"));
					}
					boolean t = true;
					for (Item item2 : ((Restaurant) user).getMenu().getItems()) {
						t = t && !item2.getName().equals(arguments[1]);
					}
					if (t) {
						((Restaurant) user).getMenu().addItem(item);
					} else {
						System.out.println("This name is already used");
					}
				}
			}
		}
	}

	private void createMeal(String[] arguments) {
		if (arguments.length>2) {
			System.out.println("Too many arguments");
		} else if (arguments.length<2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Restaurant)) {
				System.out.println("Permission denied");
			} else {
				boolean t = true;
				for (Meal meal : ((Restaurant) user).getMenu().getMeals()) {
					t = t && !meal.getName().equals(arguments[1]);
				}
				if (t) {
					HalfMeal halfMeal = new HalfMeal(arguments[1], (Starter) null, null);
					((Restaurant) user).getMenu().addMeal(halfMeal);
				} else {
					System.out.println("This name is already used");
				}

			}
		}
	}

	private void showMeal(String[] arguments) {
		if (arguments.length>2) {
			System.out.println("Too many arguments");
		} else if (arguments.length<2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Restaurant)) {
				System.out.println("Permission denied");
			} else {
				Meal meal = null;
				for (Meal mealiter : ((Restaurant) user).getMenu().getMeals()) {
					if (mealiter.getName().equals(arguments[1])) {
						meal = mealiter;
					}
				}
				if (meal == null) {
					System.out.println("No meal named "+arguments[1]);
				} else {
					System.out.println(meal.toString());
				}
			}
		}
	}

	private void addDish2Meal(String[] arguments) {
		if (arguments.length>3) {
			System.out.println("Too many arguments");
		} else if (arguments.length<3) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Restaurant)) {
				System.out.println("Permission denied");
			} else {
				Meal meal = null;
				for (Meal mealiter : ((Restaurant) user).getMenu().getMeals()) {
					if (mealiter.getName().equals(arguments[2])) {
						meal = mealiter;
					}
				}
				if (meal == null) {
					System.out.println("No meal named "+arguments[2]);
				} else {
					Item item = null;
					for (Item itemiter : ((Restaurant) user).getMenu().getItems()) {
						if (itemiter.getName().equals(arguments[1])) {
							item = itemiter;
						}
					}
					if (item == null) {
						System.out.println("No dish named "+arguments[1]);
					} else {
						if (item instanceof Starter) {
							if (meal.getEntry() != null) {
								System.out.println("This meal already contains a starter");
							} else {
								meal.setEntry((Starter) item);
							}
						} else if (item instanceof MainDish) {
							if (meal.getMain() != null) {
								System.out.println("This meal already contains a main dish");
							} else {
								meal.setMain((MainDish) item);
							}
						} else {
							if (meal.getDessert() != null) {
								System.out.println("This meal already contains a dessert");
							} else {
								meal.setDessert((Dessert) item);
							}
						}
						int dishNumber = 0;
						if (meal.getEntry() != null) {
							dishNumber++;
						}
						if (meal.getMain() != null) {
							dishNumber++;
						}
						if (meal.getDessert() != null) {
							dishNumber++;
						}
						if (dishNumber == 3) {
							meal = (FullMeal) meal;
						}
					}
				}

			}
		}

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
		if (true) {
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
			this.registerCustomer(arguments);
			break;
		case "registerCourier":
			this.registerCourier(arguments);
			break;
		case "addDishRestaurantMenu":
			this.addDishRestaurantMenu(arguments);
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