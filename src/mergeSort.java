class ArrMe {
    private int[] arr;
    private int arrElements;

    public ArrMe(int max) {
        arr = new int[max];
        arrElements = 0;
    }

    public void insert(int element) {
        arr[arrElements] = element;
        arrElements++;
    }

    public void display() {
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
        System.out.println(" ");
    }

    public void merge(int l, int m, int r) {
        /* CREATING sub-arrays */

        // Find the size of two sub-arrays
        int n1 = m - l + 1;
        int n2 = r - m;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            L[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[m + 1 + j];
        }

        /* MERGING sub-arrays */

        // Initialize indexes of first and second sub-arrays
        int i = 0, j = 0;

        // Initialize the index of the merged, sorted array (original one)
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k++] = L[i++];
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k++] = R[j++];
        }
    }

    public void mergeSort(int l, int r) {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;

            // Sort first and second halves
            mergeSort(l, m);
            mergeSort(m + 1, r);

            // Merge the sorted halves
            merge(l, m, r);
        }
    }
}

class MergeSortTest {
    public static void main(String[] args) {
        int maxSize = 10000;
        ArrMe arr = new ArrMe(maxSize);

        for (int i = 0; i < maxSize; i++) {
            int n = (int) (java.lang.Math.random() * (maxSize - 1));
            arr.insert(n);
        }
        arr.display();

        long startTime = System.currentTimeMillis();
        arr.mergeSort(0, maxSize - 1);
        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " ms");
        arr.display();
    }
}