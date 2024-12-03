import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[] {22,11,55,88,33,66,44,99,77};
        System.out.println(Arrays.toString(arr));
        qsort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void qsort(int[] arr, int low, int high) {
        if(low<high) {
            int pindex = pindex(arr, low, high);
            qsort(arr, low, pindex - 1);
            qsort(arr, pindex + 1, high);
        }
    }

    private static int pindex(int[] arr, int low, int high) {
        int i = low-1;
        int pivot = arr[high];
        for (int j = low; j < high; j++) {
            if(arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i+=1;
        swap(arr,i,high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if(i!=j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
        }
    }
}
