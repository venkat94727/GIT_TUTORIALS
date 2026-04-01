package com.net.c;

import java.util.ArrayList;
import java.util.List;

import com.net.Employee;

public class Employees {
	
	  private int id;
	    private String firstName;
	    private String lastName;
	    private String department;
	    private int salary;
	    
	    
	    


	public int getId() {
			return id;
		}





		public void setId(int id) {
			this.id = id;
		}





		public String getFirstName() {
			return firstName;
		}





		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}





		public String getLastName() {
			return lastName;
		}





		public void setLastName(String lastName) {
			this.lastName = lastName;
		}





		public String getDepartment() {
			return department;
		}





		public void setDepartment(String department) {
			this.department = department;
		}





		public int getSalary() {
			return salary;
		}





		public void setSalary(int salary) {
			this.salary = salary;
		}





	public Employees(int id, String firstName, String lastName, String department, int salary) {
			super();
			this.id = id;
			this.firstName = firstName;
			this.lastName = lastName;
			this.department = department;
			this.salary = salary;
		}





	public Employees() {
		super();
	}





	@Override
	public String toString() {
		return "Employe [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", department="
				+ department + ", salary=" + salary + "]";
	}
	

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return id == employees.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

	
	 public List<Employees> listEmployees() {
	        List<Employees> employees = new ArrayList<>();

	        employees.add(new Employees(1, "Alice", "Johnson", "HR", 51000));
	        employees.add(new Employees(2, "Bob", "Smith", "Dev", 52000));
	        employees.add(new Employees(3, "Charlie", "Brown", "Test", 53000));
	        employees.add(new Employees(4, "Diana", "Miller", "Manager", 54000));
	        employees.add(new Employees(5, "Ethan", "Davis", "HR", 55000));
	        employees.add(new Employees(1, "Alice", "Johnson", "HR", 51000));
	        employees.add(new Employees(2, "Bob", "Smith", "Dev", 52000));

	        return employees;
	    }


}
