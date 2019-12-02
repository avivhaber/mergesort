public class MergeSort {
    static void sort (int[] a){
        mergeSort(a,0,a.length-1);
    }

    private static void mergeSort (int[] a, int l, int r) {
        if (r-l<=0) return;
        int m = (l+r)/2;
        mergeSort(a, l, m);
        mergeSort(a, m+1, r);
        merge(a, l, m, r);
    }

    private static void merge (int[] a, int l, int m, int r) {
        int[] sorted = new int[r-l+1];
        int i1=l;
        int i2=m+1;
        int x=0;

        while (i1<=m && i2<=r) {
            if (a[i1]<=a[i2]) {
                sorted[x]=a[i1];
                i1++;
            }
            else {
                sorted[x]=a[i2];
                i2++;
            }
            x++;
        }
        int rem = (i1-m==1) ? i2 : i1;
        while (x<sorted.length) {
            sorted[x]=a[rem];
            x++;
            rem++;
        }

        for (int i=0;i<sorted.length;i++) {
            a[l+i]=sorted[i];
        }
    }
}