package no.hiof.itstud.krdehli.makerloan.gui2;

import java.awt.FlowLayout;

import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DropdownInputField<T> extends JPanel implements InputField<T> {

	private static final long serialVersionUID = 1L;

	private String name;
	private JLabel label;
	private ComboBoxModel<T> comboBoxModel;
	private JComboBox<T> comboBox;
	private boolean autoClear;

	public DropdownInputField(String name, ComboBoxModel<T> comboBoxModel) {
		super(new FlowLayout());

		this.name = name;
		label = new JLabel(name);
		this.comboBoxModel = comboBoxModel;
		comboBox = new JComboBox<>(comboBoxModel);
		autoClear = false;

		add(label);
		add(comboBox);
	}

	public void setModel(ComboBoxModel<T> comboBoxModel) {
		this.comboBoxModel = comboBoxModel;
	}

	public ComboBoxModel<T> getModel() {
		return comboBoxModel;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public T getValue() {
		T value = comboBoxModel.getElementAt(comboBox.getSelectedIndex());
		if (autoClear) {
			clear();
		}
		return value;
	}

	@Override
	public void clear() {
		comboBox.setSelectedIndex(-1);

	}

	@Override
	public void setAutoClear(boolean bool) {
		autoClear = bool;

	}

	@Override
	public boolean getAutoClear() {
		return autoClear;
	}

}
