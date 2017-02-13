package inventory;

public class Item {
	// Fields
	private String name;
	private int itemID;
	private int amount;
	
	// Constructors
	public Item(String name, int itemID, int amount) {
		this.name = name;
		this.itemID = itemID;
		this.amount = amount;
	}
	
	public Item(Item item) {
		name = item.getName();
		itemID = item.getItemID();
		amount = item.getAmount();
	}

	// Getters
	public String getName() {
		return name;
	}

	public int getItemID() {
		return itemID;
	}

	public int getAmount() {
		return amount;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	// Methods
	@Override
	public String toString() {
		return String.format("%1$s[name=%2$s, itemID=%3$d, amount=%4$d]",
				getClass().getSimpleName(),
				name,
				itemID,
				amount);
	}
}
