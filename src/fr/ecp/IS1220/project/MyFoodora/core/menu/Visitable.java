package fr.ecp.IS1220.project.MyFoodora.core.menu;

import fr.ecp.IS1220.project.MyFoodora.core.Customer;
import fr.ecp.IS1220.project.MyFoodora.core.User;

public interface Visitable {
	void accept(Customer u);
	double getPrice();

}
