package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST 1: seller findById ====");
		Seller seller = sellerDao.finById(3);
		System.out.println(seller);
<<<<<<< HEAD
		
		System.out.println("\n==== TEST 2: seller findByDepartment ====");
		Department department = new Department(1, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);
		
		System.out.println("\n==== TEST 3: seller findAll ====");
		List<Seller> list2 = sellerDao.findAll();
		list2.forEach(System.out::println);
=======
>>>>>>> parent of 573b5aa (findByDepartment implementation)
	}
}
