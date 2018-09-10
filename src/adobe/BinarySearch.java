package adobe;


// O(logn)
public class BinarySearch {

    static int[] numbers = {1,5,7,10,19,20};
    public static  int binarySearch(int search) {
        int position = -1;
        int low = 0;
        int high = numbers.length-1;

        int mid = low + (high-low)/2;

        while(low <= high) {
            if(numbers[mid] == search) {
                return mid;
            }
            else if(numbers[mid] > search) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
            mid = low + (high-low)/2;

        }

        return position;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(290));
    }
}
