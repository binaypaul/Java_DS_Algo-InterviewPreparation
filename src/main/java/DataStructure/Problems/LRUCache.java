package DataStructure.Problems;

import java.util.ArrayList;
import java.util.List;

public class LRUCache {
	final int CACHE_SIZE = 3;
	public static void main(String[] args) {
		UsingArrayList usingArrayList = new UsingArrayList(3);
		usingArrayList.refer(1);
		usingArrayList.printCache();
		System.out.println();
		usingArrayList.refer(2);
		usingArrayList.printCache();
		System.out.println();
		usingArrayList.refer(3);
		usingArrayList.printCache();
		System.out.println();
		usingArrayList.refer(2);
		usingArrayList.printCache();
		System.out.println();
		usingArrayList.refer(5);
		usingArrayList.printCache();
		System.out.println();
	}
}

class UsingArrayList {
	int cacheSize;
	public UsingArrayList(int cacheSize) {
		this.cacheSize = cacheSize;
	}
	List<Integer> al = new ArrayList<Integer>(this.cacheSize);
	
	public void refer(int page) {
		if(al.contains(page)) {
			if(al.indexOf(page) != al.size()-1) {
				al.remove(al.indexOf(page));
				al.add(page);
			}
		} else {
			if(al.size() < this.cacheSize) {
				al.add(page);
			} else {
				al.remove(0);
				al.add(page);
			}
		}
	}
	
	public void printCache() {
		for(int j = al.size()-1; j >= 0; j--) {
			System.out.print(al.get(j) + " ");
		}
	}
}
