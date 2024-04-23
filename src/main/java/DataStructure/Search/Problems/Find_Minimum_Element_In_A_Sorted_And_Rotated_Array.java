package Search.Problems;

public class Find_Minimum_Element_In_A_Sorted_And_Rotated_Array {
    public static void main(String[] args) {
        int sortedRotatedArr[] = new int[] {4, 7, 8, 8, 9, 10, 0, 1, 2, 3};
        int indexOfRotation = indexOfRotation(sortedRotatedArr);
        System.out.println("Minimum elem: " + (indexOfRotation == -1 ? sortedRotatedArr[0] : sortedRotatedArr[indexOfRotation]));
    }

    private static int indexOfRotation(int[] sortedRotatedArr) {
        for(int i = 0; i < sortedRotatedArr.length-1; i++) {
            if(sortedRotatedArr[i+1] < sortedRotatedArr[i]) {
                return i+1;
            }
        }
        return -1;
    }
}
