package oopsjava;

//employee count

class Employee{
	static int count =0;
	
	String name;
	int id;
	
	Employee(String name,int id){
		this.name = name;
		this.id = id;
		count++;
	}
	
	void display() {
		System.out.println("ID: " +id+ " Name: " +name);
	}
}
public class EmployeeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee e1 = new Employee("Alan",101);
		Employee e2 = new Employee("Bob",102);
		Employee e3 = new Employee("Cathrine",103);
		
		e1.display();
		e2.display();
		e3.display();
		
		System.out.println("Total number of employees: " +Employee.count);

	}

}
