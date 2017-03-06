package gui;

import javax.swing.AbstractListModel;

import administration.Course;

@SuppressWarnings("serial")
public class CourseListModel extends AbstractListModel<Course> {

	@Override
	public Course getElementAt(int index) {
		return Course.getCourses().get(index);
	}

	@Override
	public int getSize() {
		return Course.getCourses().size();
	}
	
	public void fireExternalElementAdded() {
		fireIntervalAdded(this, getSize() -1, getSize());
	}
}
