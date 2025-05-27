package JavaConcepts;

import java.util.List;

public class CloningAnObject {

	public static void main(String[] args) {
		List<Integer> al = null;
		try {
			al = (List<Integer>) Class.forName("java.util.ArrayList").newInstance();	//creating object using newInstance.
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		al.add(1);al.add(2);al.add(3);
		
		CloneTester ct = new CloneTester(1, "Binay", al);
		CloneTester ctClone = null;
		try {
			ctClone = ct.clone();		//clone() doesn't deep copies collection objects when creating cloned instance.
										//"al" in both "ct" and "ctClone" refers/points to the same ArrayList object in heap memory.
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		System.out.println(ct);
		System.out.println(ctClone);
		System.out.println(ct.getAl() == ctClone.getAl());
		ct.getAl().add(4);	//modification in "al" in "ct" will get reflected in "ctClone" also, as "al" in both "ct" and "ctClone" 
							//refers/points to the same ArrayList object in heap memory.
		System.out.println(ct);
		System.out.println(ctClone);
	}

}

class CloneTester implements Cloneable{
	private int id;
	private String name;
	private List<Integer> al;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getAl() {
		return al;
	}
	public void setAl(List<Integer> al) {
		this.al = al;
	}
	public CloneTester(int id, String name, List<Integer> al) {
		this.id = id;
		this.name = name;
		this.al = al;
	}
	
	@Override
	public String toString() {
		return "CloneTester [id=" + id + ", name=" + name + ", al=" + al + "]";
	}

	@Override
	protected CloneTester clone() throws CloneNotSupportedException {
		return (CloneTester) super.clone();
	}
}