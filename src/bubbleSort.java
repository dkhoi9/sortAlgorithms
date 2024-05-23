class ArrBu {
    private int[] arr;
    private int arrElements;

    public ArrBu(int max) {
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

    public void bubbleSort() {
        for (int i = 0; i < arrElements - 1; i++) { // "i" doesn't go to the last element
            for (int j = 0; j < arrElements - i - 1; j++) {
                if (arr[j] > arr[j + 1]) { // if the current element is greater than the next element,
                    swap(j, j + 1); // swap them
                }
            }
        }
    }

    public void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

class BubbleSortTest {
    public static void main(String[] args) {
        int maxSize = 5;
        ArrBu arr = new ArrBu(maxSize);

        arr.insert(8);
        arr.insert(5);
        arr.insert(4);
        arr.insert(2);
        arr.insert(1);
        arr.display();

        arr.bubbleSort();
        arr.display();
    }
}