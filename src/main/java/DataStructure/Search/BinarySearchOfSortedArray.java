package DataStructure.Search;

public class BinarySearchOfSortedArray {

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.search(77));
	}

}

class BinarySearch {
	int[] arr = new int[] {11, 22, 33, 44, 55, 66, 77, 88, 99};
	int first = 0, last = arr.length-1, middle = (first+last)/2;
		
	public int search(int searchKey) {
		while(first <= last) {
			if (searchKey < arr[middle]) {
				last = middle - 1;
			} else if (searchKey > arr[middle]) {
				first = middle + 1;
			} else {
				System.out.println("Search key found.");
				return middle;
			}
			middle = (first + last)/2;
		}
		System.out.println("Search key not found.");
		return -1;
	}
}