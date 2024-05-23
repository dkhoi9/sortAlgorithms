class ArrIn {
    private int[] arr;
    private int arrElements;

    public ArrIn(int max) {
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

    public void insertionSort() {
        for (int i = 1; i < arrElements; i++) {
            int key = arr[i];
            int j = i - 1;

            /*
             Move elements of arr[0 ... i-1], that are greater than the key, to one
             position ahead of their current position
             */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }
}

class InsertionSortTest {
    public static void main(String[] args) {
        int maxSize = 5;
        ArrIn arr = new ArrIn(maxSize);

        arr.insert(8);
        arr.insert(5);
        arr.insert(4);
        arr.insert(2);
        arr.insert(1);
        arr.display();

        arr.insertionSort();
        arr.display();
    }
}