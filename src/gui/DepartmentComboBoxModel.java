package gui;

import javax.swing.DefaultComboBoxModel;

import administration.Department;

@SuppressWarnings("serial")
public class DepartmentComboBoxModel extends DefaultComboBoxModel<Department> {
	
	@Override
	public Department getElementAt(int index) {
		return Department.getDepartments().get(index);
	}
	
	@Override
	public int getSize() {
		return Department.getDepartments().size();
	}
	
	public void fireExternalElementAdded() {
		fireIntervalAdded(this, this.getSize() - 1, this.getSize());
	}
}
