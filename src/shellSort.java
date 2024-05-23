class ShellSort {
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public int shellSort(int arr[]) {
        int n = arr.length;

        // Start with a big gap, then reduce the gap
        for (int gap = n/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted
            for (int i = gap; i < n; i += 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = arr[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                // put temp (the original a[i]) in its correct
                // location
                arr[j] = temp;
            }
        }
        return 0;
    }

    // Driver method
    public static void main(String[] args) {
        int maxSize = 10000;
        int[] arr = new int[maxSize];

        for (int i = 0; i < maxSize; i++) {
            int n = (int) (java.lang.Math.random() * (maxSize - 1));
            arr[i] = n;
        }

        System.out.println("Array before sorting");
        printArray(arr);

        ShellSort ob = new ShellSort();
        long startTime = System.currentTimeMillis();
        ob.shellSort(arr);
        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " ms");
        System.out.println("Array after sorting");
        printArray(arr);
    }
}
