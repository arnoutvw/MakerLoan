package administration;

import java.util.ArrayList;
import java.util.List;

public class Department {
	// Fields
	private String name;
	private String code;
	private static List<Department> departments = new ArrayList<>();
	
	// Constructors
	public Department(String name, String code) {
		this.name = name;
		this.code = code;
		departments.add(this);
	}
	
	public Department(Department department) {
		this(department.getName(), department.getCode());
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}
	
	public static List<Department> getDepartments() {
		return departments;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	// Methods
	@Override
	public String toString() {
		return String.format("%2$s: %1$s",
				name,
				code);
	}
	
}
