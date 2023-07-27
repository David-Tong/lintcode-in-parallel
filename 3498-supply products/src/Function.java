
public class Function {
	
	private int products = 0;
	private int products2 = 0;
	private int products3 = 0;
	
	public void placeProduct1() {
		System.out.println("Provider:  Place product1 on table.");
	}
	
	public void placeProduct2() {
		System.out.println("Provider:  Place product2 on table.");
	}
	
	public void placeProduct3() {
		System.out.println("Provider:  Place product3 on table.");
	}
	
	public void takeProduct1() {
		products++;
		System.out.println("Customer1: Take product1.");
	}
	
	public void takeProduct2() {
		products2++;
		System.out.println("Customer2: Take product2.");
	}
	
	public void takeProduct3() {
		products3++;
		System.out.println("Customer3: Take product3.");
	}
	
	public void checking() {
		System.out.println("Customer1 now has " + products + " product(s)");
		System.out.println("Customer2 now has " + products2 + " product(s)");
		System.out.println("Customer3 now has " + products3 + " product(s)");
	}
	
}
