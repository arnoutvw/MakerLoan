package no.hiof.itstud.krdehli.makerloan.gui;

import javax.swing.DefaultComboBoxModel;

import no.hiof.itstud.krdehli.makerloan.hr.Person;

@SuppressWarnings("serial")
public class PersonComboBoxModel extends DefaultComboBoxModel<Person> {
	
	@Override
	public Person getElementAt(int index) {
		return Person.getPersons().get(index);
	}
	
	@Override
	public int getSize() {
		return Person.getPersons().size();
	}

	public void fireExternalElementAdded() {
		fireIntervalAdded(this, this.getSize() - 1, this.getSize());
	}
}
