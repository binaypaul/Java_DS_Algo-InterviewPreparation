package Collections;

import java.util.ArrayList;
import java.util.List;

public class CreateAnImmutableArrayList {
	public static void main(String[] args) {
		List<Integer> immuList = new ImmutableArrayList<Integer>();
		immuList.add(3);
		immuList.add(2);
		immuList.add(1);
		System.out.println(immuList);
	}
}

class ImmutableArrayList<E> extends ArrayList<E> {
	private static final long serialVersionUID = -1382120201842583290L;
	
	private List<E> immutableArrayList= null;
	
	public ImmutableArrayList() {
		immutableArrayList = new ArrayList<E>();
	}
	
	@Override
	public boolean add(E e) {
        List<E> tempImmutableArrayList = new ArrayList<E>(immutableArrayList);
		return tempImmutableArrayList.add(e);
	};
	
	@Override
	public E remove(int index) {
        List<E> tempImmutableArrayList = new ArrayList<E>(immutableArrayList);
		return tempImmutableArrayList.remove(index);
	}

	@Override
	public String toString() {
		return immutableArrayList.toString();
	}
}