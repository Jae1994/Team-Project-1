import java.io.*;
import java.util.*;

public class PersonMain {
   public static void main(String[] args) throws FileNotFoundException {
   	//Scanner for reading dat file
      Scanner scan = new Scanner(new File("tudor.dat"));
   	//Scanner for getting user input
      Scanner input = new Scanner(System.in);
      ArrayList<Person> names =new ArrayList<Person>();
   	//puts 
      create(scan, names);
   	//Enter user input
      System.out.print("Person's name? ");
   	//prints out all the info
      userSearch(input.nextLine(), names);
      input.close();
   }
	
   public static void create(Scanner scan, ArrayList<Person> names) {
   	//reads the first list from the file, and
   	//creates Person objects based on those lines, and 
   	//puts those objects into an ArrayList.
      String line = scan.nextLine();
      while(!line.equals("END")) {
         names.add(new Person(line));
         line = scan.nextLine();
      }
      
   	//Reads the second list and crates ArrayList<String>, and
   	//puts names into that ArrayList.
      line = scan.nextLine();
      ArrayList<String> family = new ArrayList<String>();
      while(!line.equals("END")) {
         family.add(line);
         line = scan.nextLine();
      }
      
   	//Reads file, sets mom, and dad for each person objects.
      for(int i = 0; i < family.size(); i+=3) {
      	
         for(Person p : names) {
            if(p.getName().equals(family.get(i))) {
               p.setMom(family.get(i+1));
               p.setDad(family.get(i+2));
            }
         }
      }
      
   	//based on p.getMom/getDad, finds out children and 
   	//puts them into Person objects in the ArrayList.
      for(int i = 0; i < names.size(); i++) {
         for(Person p : names) {
            if(p.getName().equals(names.get(i).getDad())||p.getName().equals(names.get(i).getMom())) {
               p.setChildren(names.get(i).getName());
            	
            }
         }
      }
   }
					
	//prints out all the info based on the passed String. 
	//e.g: userSearch("Henry VIII", names);
	//output: 
	//Maternal line: 
	//	  Henry VIII
	//		  Elizabeth of York
	//Paternal line: 
	//	  Henry VIII
	//	      Henry VII
	//Children:
	//	  Mary I
	//	  Elizabeth I
	//	  Edward VI
   public static void userSearch(String s, ArrayList<Person> names) {
      for(Person p: names) {
         if(s.equals(p.getName())) {
            System.out.println("Maternal line: \n    "+p.getName()+"\n\t"+p.getMom());
            System.out.println("Paternal line: \n    "+p.getName()+"\n\t"+p.getDad());
            System.out.print("Children:\n");	
            if (p.getChildren().size() > 0) {
               for(int i = 0; i<p.getChildren().size();i++) {
                  System.out.println("    "+p.getChildren().get(i));
               }
            }
            else {
               System.out.println("none");
            }
         }
      }
   }
	//prints the list of names of the person objects in the ArrayList.	
   public static void printList(ArrayList<Person> names){
      for(Person p: names) {
         System.out.println(p.getName());
      }
   }
}