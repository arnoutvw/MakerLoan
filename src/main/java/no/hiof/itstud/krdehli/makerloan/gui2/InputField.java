package no.hiof.itstud.krdehli.makerloan.gui2;

public interface InputField<T> {

	String getName();
	T getValue();
	void clear();
	void setAutoClear(boolean bool);
	boolean getAutoClear(); 
}
