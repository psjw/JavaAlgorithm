public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        binarySearch(2,arr);
    }

    public static void binarySearch(int value, int arr[]){
        int mid;
        int left=0;
        int right = arr.length - 1;
         while(right>=left){
             mid = (right + left) / 2;

             if(value == arr[mid]){
                 System.out.println(mid);
                 break;
             }
             if(value < arr[mid]){
                 right = mid - 1;
             }else{
                 left = mid + 1;
             }
         }
    }
}
