import java.io.*;
import java.util.*;

public class FamilyMain {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("tudor.dat"));
		// method assigning names from the file to person
		
		ArrayList<Person> names =new ArrayList<Person>();
		create(scan, names);
		printList(names);
	}
	
	public static void create(Scanner scan, ArrayList<Person> n) {
		String line = scan.nextLine();
		while(!line.equals("END")) {
			n.add(new Person(line));
			line = scan.nextLine();
		}
		
	}
	public static void printList(ArrayList<Person> names){
		for(Person p: names) {
			System.out.println(p.getName());
		}
	}
}
