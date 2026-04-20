package DataStructure.Neetcode150.A_ArraysAndHashing.z_FindMedian.SpaceOptimizedWhenDataRangeAvailable;

public class UsingArrayAndOffset {
    int[] store = null;
    int offset = 0;
    int count = 0;

    public static void main(String[] args) {
        UsingArrayAndOffset m = new UsingArrayAndOffset();
        m.setRangeAndOffset(-200, 200);

        m.recordTemp(-200); //-200,-100,-100,0,0,100,200
        m.recordTemp(-100);
        m.recordTemp(0);
        m.recordTemp(-100);
        m.recordTemp(0);
        m.recordTemp(100);
        m.recordTemp(200);

        System.out.println(m.findMedian());
    }

    private void setRangeAndOffset(int lowerRange, int upperRange) {
        store = new int[upperRange-lowerRange+1];
        offset = (upperRange-lowerRange+1)/2;
    }

    private void recordTemp(int temp) {
        store[offset+temp]++;
        count++;
    }

    private double findMedian() {
        if(count%2==1) {
            return (double) medianHelper(store, count/2+1);
        } else {
            int leftMiddle = medianHelper(store, count/2);
            int rightMiddle = medianHelper(store, count/2+1);
            return (double) (leftMiddle+rightMiddle)/2.0;
        }
    }

    private int medianHelper(int[] store, int target) {
        int runningSum = 0;
        for (int i = 0; i < store.length; i++) {
            runningSum+=store[i];
            if(runningSum>=target) {
                return i-offset;
            }
        }
        return 0;
    }
}
