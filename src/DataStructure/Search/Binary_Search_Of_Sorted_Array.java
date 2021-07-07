package Search;

public class Binary_Search_Of_Sorted_Array {
    public static void main(String[] args) {
        int sortedArray[] = new int[] {1, 2, 3, 4, 7, 8, 9, 10};
        displayArray(0, sortedArray.length-1, sortedArray);
        int indexOfKeyInArray = binarySearch(5, 0, sortedArray.length-1, sortedArray);
        System.out.println("indexOfKeyInArray: " + indexOfKeyInArray);
    }

    public static int binarySearch(int key, int low, int high, int[] sortedArray) {
        if(low < high) {
            int middleIndex = (low + high) / 2;
            int middleIndexElem = sortedArray[middleIndex];
            if (key < middleIndexElem) {
                return binarySearch(key, low, middleIndex, sortedArray);
            } else if (key > middleIndexElem) {
                return binarySearch(key, middleIndex + 1, high, sortedArray);
            } else if (key == middleIndexElem) {
                return middleIndex;
            } else return -1;
        } else {
            return -1;
        }
    }

    public static void displayArray(int low, int high, int[] arr) {
        System.out.println("===============================");
        for(int i = low; i <=high; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
        System.out.println("===============================");
    }
}
