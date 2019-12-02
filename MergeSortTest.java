import java.util.Arrays;

public class MergeSortTest {
    public static void main (String[] args) {
        int[]a=MergeSortTest.randomArray(100000000,1000000000);
        int[]b=Arrays.copyOf(a, a.length);

        long start1=System.currentTimeMillis();
        MergeSort.sort(a);
        long time1=System.currentTimeMillis()-start1;
        assert isSorted(a);

        long start2=System.currentTimeMillis();
        Arrays.sort(b);
        long time2=System.currentTimeMillis()-start2;

        // My sort should be ~4x slower ):
        System.out.printf("avivsort: %dms\njavasort: %dms\n", time1, time2);
    }

    static int[] randomArray (int size, int max) {
        int[]a=new int[size];
        for (int i=0;i<size;i++){
            a[i]=(int)(Math.random()*max)+1;
        }
        return a;
    }

    static boolean isSorted(int[] a) {
        for (int i=1;i<a.length;i++) {
            if (a[i]<a[i-1]) return false;
        }
        return true;
    }
}