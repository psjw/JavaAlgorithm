public class Main_11728 {
    static void sort(int[] tree, int[] arr, int start, int end) {
        if (start == end) {
            arr[start] = tree[start];
            return;
        }
        int mid = (start + end) / 2;
        sort(tree, arr, start, mid);
        sort(tree, arr, mid + 1, end);
    }

    public static void main(String[] args) {
        int[] tree = {2, 3, 5, 9, 1, 4, 7};
        int[] arr = new int[7];
        sort(tree, arr, 0, 7 - 1);
        System.out.println();
    }
}
