import model.Student;
import service.Studentservice;
//Tasks oops
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s = new Student();
		s.name = "Lokesh";
		s.age = 38;
		
		Studentservice ss = new Studentservice();
		ss.printStudent(s);
	}

}
