package no.hiof.itstud.krdehli.makerloan.inventory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import no.hiof.itstud.krdehli.makerloan.hr.Person;

public class Loan implements Comparable<Loan>, Serializable {
	
	private static final long serialVersionUID = -8239847370236173562L;
	
	// Fields
	private Item item;
	private Person person;
	private GregorianCalendar loanDate;
	private static List<Loan> loans = new ArrayList<>();
	
	// Constructors
	public Loan(Item item, Person person, GregorianCalendar loanDate) {
		this.item = item;
		this.person = person;
		this.loanDate = loanDate;
		loans.add(this);
	}
	
	public Loan(Item item, Person person) {
		this(item, person, new GregorianCalendar());
	}
	
	public Loan(Loan loan) {
		this(loan.getItem(), loan.getPerson(), loan.getLoanDate());
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
	
	public static List<Loan> getLoans() {
		return loans;
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
		return String.format("[%3$s] Loaned item [%1$s] to [%2$s]",
				item.getName(),
				person.getFullName(),
				loanDate.getTime().toString());
	}

	@Override
	public int compareTo(Loan l) {
		return l.loanDate.compareTo(loanDate);
	}
	
}
