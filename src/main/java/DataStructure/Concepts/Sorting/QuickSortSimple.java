package DataStructure.Concepts.Sorting;

import java.util.Arrays;

public class QuickSortSimple {


    public static void main(String[] args) {
        int[] arr = new int[] {3,6,8,10,1,2,1};
        int[] sortedArr = quicksort(arr);
        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] quicksort(int[] arr) {
        if(arr.length <=1) return arr;

        int pivot = arr[arr.length/2];

        int[] left = Arrays.stream(arr).filter(x-> x<pivot).toArray();
        int[] middle = Arrays.stream(arr).filter(x-> x==pivot).toArray();
        int[] right = Arrays.stream(arr).filter(x-> x>pivot).toArray();
/*
        //without using filter
        List<Integer> leftl = new ArrayList<>();
        List<Integer> middlel = new ArrayList<>();
        List<Integer> rightl = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < pivot)
                leftl.add(arr[i]);
            else if (arr[i]>pivot)
                rightl.add(arr[i]);
            else middlel.add(arr[i]);
        }
        left = leftl.stream().mapToInt(l->(l.intValue())).toArray();
*/
        return concatenate(quicksort(left), middle, quicksort(right));
    }

    private static int[] concatenate(int[] left, int[] middle, int[] right) {
        int[] result = new int[left.length+ middle.length + right.length];
        System.arraycopy(left, 0, result, 0, left.length);
        System.arraycopy(middle, 0, result, left.length, middle.length);
        System.arraycopy(right, 0, result, left.length+middle.length, right.length);
        return result;
    }
}
