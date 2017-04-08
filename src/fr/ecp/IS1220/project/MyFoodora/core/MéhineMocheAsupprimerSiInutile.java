package fr.ecp.IS1220.project.MyFoodora.core;


import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;

public class MéhineMocheAsupprimerSiInutile {
	public static void main(String[] args) {
		Customer michel = new Customer("Michel", "Delatour", "Michou", 15, 15, "michou@michou.fr", "0678910111");
		Customer jeanne = new Customer("Jeanne", "D'arc", "Jaja", 15, 15, "jaja@aufeu.fr", "0666666666");
		System.out.println(michel.getiD());
		System.out.println(michel.toString());
		System.out.println(michel.getPrice());
		System.out.println(michel.getAddressX());
		System.out.println(michel.getAddressY());
		System.out.println(jeanne.getiD());
		System.out.println(jeanne.toString());
		System.out.println(jeanne.getPrice());
		Dessert chocobon = new Dessert("Chocobon", 15, true, false);
		//jeanne.visit(chocobon);
		System.out.println(chocobon.getMenu());

	}
}
