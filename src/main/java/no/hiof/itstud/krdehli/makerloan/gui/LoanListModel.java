package no.hiof.itstud.krdehli.makerloan.gui;

import java.util.Collections;
import java.util.Comparator;

import javax.swing.AbstractListModel;

import no.hiof.itstud.krdehli.makerloan.inventory.Loan;

@SuppressWarnings("serial")
public class LoanListModel extends AbstractListModel<Loan> {

	@Override
	public Loan getElementAt(int index) {
		return Loan.getLoans().get(index);
	}

	@Override
	public int getSize() {
		return Loan.getLoans().size();
	}
	
	public void fireExternalElementAdded() {
		fireIntervalAdded(this, getSize() -1, getSize());
	}
	
	public void sort(Comparator<Loan> comparator) {
		Loan.getLoans().sort(comparator);
		fireContentsChanged(this, 0, Loan.getLoans().size());
	}
	
	public void sort() {
		Collections.sort(Loan.getLoans());
		fireContentsChanged(this, 0, Loan.getLoans().size());
	}
	
	public void remove(int index) {
		Loan.getLoans().remove(index);
		fireIntervalRemoved(this, index, index);
	}

}
