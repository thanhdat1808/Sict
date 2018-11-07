package bookstore1;

public class Book1 implements Comparable<Book1> {
private int id;
private String name;
private double price;
public Book1() {
	this.name = new String("");
	this.id = 0;
	this.price = 0;
}
public Book1(int id,String name, double price) {
	this.id = id;
	this.name = name;
	this.price = price;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public void getshowInfo() {
	System.out.println("ID	: "+this.id);
	System.out.println("Name	: "+this.name);
	System.out.println("Price	: "+this.price+"vnd");
	System.out.println();
}

public int compareTo(Book1 arg0) {
	// TODO Auto-generated method stub
	return (int)(this.price-arg0.price);
}

}
