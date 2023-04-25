package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerDao.finById(3);
		System.out.println(seller);
		
		System.out.println("\n==== TEST 2: seller findByDepartment ====");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n==== TEST 3: seller findAll ====");
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		
//		System.out.println("\n==== TEST 4: seller insert ====");
//		Seller newSeller = new Seller(null, "Biel Rosendo", "bielzingedo@gmail.com", new Date(), 1500.00, department);
//		sellerDao.insert(newSeller);
//		System.out.println("Inserted! New id = " + newSeller.getId());
		
		System.out.println("\n==== TEST 5: seller update ====");
		seller = sellerDao.finById(1);
		seller.setName("Maria Joaquina");
		sellerDao.update(seller);
		System.out.println("Update completed!");
		
		System.out.println("\n==== TEST 6: seller delete ====");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}
}
