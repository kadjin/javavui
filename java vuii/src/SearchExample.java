public class SearchExample {
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;  
            }
        }
        return -1;  
    }
    public static void main(String[] args) {
        SearchExample example = new SearchExample();
        int[] arr = {5, 3, 8, 4, 2};
        int target = 8;

        int result = example.linearSearch(arr, target);
        if (result != -1) {
            System.out.println("Found " + target + " at index " + result);
        } else {
            System.out.println(target + " not found in the array");
        }
    }
}
