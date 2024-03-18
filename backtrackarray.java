/**
 * backtrackarray
 */
public class backtrackarray {
    public static void backarray(int arr[],int i,int val) {
        //base case
        if (i==arr.length) {
            printArray(arr);
            return;
        }
        //recursion call kaam
        arr[i]=val;
        backarray(arr, i+1, val+1);
        arr[i]=arr[i]-2;                //   backtracking steps
    }
    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]=new int[5];
        backarray(arr, 0, 1);
        printArray(arr);
    }
}