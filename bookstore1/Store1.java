package bookstore1; 

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import bookstore_test.Book;
public class Store1 {
	Scanner key = new Scanner(System.in);
	Vector listItems = new Vector();
int totalItems = 0;

public Store1() {
	int i=1;
	while(i==1) {
		System.out.println("========BOOKMANAGER========");
		System.out.println("1. Add book");
		System.out.println("2. Edit book");
		System.out.println("3. Delete book");
		System.out.println("4. Find book");
		System.out.println("5. List book");
		System.out.println("6. Sort book");
		System.out.println("7. Exit");
		System.out.println("You choise [1-7]");

	Scanner key = new Scanner(System.in);
	int num = key.nextInt();
	switch(num) {
		case 1:
			addBook();
			break;
		case 2:
			editBook();
			break;
		case 3:
			deleteBook();
			break;
		case 4:
			findBook();
			break;
		case 5:
			listBook();
			break;
		case 6:
			sortBook();
			break;
		case 7:
			System.out.println("=====Exit=====");
			return;
	}
}
}
public void addBook() {
	int num;
	System.out.println("=====Add book=====");
	System.out.println();
	System.out.println("Amount of book to enter: ");
	
	num = Integer.parseInt(key.nextLine());
	for(int i=1;i<=num;i++) {
		System.out.println("ID: ");
		int id = Integer.parseInt(key.nextLine());
		System.out.println("Name: ");
		String name = String.valueOf(key.nextLine());
		System.out.println("Price: ");
		double price = Double.parseDouble(key.nextLine());
		System.out.println();
		Book1 book1 = new Book1(id,name,price);
		listItems.add(book1);
		totalItems++;
	}
	System.out.println("Add successfull!");
}
public void editBook() {
	System.out.println("=====Edit book=====");
	System.out.println();
	System.out.println("Book name to edit: ");
	String bookname = String.valueOf(key.nextLine());
	System.out.println("Book info: ");
	int t=0;
	for(int i=0;i<totalItems;i++) {
		Book1 book1 = (Book1)listItems.get(i);
		if(book1.getName().indexOf(bookname)!=-1) {
//		System.out.println("ID: "+book1.getId());
//		System.out.println("Name: "+book1.getName());
//		System.out.println("Price: "+book1.getPrice());
//		System.out.println();
			book1.getshowInfo();
			 t=i;
		    }
	}
//	System.out.println(t);
	System.out.println("Edit information: ");
	System.out.println("ID: ");
	int id = Integer.parseInt(key.nextLine());
	System.out.println("Name: ");
	String name = String.valueOf(key.nextLine());
	System.out.println("Price: ");
	double price = Double.parseDouble(key.nextLine());
	Book1 book1 = (Book1)listItems.get(t);
	book1.setId(id);
	book1.setName(name);
	book1.setPrice(price);
}
public void deleteBook() {
	System.out.println("=====Delete book=====");
	System.out.println();
	System.out.println("Book name to delete:");
	String bookname = String.valueOf(key.nextLine());
	int t = 0;
	for(int i=0;i<totalItems;i++) {
		Book1 book1 = (Book1)listItems.get(i);
		if(book1.getName().indexOf(bookname)!=-1) {
			t=i;
			totalItems--;
		}
	}
	listItems.remove(t);
}
public void findBook() {
	System.out.println("=====Find book=====");
	System.out.println();
	System.out.println("Book name to find: ");
//	key.nextLine();
	String name = String.valueOf(key.nextLine());
	
	for(int i=0;i<totalItems;i++) {
		Book1 book1 = (Book1)listItems.get(i);
		if(book1.getName().indexOf(name)!=-1) {
//		System.out.println("ID: "+book1.getId());
//		System.out.println("Name: "+book1.getName());
//		System.out.println("Price: "+book1.getPrice());
			System.out.println("Book info: ");
			book1.getshowInfo();
		}
}
}
public void listBook() {
	System.out.println("=====List Book=====");
	System.out.println("Book Info");
	for(int i=0;i<totalItems;i++) {

		Book1 book1 = (Book1)listItems.get(i);
//		System.out.println("ID: "+book1.getId());
//		System.out.println("Name: "+book1.getName());
//		System.out.println("Price: "+book1.getPrice());
//		System.out.println();
		book1.getshowInfo();
		
	}
}
public void sortBook() {
	Book1 book1[] = new Book1[totalItems];
	for(int i=0;i<totalItems;i++) {
		book1[i] = (Book1) this.listItems.get(i);
	}
	Arrays.sort(book1);
	Book1 temp;
	for(int i=0;i<totalItems;i++) {
		temp = (Book1)book1[i];
		temp.getshowInfo();
	}
}
public static void main(String[]args) {
	new Store1();
}
}











