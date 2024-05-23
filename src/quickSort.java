class ArrQu {
    private int[] arr;
    private int arrElements;

    public ArrQu(int max) {
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

    public int partition(int low, int high) {
        int pivot = arr[high];

        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                swap(i, j); // swap arr[i] and arr[j]
            }
        }

        swap(i + 1, high); // swap arr[i + 1] and arr[high] (or pivot)
        return i + 1;
    }

    /*
     * The main function that implements QuickSort() arr[] --> Array to be
     * sorted, low --> Starting index, high --> Ending index
     */
    public void quickSort(int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(low, high);

            // Recursively sort elements at the left and the right of the partition
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    public void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

class QuickSortTest {
    public static void main(String[] args) {
        int maxSize = 35000;
        ArrQu arr = new ArrQu(maxSize);

        for (int i = 0; i < maxSize; i++) {
            int n = (int) (java.lang.Math.random() * (maxSize - 1));
            arr.insert(n);
        }
        arr.display();

        long startTime = System.currentTimeMillis();
        arr.quickSort(0, maxSize - 1);
        long endTime = System.currentTimeMillis();

        System.out.println("That took " + (endTime - startTime) + " ms");
        arr.display();
    }
}