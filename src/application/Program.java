package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Department obj = new Department(1, "Books");
		System.out.println(obj);
		
		Seller seller = new Seller(10, "Pedro", "pedro@gamil.com", new Date(), 9600.00, obj);
		System.out.println(seller);
	}
}
