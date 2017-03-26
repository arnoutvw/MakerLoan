package inventory;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Item implements Serializable {
	
	private static final long serialVersionUID = 8769912126952741976L;
	
	// Fields
	private String name;
	private int itemID;
	private static int IDIndex = 0;
	private static List<Item> items = new ArrayList<>();
	
	// Constructors
	public Item(String name) {
		this.name = name;
		this.itemID = generateItemID();
		items.add(this);
	}
	
	public Item(Item item) {
		this(item.getName());
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
	private static int generateItemID() {
		return ++IDIndex;
	}
	
	@Override
	public String toString() {
		return String.format("%2$d: %1$s",
				name,
				itemID);
	}

	public static void incrementIDIndex() {
		IDIndex++;
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
		in.defaultReadObject();
		incrementIDIndex();
	}
}
