package no.hiof.itstud.krdehli.makerloan.gui;

import javax.swing.AbstractListModel;

import no.hiof.itstud.krdehli.makerloan.inventory.Item;

@SuppressWarnings("serial")
public class ItemListModel extends AbstractListModel<Item> {

	@Override
	public Item getElementAt(int index) {
		return Item.getItems().get(index);
	}

	@Override
	public int getSize() {
		return Item.getItems().size();
	}
	
	public void fireExternalElementAdded() {
		fireIntervalAdded(this, getSize() -1, getSize());
	}

}
