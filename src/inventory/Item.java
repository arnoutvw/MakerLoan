package inventory;

import java.util.ArrayList;
import java.util.List;

public class Item {
	// Fields
	private String name;
	private int itemID;
	private static List<Item> items = new ArrayList<>();
	
	// Constructors
	public Item(String name, int itemID) {
		this.name = name;
		this.itemID = itemID;
		items.add(this);
	}
	
	public Item(Item item) {
		this(item.getName(), item.getItemID());
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getItemID() {
		return itemID;
	}

	public static List<Item> getItems() {
		return items;
	}
	
	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	// Methods
	@Override
	public String toString() {
		return String.format("%1$s[name=%2$s, itemID=%3$d]",
				getClass().getSimpleName(),
				name,
				itemID);
	}
}
