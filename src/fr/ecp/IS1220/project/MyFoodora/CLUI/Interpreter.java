package fr.ecp.IS1220.project.MyFoodora.CLUI;

import java.util.ArrayList;
import java.util.Scanner;

import fr.ecp.IS1220.project.MyFoodora.core.Courier;
import fr.ecp.IS1220.project.MyFoodora.core.Customer;
import fr.ecp.IS1220.project.MyFoodora.core.Manager;
import fr.ecp.IS1220.project.MyFoodora.core.MyFoodora;
import fr.ecp.IS1220.project.MyFoodora.core.Order;
import fr.ecp.IS1220.project.MyFoodora.core.Restaurant;
import fr.ecp.IS1220.project.MyFoodora.core.Time;
import fr.ecp.IS1220.project.MyFoodora.core.User;
import fr.ecp.IS1220.project.MyFoodora.core.cards.BasicFidelityCard;
import fr.ecp.IS1220.project.MyFoodora.core.cards.LotteryFidelityCard;
import fr.ecp.IS1220.project.MyFoodora.core.cards.PointFidelityCard;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;
import fr.ecp.IS1220.project.MyFoodora.core.menu.FullMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.HalfMeal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Item;
import fr.ecp.IS1220.project.MyFoodora.core.menu.MainDish;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Meal;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Orderable;
import fr.ecp.IS1220.project.MyFoodora.core.menu.Starter;
import fr.ecp.IS1220.project.MyFoodora.core.policy.DeliveryCostPolicy;
import fr.ecp.IS1220.project.MyFoodora.core.policy.FairOccupationPolicy;
import fr.ecp.IS1220.project.MyFoodora.core.policy.FastestPolicy;
import fr.ecp.IS1220.project.MyFoodora.core.policy.ServiceFeePolicy;

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
		System.out.println("To register, type register");
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
		System.out.println("Unknow command, please use the help command.");
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

	private void showCourierDeliveries() {
		if (!(user instanceof Manager)) {
			System.out.println("Permission denied");
		} else {
			ArrayList<Courier> courierList = foodora.getCourierList();
			courierList.sort(new CourierComparator(foodora, true));
			for (Courier courier : courierList) {
				System.out.println("id : " + courier.getiD() + ", username : " + courier.getUsername());
			}
		}
	}

	private void showRestaurantTop() {
		if (!(user instanceof Manager)) {
			System.out.println("Permission denied");
		} else {
			ArrayList<Restaurant> restaurantList = foodora.getRestaurantList();
			restaurantList.sort(new RestaurantComparator(foodora, true));
			for (Restaurant restaurant : restaurantList) {
				System.out.println("id : " + restaurant.getiD() + ", username : " + restaurant.getUsername());
			}
		}
	}

	private void showCustomers() {
		if (!(user instanceof Manager)) {
			System.out.println("Permission denied");
		} else {
			for (Customer customer : foodora.getCustomerList()) {
				System.out.println("id : " + customer.getiD() + ", username : " + customer.getUsername());
			}
		}
	}

	private void associateCard(String[] arguments) {
		if (arguments.length > 3) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 3) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Manager)) {
				System.out.println("Permission denied");
			} else {
				Customer customer = null;
				for (Customer customeriter : foodora.getCustomerList()) {
					if (customeriter.getName().equals(arguments[1])) {
						customer = customeriter;
					}
				}
				if (customer == null) {
					System.out.println("No customer named " + arguments[1]);
				} else {
					if (!arguments[1].equalsIgnoreCase("basic") && !arguments[1].equalsIgnoreCase("point")
							&& !arguments[1].equalsIgnoreCase("lottery")) {
						System.out.println("Wrong policy name");
						System.out.println("Policy is either basic, point or lottery");
					} else {
						if (arguments[1].equalsIgnoreCase("basic")) {
							customer.setFidelityCard(new BasicFidelityCard());
						} else if (arguments[1].equalsIgnoreCase("point")) {
							customer.setFidelityCard(new PointFidelityCard());
						} else {
							customer.setFidelityCard(new LotteryFidelityCard());
						}
					}
				}
			}
		}
	}

	private void setDeliveryPolicy(String[] arguments) {
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Manager)) {
				System.out.println("Permission denied");
			} else {
				if (!arguments[1].equalsIgnoreCase("fastest") && !arguments[1].equalsIgnoreCase("fair-occupation")) {
					System.out.println("Wrong policy name");
					System.out.println("Policy is either fastest or fair-occupation");
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

	private void setProfitPolicy(String[] arguments) {
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Manager)) {
				System.out.println("Permission denied");
			} else {
				if (!arguments[1].equalsIgnoreCase("deliverycost") && !arguments[1].equalsIgnoreCase("servicefee")
						&& !arguments[1].equalsIgnoreCase("markup")) {
					System.out.println("Wrong policy name");
					System.out.println("Policy is either deliveryCost, serviceFee or markup");
				} else {
					if (arguments[1].equalsIgnoreCase("deliverycost")) {
						((Manager) user).setTargetPolicy(new DeliveryCostPolicy());
					} else if (arguments[1].equalsIgnoreCase("servicefee")) {
						((Manager) user).setTargetPolicy(new ServiceFeePolicy());
					} else {
						((Manager) user).setTargetPolicy(new ServiceFeePolicy());
					}
				}
			}
		}
	}

	private void findDeliverer(String[] arguments) {
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
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
					System.out.println("No order named " + arguments[1]);
				} else {
					foodora.getDeliveryPolicy().chooseCourier(foodora, order).propose(order);
				}
			}
		}
	}

	private void offDuty(String[] arguments) {
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
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
		if (arguments.length > 3) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 3) {
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
					System.out.println("No order named " + arguments[1]);
				} else {
					((Customer) user).payOrder(order);
					// TODO implement time
				}
			}
		}
	}

	private void onDuty(String[] arguments) {
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
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
		if (arguments.length > 3) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 3) {
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
					System.out.println("No order named " + arguments[1]);
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
					if (meal == null && item == null) {
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
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
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
						System.out.println("No restaurant named " + arguments[1]);
					} else {
						Order order = new Order((Customer) user, restaurant, foodora.getServiceFee(),
								foodora.getMarkupPourcentage(), foodora.getDeliveryCost());
						((Customer) user).getOrders().add(order);
					}
				} else {
					System.out.println("This name is already used");
				}

			}
		}
	}

	private void removeFromSpecialOffer(String[] arguments) {
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
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
					System.out.println("No meal named " + arguments[1]);
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
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
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
					System.out.println("No meal named " + arguments[1]);
				} else {
					((Restaurant) user).addMealOfTheWeek(meal);
				}
			}
		}
	}

	private void login(String[] arguments) {
		if (arguments.length > 3) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 3) {
			System.out.println("Too few arguments");
		} else {
			for (User user : foodora.getUserList().values()) {
				if (user.getUsername() == arguments[1] && user.getPassword() == arguments[2]) {
					this.user = user;
				}
			}
			if (this.user == null) {
				System.out.println("Wrong username or password");
			}
		}
	}

	private void logout() {
		if (user == null) {
			System.out.println("Not logged in");
		} else {
			System.out.println("Good bye " + user.getUsername());
			user = null;
		}
	}

	private void registerRestaurant(String[] arguments) {
		if (arguments.length > 5) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 5) {
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
		if (arguments.length > 6) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 6) {
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
		if (arguments.length > 6) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 6) {
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
		if (arguments.length > 5) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 5) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Restaurant)) {
				System.out.println("Permission denied");
			} else {
				if (!arguments[2].equalsIgnoreCase("starter") && !arguments[2].equalsIgnoreCase("main")
						&& !arguments[2].equalsIgnoreCase("dessert")) {
					System.out.println("Wrong dish category");
				} else if (!arguments[3].equalsIgnoreCase("standard") && !arguments[3].equalsIgnoreCase("vegetarian")
						&& !arguments[3].equalsIgnoreCase("gluten-free")) {
					System.out.println("Wrong food type");
				} else {
					Item item = null;
					if (arguments[2].equalsIgnoreCase("starter")) {
						item = new Starter(arguments[1], Double.parseDouble(arguments[4]),
								arguments[3].equalsIgnoreCase("vegetarian"),
								arguments[3].equalsIgnoreCase("gluten-free"));
					} else if (arguments[2].equalsIgnoreCase("main")) {
						item = new MainDish(arguments[1], Double.parseDouble(arguments[4]),
								arguments[3].equalsIgnoreCase("vegetarian"),
								arguments[3].equalsIgnoreCase("gluten-free"));
					} else {
						item = new Dessert(arguments[1], Double.parseDouble(arguments[4]),
								arguments[3].equalsIgnoreCase("vegetarian"),
								arguments[3].equalsIgnoreCase("gluten-free"));
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
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
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
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
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
					System.out.println("No meal named " + arguments[1]);
				} else {
					System.out.println(meal.toString());
				}
			}
		}
	}

	private void addDish2Meal(String[] arguments) {
		if (arguments.length > 3) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 3) {
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
					System.out.println("No meal named " + arguments[2]);
				} else {
					Item item = null;
					for (Item itemiter : ((Restaurant) user).getMenu().getItems()) {
						if (itemiter.getName().equals(arguments[1])) {
							item = itemiter;
						}
					}
					if (item == null) {
						System.out.println("No dish named " + arguments[1]);
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

	private void showMenuItem(String[] arguments) {
		if (arguments.length > 2) {
			System.out.println("Too many arguments");
		} else if (arguments.length < 2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Manager)) {
				System.out.println("Permission denied");
			} else {
				Restaurant restaurant = null;
				for (Restaurant restaurantiter : foodora.getRestaurantList()) {
					if (restaurantiter.getName().equals(arguments[1])) {
						restaurant = restaurantiter;
					}
				}
				if (restaurant == null) {
					System.out.println("No restaurant named " + arguments[1]);
				} else {
					for (Meal meal : restaurant.getMenu().getMeals()) {
						System.out.println(meal.toString());
					}
					for (Item item : restaurant.getMenu().getItems()) {
						System.out.println(item.toString());
					}
				}
			}
		}
	}

	private void showTotalProfit(String[] arguments) {
		if (arguments.length > 3) {
			System.out.println("Too many arguments");
		} else if (arguments.length == 2) {
			System.out.println("Too few arguments");
		} else {
			if (!(user instanceof Manager)) {
				System.out.println("Permission denied");
			} else {
				if (arguments.length == 1) {
					System.out.println("Total profit : " + foodora.computeTotalProfit() + " €");
				} else {
					String beginDate = arguments[1];
					String endDate = arguments[2];
					// TODO gérer le temps
					if (beginDate.matches("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{1,}$")
							&& endDate.matches("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{1,}$")) {
						Time begin = new Time(beginDate);
						Time end = new Time(endDate);
						System.out.println("Total profit : " + foodora.computeTotalProfit(begin, end) + " €");
					} else {
						System.out.println("Incorrect date format, please use day/month/year (example : 08/07/2017)");
					}
				}
			}
		}
	}

	private void runTest(String[] arguments) {
		// TODO Auto-generated method stub

	}

	private void help() {
		// Depending on the user, Help propose differents commands
		System.out.println("Help menu :");
		if (user == null) {
			// If user has not logged in
			System.out.println("login <username> <password> : to login");
			System.out.println("register <> : to register as a customer or courier");
		} else if (!(user instanceof Customer)) {
			// If user is Customer
			System.out.println("createOrder <restaurantName> <orderName> : to create an order from a given restaurant");
			System.out.println(
					"addItem2Order <orderName> <itemName> : to add an item (either a menu item or a meal-deal) to an existing order");
			System.out.println("endOrder <orderName> < date> : to finalise an order at a given date and pay it");
		} else if (!(user instanceof Manager)) {
			// If user is Manager
			System.out.println(
					"registerRestaurant <name> <address> <username> <password> : to add a restaurant of given name, address (i.e. address should be a bi-dimensional co-ordinate), username and password to the system.");
			System.out.println(
					"registerCustomer <firstName> <lastName> <username> <address> <password> : to add a client to the system");
			System.out.println(
					"registerCourier <firstName> <lastName> <username> <position> <password> : to add a courier to the system (by default each newly registered courier is on-duty).");
			System.out.println(
					"setDeliveryPolicy <delPolicyName> : to set the delivery policy of the system to that passed as argument");
			System.out.println(
					"setProfitPolicy <ProfitPolicyName> : to set the profit policy of the system to that passed as argument");
			System.out.println(
					"associateCard <userName> <cardType> : to associate a fidelity card to a user with given name");
			System.out.println(
					"showCourierDeliveries <> : to display the list of couriers sorted in decreasing order w.r.t. the number of completed deliveries");
			System.out.println(
					"showRestaurantTop <> : to display the list of restaurant sorted in decreasing order w.r.t. the number of delivered orders");
			System.out.println("showCustomers <> : to display the list of customers");
			System.out.println("showMenuItem <restaurant-name> : to display the menu of a given restaurant");
			System.out.println("showTotalProfit<> : to show the total profit of the system since creation");
			System.out.println(
					"showTotalProfit <startDate> <endDate> : to show the total profit of the system within a time interval");
		} else if (!(user instanceof Courier)) {
			// If user is Courier
			System.out.println("onDuty <username> : to set your state as on-duty");
			System.out.println("offDuty <username> : to set your state as off-duty");
		} else if (!(user instanceof Restaurant)) {
			// If user is Restaurant
			System.out.println(
					"addDishRestauarantMenu <dishName> <dishCategory> <foodCategory> <unitPrice> : to add a dish with given name, given category (starter,main,dessert), food type (standard,vegetarian, gluten-free) and price to the menu of a restaurant with given name");
			System.out.println("createMeal <mealName> : to create a meal with a given name");
			System.out.println("addDish2Meal <dishName> <mealName> : to add a dish to a meal");
			System.out.println("showMeal <mealName> : to show the dishes in a meal with given name");
			System.out.println("saveMeal <mealName> : to save a meal with given name");
			System.out.println("setSpecialOffer <mealName> : to add a meal in meal-of-the-week special offer");
			System.out.println("removeFromSpecialOffer <mealName> : to reset a special offer");
			System.out.println(
					"findDeliverer <orderName> : to allocate an order to a deliverer by application of the current delivery policy");
		}
		// For any users
		System.out.println(
				"runTest <testScenario-file> : to execute the list of CLUI commands contained in the testScenario file passed as argument");
		System.out.println("logout <> : to logout");
		System.out.println("quit <> : to quit");
		System.out.println("help <> : For help");
	}

	private boolean quit() {
		// To quit the interface
		System.out.println("Are you sure you want to quit ? (Y/n)");
		String answer = this.askFor(new String[] { "y", "Y", "n", "" });
		if (answer == "n") {
			return true;
		}
		logout();
		return false;

	}

	private void register() {
		// To register as a courrier or as a customer
		if (user == null) {
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
			System.out.println("Enter address X (double):");
			String input = sc.nextLine();
			while (!input.matches("^-?[0-9]+(.)?([0-9])*$")) {
				Interpreter.incorrect();
				input = sc.nextLine();
			}
			addressX = Double.parseDouble(input);
			System.out.println("Enter address Y (double):");
			input = sc.nextLine();
			while (!input.matches("^-?[0-9]+(.)?([0-9])*$")) {
				Interpreter.incorrect();
				input = sc.nextLine();
			}
			addressY = Double.parseDouble(input);
			int type;
			User c;
			System.out.println("Enter type of user : (1/2)");
			System.out.println("1 - Customer");
			System.out.println("2 - Courier");
			input = sc.nextLine();
			while (!input.matches("^[1-2]$")) {
				Interpreter.incorrect();
				input = sc.nextLine();
			}
			type = Integer.parseInt(input);
			if (type == 1) {
				c = (Customer) new Customer(name, surname, username, addressX, addressY);
			} else {
				c = (Courier) new Courier(name, surname, username, addressX, addressY);
			}
			foodora.addUser(c);
			System.out.println("You have been registered.");
			// 3. the user starts inserting a contact info with the type and
			// the
			// value (e.g. email, phone)
			// • the user repeats step 3 since he ends to inserts his
			// contact
			// info
			int contact;
			do {
				System.out.println("Inserting contact info : (1/2/3)");
				System.out.println("1 - email");
				System.out.println("2 - phone");
				System.out.println("3 - stop");
				input = sc.nextLine();
				while (!input.matches("^[1-3]$")) {
					Interpreter.incorrect();
					input = sc.nextLine();
				}
				contact = Integer.parseInt(input);
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
				String answer;
				System.out.println("Do you want to be informed of special offers ? (y/N)");
				input = sc.nextLine();
				while (!input.matches("^(y|Y|n|N)?$")) {
					Interpreter.incorrect();
					input = sc.nextLine();
				}
				answer = input;
				if (answer.equalsIgnoreCase("y")) {
					System.out.println("You will be informed of special offers");
					((Customer) c).register();
				}
			}
			// 5. the user is a customer selects the contact to be used to
			// send
			// the
			// offers (by default it
			// is the e-mail if exists)
			if (c instanceof Customer) {
				int answer;
				System.out.println("Select contact method for offers : (1/2)");
				System.out.println("1 - email (default)");
				System.out.println("2 - phone number");
				input = sc.nextLine();
				while (!input.matches("^[1-2]?$")) {
					Interpreter.incorrect();
					input = sc.nextLine();
				}
				answer = Integer.parseInt(input);
				if (answer == 2) {
					System.out.println("You will be notified by phone.");
					((Customer) c).setNotifyMean(c.getPhoneNumber());
				} else {
					System.out.println("You will be notified by Email.");
					((Customer) c).setNotifyMean(c.getEmail());
				}
			}

			// 6. if the user is a courier he sets his current duty status
			// (default
			// off-duty)

			if (c instanceof Courier) {
				String answer;
				System.out.println("Do you want to be seen as on-duty ? (y/N)");
				input = sc.nextLine();
				while (!input.matches("^(y|Y|n|N)?$")) {
					Interpreter.incorrect();
					input = sc.nextLine();
				}
				answer = input;
				if (answer.equalsIgnoreCase("y")) {
					System.out.println("You are seen on-duty.");
					((Courier) c).setOnDuty(true);
				} else {
					System.out.println("You are seen off-duty.");
					((Courier) c).setOnDuty(false);
				}
			}

			// 7. the user specify to save the account

			String answer;
			System.out.println("Do you wish to save your account ? (Y/n)");
			input = sc.nextLine();
			while (!input.matches("^(y|Y|n|N)?$")) {
				Interpreter.incorrect();
				input = sc.nextLine();
			}
			answer = input;
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("You have been unregistered");
				foodora.removeUser(c);
			} else {
				System.out.println("You have been registered.");
			}
		}
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
			this.logout();
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
			this.setDeliveryPolicy(arguments);
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
			this.showMenuItem(arguments);
			break;
		case "showTotalProfit":
			this.showTotalProfit(arguments);
			break;
		case "runTest":
			this.runTest(arguments);
			break;
		case "help":
			this.help();
			break;
		case "register":
			this.register();
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