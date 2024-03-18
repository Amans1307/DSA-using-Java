public class sb_array_max {
    public static void sub_array_max(int arr[]) {
        int max_sum=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {//brute force O(n^3) time complexity
            int start=i;
            for (int j = i; j < arr.length; j++) {
                int last=j;
                int curr_sum=0;
                for (int k = start; k <= last; k++) {
                    curr_sum+=arr[k];
                }
                System.out.println(curr_sum); 
                    if (max_sum<curr_sum) {
                        max_sum=curr_sum; 
                    }                         
            }  
        }  
        System.out.println("max sum is "+max_sum);  
    }



    public static void main(String args[]) {
        int arr[]={1,-2,6,-1,3};
        sub_array_max(arr);

        
    }
}
