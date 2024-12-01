public class BubbleSortExample {
    public void bubbleSort(int[] arr) {
        boolean swapped; 
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false; 
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true; 
                }
            }
            if (!swapped) {
                break; 
            }
        }
    }

    public static void main(String[] args) {
        BubbleSortExample sorter = new BubbleSortExample();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sorter.bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
