package no.hiof.itstud.krdehli.makerloan.gui;

import javax.swing.AbstractListModel;

import no.hiof.itstud.krdehli.makerloan.hr.Person;

@SuppressWarnings("serial")
public class PersonListModel extends AbstractListModel<Person> {

	@Override
	public Person getElementAt(int index) {
		return Person.getPersons().get(index);
	}

	@Override
	public int getSize() {
		return Person.getPersons().size();
	}
	
	public void fireExternalElementAdded() {
		fireIntervalAdded(this, getSize() -1, getSize());
	}

}
