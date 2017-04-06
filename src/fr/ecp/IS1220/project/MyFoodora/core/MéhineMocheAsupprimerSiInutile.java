package fr.ecp.IS1220.project.MyFoodora.core;

import java.util.ArrayList;

import fr.ecp.IS1220.project.MyFoodora.core.menu.Dessert;

public class MéhineMocheAsupprimerSiInutile {
	public static void main(String[] args) {
		ArrayList<Double> ChezMichel = new ArrayList<Double>();
		ChezMichel.add((double) 15);
		ChezMichel.add((double) 15);
		Customer michel = new Customer("Michel", "Delatour", "Michou", ChezMichel, "michou@michou.fr", "0678910111");
		Customer jeanne = new Customer("Jeanne", "D'arc", "Jaja", ChezMichel, "jaja@aufeu.fr", "0666666666");
		System.out.println(michel.getiD());
		System.out.println(michel.toString());
		System.out.println(michel.getPrice());
		System.out.println(michel.getAddress());
		System.out.println(jeanne.getiD());
		System.out.println(jeanne.toString());
		System.out.println(jeanne.getPrice());
		Dessert chocobon = new Dessert("Chocobon", 15, true, false);
		//jeanne.visit(chocobon);
		System.out.println(jeanne.getPrice());

	}
}
