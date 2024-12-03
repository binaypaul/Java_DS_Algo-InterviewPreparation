package DataStructure.Sorting;
import java.util.Arrays;

public class QuickSort {
	public int partition(int[] arr, int low, int high) {
		int i = low-1;
		int pivot = arr[high];
		for(int j = low; j<high; j++) {
			if (arr[j] <= pivot) {
				i++;
				//swap element at index i and j
				swap(arr, i, j);
			}
		}
		//swap element at index i+1 and high
		i = i + 1;
		swap(arr, i, high);
		return i;
	}
	
	//Recursive sort
	public void sort(int[] arr, int low, int high) {
		if(low<high) {
			int partitionIndex = partition(arr, low, high);
			sort(arr, low, partitionIndex-1);
			sort(arr, partitionIndex+1, high);
		}
	}
	
	//swap without using temporary variable.
	public void swap(int[] arr, int swapIndexI, int swapIndexJ) {
		if(arr[swapIndexI] != arr[swapIndexJ]) {					//a: 2, b: 3
			arr[swapIndexI] = arr[swapIndexI] + arr[swapIndexJ];	//a=a+b;	a: (2+3)=5,	b: 3
			arr[swapIndexJ] = arr[swapIndexI] - arr[swapIndexJ];	//b=a-b;	a: 5,	b: (5-3)=2
			arr[swapIndexI] = arr[swapIndexI] - arr[swapIndexJ];	//a=a-b;	a: (5-2)=3, b: 2
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {22,11,55,33,66,44,99,77};
		System.out.println(Arrays.toString(arr));
		QuickSort quickSort = new QuickSort();
		quickSort.sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}