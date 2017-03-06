package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import administration.Course;
import administration.Department;
import administration.GradedCourse;
import administration.UngradedCourse;
import hr.AcademicEmployee;
import hr.AdminEmployee;
import hr.Person;
import hr.Student;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	// Constants
	private static final String DEPARTMENT = "Department";
	private static final String COURSE = "Course";
	private static final String STUDENT = "Student";
	private static final String EMPLOYEE = "Employee";
	
	private static final String[] CATEGORIES = {
			DEPARTMENT,
			COURSE,
			STUDENT,
			EMPLOYEE
	};
	
	private DepartmentComboBoxModel departmentComboBoxModel = new DepartmentComboBoxModel();
	private DepartmentListModel departmentListModel = new DepartmentListModel();
	private CourseListModel courseListModel = new CourseListModel();
	private PersonListModel personListModel = new PersonListModel();
	
	private JPanel contentPane;
	private JTextField txtDepartmentName;
	private JTextField txtDepartmentCode;
	private JTextField txtCourseName;
	private JTextField txtCourseID;
	private JPanel cardPanel;
	private final ButtonGroup btngrpCourseType = new ButtonGroup();
	private JTextField txtStudentName;
	private JTextField txtStudentSurname;
	private JTextField txtStudentPhone;
	private JTextField txtEmployeeName;
	private JTextField txtEmployeeSurname;
	private JTextField txtEmployeePhone;
	private JList<Department> departmentList;
	private JList<Course> courseList;
	private JList<Person> personList;
	private final ButtonGroup btngrpEmployeeType = new ButtonGroup();
	private JComboBox<Department> lstCourseDepartment;
	private JComboBox<Department> lstStudentDepartment;
	private JList<Course> lstStudentCourses;
	private JComboBox<Department> lstEmployeeDepartment;
	private JRadioButton rdbtnGraded;
	private JRadioButton rdbtnUngraded;
	private JRadioButton rdbtnAdmin;
	private JRadioButton rdbtnAcademic;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setResizable(false);
		setTitle("MakerLoan WIP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setResizeWeight(0.5);
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JPanel creationPanel = new JPanel();
		splitPane.setLeftComponent(creationPanel);
		creationPanel.setLayout(null);
		
		JLabel lblCreate = new JLabel("Create");
		lblCreate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreate.setBounds(12, 13, 56, 16);
		creationPanel.add(lblCreate);
		
		JComboBox<String> lstCardSelector = new JComboBox<String>();
		lstCardSelector.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evt) {
				String item = (String)evt.getItem();
				CardLayout cl = (CardLayout)cardPanel.getLayout();
				cl.show(cardPanel, item);
			}
		});
		lstCardSelector.setModel(new DefaultComboBoxModel<String>(CATEGORIES));
		lstCardSelector.setSelectedIndex(0);
		lstCardSelector.setBounds(12, 42, 314, 22);
		creationPanel.add(lstCardSelector);
		
		cardPanel = new JPanel();
		cardPanel.setBounds(12, 77, 314, 323);
		creationPanel.add(cardPanel);
		cardPanel.setLayout(new CardLayout(0, 0));
		
		JPanel departmentPanel = new JPanel();
		cardPanel.add(departmentPanel, DEPARTMENT);
		departmentPanel.setLayout(null);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setLabelFor(departmentPanel);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDepartment.setBounds(12, 13, 244, 16);
		departmentPanel.add(lblDepartment);
		
		JButton btnCreateDepartment = new JButton("Create");
		btnCreateDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name = txtDepartmentName.getText().trim();
					String code = txtDepartmentCode.getText().trim();
					
					if (name.equals("") || code.equals("")) {
						throw new RuntimeException("Fields cannot be empty!");
					}
					new Department(name, code);
					
					departmentListModel.fireExternalElementAdded();;
					
					lstCourseDepartment.setSelectedIndex(-1);
					lstStudentDepartment.setSelectedIndex(-1);
					lstEmployeeDepartment.setSelectedIndex(-1);
					
					txtDepartmentName.setText("");
					txtDepartmentCode.setText("");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
				}
			}
		});
		btnCreateDepartment.setBounds(12, 285, 97, 25);
		departmentPanel.add(btnCreateDepartment);
		
		JLabel lblDepartmentName = new JLabel("Name");
		lblDepartmentName.setBounds(12, 42, 102, 16);
		departmentPanel.add(lblDepartmentName);
		
		txtDepartmentName = new JTextField();
		lblDepartmentName.setLabelFor(txtDepartmentName);
		txtDepartmentName.setBounds(126, 39, 176, 22);
		departmentPanel.add(txtDepartmentName);
		txtDepartmentName.setColumns(10);
		
		JLabel lblDepartmentCode = new JLabel("Code");
		lblDepartmentCode.setBounds(12, 77, 102, 16);
		departmentPanel.add(lblDepartmentCode);
		
		txtDepartmentCode = new JTextField();
		lblDepartmentCode.setLabelFor(txtDepartmentCode);
		txtDepartmentCode.setBounds(126, 74, 176, 22);
		departmentPanel.add(txtDepartmentCode);
		txtDepartmentCode.setColumns(10);
		
		JPanel coursePanel = new JPanel();
		cardPanel.add(coursePanel, COURSE);
		coursePanel.setLayout(null);
		
		JLabel lblCourse = new JLabel("Course");
		lblCourse.setLabelFor(coursePanel);
		lblCourse.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCourse.setBounds(12, 13, 244, 16);
		coursePanel.add(lblCourse);
		
		JButton btnCreateCourse = new JButton("Create");
		btnCreateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = txtCourseName.getText().trim();
					String id = txtCourseID.getText().trim();
					Department department = (Department)lstCourseDepartment.getSelectedItem();
					
					if (name.equals("") || id.equals("") || lstCourseDepartment.getSelectedIndex() == -1) {
						throw new RuntimeException("Fields cannot be empty!");
					}
					if (rdbtnGraded.isSelected()) {
						new GradedCourse(name, id, department);
					} else if (rdbtnUngraded.isSelected()){
						new UngradedCourse(name, id, department);
					}
					courseListModel.fireExternalElementAdded();;
					txtCourseName.setText("");
					txtCourseID.setText("");
					lstCourseDepartment.setSelectedIndex(-1);
					rdbtnGraded.setSelected(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
				}
			}
		});
		btnCreateCourse.setBounds(12, 285, 97, 25);
		coursePanel.add(btnCreateCourse);
		
		JLabel lblCourseName = new JLabel("Name");
		lblCourseName.setBounds(12, 42, 97, 16);
		coursePanel.add(lblCourseName);
		
		txtCourseName = new JTextField();
		txtCourseName.setBounds(126, 39, 176, 22);
		coursePanel.add(txtCourseName);
		txtCourseName.setColumns(10);
		
		JLabel lblCourseID = new JLabel("CourseID");
		lblCourseID.setBounds(12, 77, 97, 16);
		coursePanel.add(lblCourseID);
		
		txtCourseID = new JTextField();
		txtCourseID.setBounds(126, 74, 176, 22);
		coursePanel.add(txtCourseID);
		txtCourseID.setColumns(10);
		
		JLabel lblCourseDepartment = new JLabel("Department");
		lblCourseDepartment.setBounds(12, 112, 102, 16);
		coursePanel.add(lblCourseDepartment);
		
		lstCourseDepartment = new JComboBox<>();
		lstCourseDepartment.setModel(departmentComboBoxModel);
		lstCourseDepartment.setBounds(126, 109, 176, 22);
		coursePanel.add(lstCourseDepartment);
		
		JLabel lblCourseType = new JLabel("Type");
		lblCourseType.setBounds(12, 144, 56, 16);
		coursePanel.add(lblCourseType);
		
		rdbtnUngraded = new JRadioButton("Ungraded");
		btngrpCourseType.add(rdbtnUngraded);
		rdbtnUngraded.setBounds(211, 140, 91, 25);
		coursePanel.add(rdbtnUngraded);
		
		rdbtnGraded = new JRadioButton("Graded");
		rdbtnGraded.setSelected(true);
		btngrpCourseType.add(rdbtnGraded);
		rdbtnGraded.setBounds(126, 140, 83, 25);
		coursePanel.add(rdbtnGraded);
		
		JPanel studentPanel = new JPanel();
		cardPanel.add(studentPanel, STUDENT);
		studentPanel.setLayout(null);
		
		JLabel lblStudent = new JLabel("Student");
		lblStudent.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStudent.setBounds(12, 13, 244, 16);
		studentPanel.add(lblStudent);
		
		JButton btnCreateStudent = new JButton("Create");
		btnCreateStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String name = txtStudentName.getText().trim();
					String surname = txtStudentSurname.getText().trim();
					String phone = txtStudentPhone.getText().trim();
					Department department = (Department)lstStudentDepartment.getSelectedItem();
					List<Course> courses = lstStudentCourses.getSelectedValuesList();
					
					if (name.equals("") || surname.equals("") || phone.equals("") || lstStudentDepartment.getSelectedIndex() == -1) {
						throw new RuntimeException("Fields cannot be empty!");
					}
					
					new Student(name, surname, phone, department, courses);
					
					personListModel.fireExternalElementAdded();
					txtStudentName.setText("");
					txtStudentSurname.setText("");
					txtStudentPhone.setText("");
					lstStudentDepartment.setSelectedIndex(-1);
					lstStudentCourses.clearSelection();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
				}
			}
		});
		btnCreateStudent.setBounds(12, 285, 97, 25);
		studentPanel.add(btnCreateStudent);
		
		JLabel lblStudentName = new JLabel("Name");
		lblStudentName.setBounds(12, 45, 92, 16);
		studentPanel.add(lblStudentName);
		
		txtStudentName = new JTextField();
		txtStudentName.setBounds(126, 42, 176, 22);
		studentPanel.add(txtStudentName);
		txtStudentName.setColumns(10);
		
		JLabel lblStudentSurname = new JLabel("Surname");
		lblStudentSurname.setBounds(12, 80, 97, 16);
		studentPanel.add(lblStudentSurname);
		
		txtStudentSurname = new JTextField();
		txtStudentSurname.setBounds(126, 77, 176, 22);
		studentPanel.add(txtStudentSurname);
		txtStudentSurname.setColumns(10);
		
		JLabel lblStudentPhone = new JLabel("Phone");
		lblStudentPhone.setBounds(12, 113, 102, 16);
		studentPanel.add(lblStudentPhone);
		
		txtStudentPhone = new JTextField();
		txtStudentPhone.setBounds(126, 110, 176, 22);
		studentPanel.add(txtStudentPhone);
		txtStudentPhone.setColumns(10);
		
		JLabel lblStudentDepartment = new JLabel("Department");
		lblStudentDepartment.setBounds(12, 148, 102, 16);
		studentPanel.add(lblStudentDepartment);
		
		lstStudentDepartment = new JComboBox<>();
		lstStudentDepartment.setModel(departmentComboBoxModel);
		lstStudentDepartment.setBounds(126, 148, 176, 22);
		studentPanel.add(lstStudentDepartment);
		
		JLabel lblStudentCourses = new JLabel("Courses");
		lblStudentCourses.setBounds(12, 185, 102, 16);
		studentPanel.add(lblStudentCourses);
		
		JScrollPane scrStudentCourses = new JScrollPane();
		scrStudentCourses.setBounds(126, 183, 176, 90);
		studentPanel.add(scrStudentCourses);
		
		lstStudentCourses = new JList<>();
		lstStudentCourses.setModel(courseListModel);
		scrStudentCourses.setViewportView(lstStudentCourses);
		
		JPanel employeePanel = new JPanel();
		cardPanel.add(employeePanel, EMPLOYEE);
		employeePanel.setLayout(null);
		
		JLabel lblEmployee = new JLabel("Employee");
		lblEmployee.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployee.setBounds(12, 13, 244, 16);
		employeePanel.add(lblEmployee);
		
		JButton btnCreateEmployee = new JButton("Create");
		btnCreateEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = txtEmployeeName.getText().trim();
					String surname = txtEmployeeSurname.getText().trim();
					String phone = txtEmployeePhone.getText().trim();
					Department department = (Department)lstEmployeeDepartment.getSelectedItem();
					
					if (name.equals("") || surname.equals("") || phone.equals("") || lstEmployeeDepartment.getSelectedIndex() == -1) {
						throw new RuntimeException("Fields cannot be empty!");
					}
					
					if (rdbtnAcademic.isSelected()) {
						new AcademicEmployee(name, surname, phone, department);
					} else if (rdbtnAdmin.isSelected()) {
						new AdminEmployee(name, surname, phone, department);
					}
					personListModel.fireExternalElementAdded();
					txtEmployeeName.setText("");
					txtEmployeeSurname.setText("");
					txtEmployeePhone.setText("");
					lstEmployeeDepartment.setSelectedIndex(-1);
					rdbtnAdmin.setSelected(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
				}
			}
		});
		btnCreateEmployee.setBounds(12, 285, 97, 25);
		employeePanel.add(btnCreateEmployee);
		
		JLabel lblEmployeeName = new JLabel("Name");
		lblEmployeeName.setBounds(12, 42, 102, 16);
		employeePanel.add(lblEmployeeName);
		
		txtEmployeeName = new JTextField();
		txtEmployeeName.setBounds(126, 39, 176, 22);
		employeePanel.add(txtEmployeeName);
		txtEmployeeName.setColumns(10);
		
		JLabel lblEmployeeSurname = new JLabel("Surname");
		lblEmployeeSurname.setBounds(12, 77, 102, 16);
		employeePanel.add(lblEmployeeSurname);
		
		txtEmployeeSurname = new JTextField();
		txtEmployeeSurname.setBounds(126, 74, 176, 22);
		employeePanel.add(txtEmployeeSurname);
		txtEmployeeSurname.setColumns(10);
		
		JLabel lblEmployeePhone = new JLabel("Phone");
		lblEmployeePhone.setBounds(12, 112, 102, 16);
		employeePanel.add(lblEmployeePhone);
		
		txtEmployeePhone = new JTextField();
		txtEmployeePhone.setBounds(126, 109, 176, 22);
		employeePanel.add(txtEmployeePhone);
		txtEmployeePhone.setColumns(10);
		
		JLabel lblEmployeeDepartment = new JLabel("Department");
		lblEmployeeDepartment.setBounds(12, 147, 102, 16);
		employeePanel.add(lblEmployeeDepartment);
		
		lstEmployeeDepartment = new JComboBox<>();
		lstEmployeeDepartment.setModel(departmentComboBoxModel);
		lstEmployeeDepartment.setBounds(126, 144, 176, 22);
		employeePanel.add(lstEmployeeDepartment);
		
		JLabel lblEmployeeType = new JLabel("Type");
		lblEmployeeType.setBounds(12, 179, 102, 16);
		employeePanel.add(lblEmployeeType);
		
		rdbtnAcademic = new JRadioButton("Academic");
		btngrpEmployeeType.add(rdbtnAcademic);
		rdbtnAcademic.setBounds(205, 175, 97, 25);
		employeePanel.add(rdbtnAcademic);
		
		rdbtnAdmin = new JRadioButton("Admin");
		btngrpEmployeeType.add(rdbtnAdmin);
		rdbtnAdmin.setSelected(true);
		rdbtnAdmin.setBounds(126, 175, 75, 25);
		employeePanel.add(rdbtnAdmin);
		
		JPanel viewingPanel = new JPanel();
		splitPane.setRightComponent(viewingPanel);
		viewingPanel.setLayout(null);
		
		JLabel lblView = new JLabel("View");
		lblView.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblView.setBounds(12, 13, 56, 16);
		viewingPanel.add(lblView);
		
		JTabbedPane tabpaneLists = new JTabbedPane(JTabbedPane.TOP);
		tabpaneLists.setBounds(22, 42, 305, 358);
		viewingPanel.add(tabpaneLists);
		
		JScrollPane departmentListPane = new JScrollPane();
		tabpaneLists.addTab("Departments", null, departmentListPane, null);
		
		departmentList = new JList<>();
		departmentList.setModel(departmentListModel);
		departmentListPane.setViewportView(departmentList);
		
		JScrollPane courseListPane = new JScrollPane();
		tabpaneLists.addTab("Courses", null, courseListPane, null);
		
		courseList = new JList<Course>();
		courseList.setModel(courseListModel);
		courseListPane.setViewportView(courseList);
		
		JScrollPane personListPane = new JScrollPane();
		tabpaneLists.addTab("People", null, personListPane, null);
		
		personList = new JList<Person>();
		personList.setModel(personListModel);
		personListPane.setViewportView(personList);
	}
}
