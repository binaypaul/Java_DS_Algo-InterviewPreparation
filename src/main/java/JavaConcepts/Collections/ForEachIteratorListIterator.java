package JavaConcepts.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ForEachIteratorListIterator {

	public static void main(String[] args) {
		List<Integer> al = new ArrayList<Integer>() {{
			add(1);
			add(2);
			add(3);
			add(4);
			add(5);
		}};
		TypesOfAccess t = new TypesOfAccess(al);
		t.forEachAccess();
		t.iteratorAccess();
		t.listIteratorAccess();
	}
}

class TypesOfAccess {
	List<Integer> al = null;
	public TypesOfAccess(List<Integer> al) {
		this.al = al;
	}
	
	public void forEachAccess() {
		System.out.println("By normal for each loop");
		for (Integer integer : al) {
			System.out.print(integer + ",");
		}
		System.out.println();
		System.out.println("========================");
		
		System.out.println("By Java 8 forEach method");
		al.forEach(System.out::print);
		System.out.println();
		System.out.println("========================");
	}
	
	public void iteratorAccess() {
		System.out.println("By Iterator");
		Iterator<Integer> it = al.iterator();
		while (it.hasNext()) {
			Integer integer = it.next();
//			it.remove();	//Can remove or add to the list. concurrentModificationException isn't thrown.
			System.out.print(integer + ",");
		}
		System.out.println();
		System.out.println("========================");
	}
	
	public void listIteratorAccess() {
		System.out.println("By listIterator");
		ListIterator<Integer> it = al.listIterator();
		while (it.hasNext()) {
			Integer integer = it.next();
//			it.remove();	//Can remove or add to the list. concurrentModificationException isn't thrown.
			System.out.print(integer + ",");
		}
		System.out.println();
		it = al.listIterator(al.size());
		while (it.hasPrevious()) {
			Integer integer = it.previous();	//can move backwards as well.
//			it.remove();	//Can remove or add to the list. concurrentModificationException isn't thrown.
			System.out.print(integer + ",");
		}
		System.out.println();
		System.out.println("========================");
	}
}