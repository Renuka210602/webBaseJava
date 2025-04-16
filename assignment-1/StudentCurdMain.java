package practise.jdbc;
import java.util.Scanner;
import java.util.Collection;

public class StudentCurdMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		JDBCdao<Student, Integer> dao = new StudentDao();
		int ch;
		do {
			System.out.println("1.Get all Student Details");
			System.out.println("2.Get One Student Detail");
			System.out.println("3.Add  Student Detail");
			System.out.println("Enter choice: ");
			ch= sc.nextInt();
			switch(ch) {
			case 1:
				Collection <Student> stList = dao.getAll();
				stList.stream().forEach(st -> System.out.println(st));
				break;
			case 2:
				
				System.out.println("Enter roll number: ");
				Student st = dao.getOne(sc.nextInt());
				if(st != null)
					System.out.println(st);
				else
					System.out.println("Student with given id is not present");
				break;
			case 3:
				System.out.println("Enter rollno, name, city");
				Student st1 = new Student(sc.nextInt(),sc.next(),sc.next());
				dao.add(st1);
				break;	
			}
		}while(ch!=3);
	}
}
