package inventory;

import java.util.GregorianCalendar;

import hr.Person;

public class Loan {
	// Fields
	private Item item;
	private Person person;
	private GregorianCalendar loanDate;
	
	// Constructors
	public Loan(Item item, Person person, GregorianCalendar loanDate) {
		this.item = item;
		this.person = person;
		this.loanDate = loanDate;
	}
	
	public Loan(Loan loan) {
		item = loan.getItem();
		person = loan.getPerson();
		loanDate = loan.getLoanDate();
	}

	// Getters
	public Item getItem() {
		return item;
	}

	public Person getPerson() {
		return person;
	}

	public GregorianCalendar getLoanDate() {
		return loanDate;
	}

	// Setters
	public void setItem(Item item) {
		this.item = item;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setLoanDate(GregorianCalendar loanDate) {
		this.loanDate = loanDate;
	}
	
	// Methods
	@Override
	public String toString() {
		return String.format("%1$s[item=%2$s, person=%3$s, loanDate=%4$s]",
				getClass().getSimpleName(),
				item.getName(),
				person.getFullName(),
				loanDate.getTime().toString());
	}
}
