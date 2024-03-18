public class reverse {
    public static int arr_reverse(int a[]) {
        int start=0,end=a.length-1;
        while(start<end){
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
        return 0;
    }
    public static void main(String[] args) {
        int a[]={1,54,77,3,96,4,55};
        arr_reverse(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
    
}
