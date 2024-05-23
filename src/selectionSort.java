class ArrSe {
    private int[] arr;
    private int arrElements;

    public ArrSe(int max) {
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

    public void selectionSort() {
        for (int i = 0; i < arrElements - 1; i++) { // "i" doesn't go to the last element
            int minIndex = i; // Set the minimum element as the current one

            for (int j = i + 1; j < arrElements; j++) { // Iterate through the rest of the array at the right
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update the minimum element
                }
            }

            swap(i, minIndex);
        }
    }

    public void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

class SelectionSortTest {
    public static void main(String[] args) {
        int maxSize = 5;
        ArrSe arr = new ArrSe(maxSize);

        arr.insert(8);
        arr.insert(5);
        arr.insert(4);
        arr.insert(2);
        arr.insert(1);
        arr.display();

        arr.selectionSort();
        arr.display();
    }
}