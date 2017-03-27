package app;

import java.io.File;

import org.apache.commons.lang3.SystemUtils;

import administration.Course;
import administration.Department;
import hr.Person;
import inventory.Item;
import inventory.Loan;
import storage.DataSerializer;

public class App {
	
	public static void main(String[] args) {
		
		String dataPath = generateAppDataPath("MakerLoan");

		DataSerializer.add(Department.getDepartments(), dataPath + File.separator + "departments.ser");
		DataSerializer.add(Course.getCourses(), dataPath + File.separator + "courses.ser");
		DataSerializer.add(Person.getPersons(), dataPath + File.separator + "persons.ser");
		DataSerializer.add(Item.getItems(), dataPath + File.separator + "items.ser");
		DataSerializer.add(Loan.getLoans(), dataPath + File.separator + "loans.ser");

		DataSerializer.deserializeAll();
		
		gui.MainFrame.main(new String[0]);
	}
	
	public static String generateAppDataPath(String folderName) {
		String path = "";
		
		if (SystemUtils.IS_OS_WINDOWS) {
			path = SystemUtils.USER_HOME + File.separator + 
					"AppData" + File.separator + 
					"Roaming" + File.separator + folderName;
			
		} else if (SystemUtils.IS_OS_UNIX) {
			path = SystemUtils.USER_HOME + File.separator + "." + folderName;
		}
		new File(path).mkdirs();
		return path;
	}
}