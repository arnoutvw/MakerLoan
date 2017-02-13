package administration;

public class Department {
	// Fields
	private String name;
	private String code;
	
	// Constructors
	public Department(String name, String code) {
		this.name = name;
		this.code = code;
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
		return String.format("%1$s[name=%2$s, code=%3$s]",
				getClass().getSimpleName(),
				name,
				code);
	}
	
}
