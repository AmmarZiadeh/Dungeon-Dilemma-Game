package common;

public class Shop {
	
	private String name;
	private int price;
	
	public Shop(int item) {
		
		if(item == 1) {
			name = "sword";
		} else if(item == 2) {
			name = "bow";
		} else if(item == 3) {
			name = "staff";
		}
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
}
