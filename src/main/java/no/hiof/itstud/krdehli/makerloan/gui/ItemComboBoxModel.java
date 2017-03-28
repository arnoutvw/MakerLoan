package no.hiof.itstud.krdehli.makerloan.gui;

import javax.swing.DefaultComboBoxModel;

import no.hiof.itstud.krdehli.makerloan.inventory.Item;

@SuppressWarnings("serial")
public class ItemComboBoxModel extends DefaultComboBoxModel<Item> {
	
	@Override
	public Item getElementAt(int index) {
		return Item.getItems().get(index);
	}
	
	@Override
	public int getSize() {
		return Item.getItems().size();
	}

	public void fireExternalElementAdded() {
		fireIntervalAdded(this, this.getSize() - 1, this.getSize());
	}
}
