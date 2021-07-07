package Search.Problems;

import Search.Binary_Search_Of_Sorted_Array;

public class Find_Element_In_A_Sorted_And_Rotated_Array {
    
    public static void main(String[] args) {
        int key = 8;
        int inputArr[] = new int[] {5, 6, 7, 8, 8, 9, 10, 1, 2, 3};
        int pivotIndexOfRotation = findPivotIndex(inputArr);
        if(pivotIndexOfRotation == -1) {
            pivotIndexOfRotation = inputArr.length;
        }
        int indexOfKey = Binary_Search_Of_Sorted_Array.binarySearch(key, 0, pivotIndexOfRotation-1, inputArr);
        if (indexOfKey == -1) {
            indexOfKey = Binary_Search_Of_Sorted_Array.binarySearch(key, pivotIndexOfRotation, inputArr.length-1, inputArr);
        }

        System.out.println("Index of key: " + indexOfKey);
    }

    private static int findPivotIndex(int[] inputArr) {
        for(int i = 0; i < inputArr.length-1; i++) {
            if(inputArr[i+1] < inputArr[i]) {
                return i+1;
            }
        }
        return -1;
    }
}
