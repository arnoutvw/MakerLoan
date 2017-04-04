package no.hiof.itstud.krdehli.makerloan.gui2;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextInputField extends JPanel implements InputField<String> {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private JLabel label;
	private JTextArea textArea;
	private boolean autoClear;
	
	public TextInputField(String name) {
		super(new FlowLayout());
		
		this.name = name;
		label = new JLabel(name);
		textArea = new JTextArea();
		autoClear = false;
		
		add(label);
		add(textArea);
	}
	
	@Override
	public void setAutoClear(boolean bool) {
		autoClear = bool;
	}
	
	@Override
	public boolean getAutoClear() {
		return autoClear;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getValue() {
		String value = textArea.getText();
		if (autoClear) {
			clear();
		}
		return value;
	}

	@Override
	public void clear() {
		textArea.setText("");
	}

}
