import java.util.*;
public class Person {
	private String name;
	private String mom;
	private String dad;
	private ArrayList<String> children;
	
	public Person(String name) {
		this.name = name;
		
	}

	public String getName() {
		return name;
	}


	public String getMom() {
		return mom;
	}

	public void setMom(String mom) {
		this.mom = mom;
	}

	public String getDad() {
		return dad;
	}

	public void setDad(String dad) {
		this.dad = dad;
	}

	public ArrayList<String> getChildren() {
		return children;
	}

	public void setChildren(String child) {
		children.add(child);
	}
	
	

}
