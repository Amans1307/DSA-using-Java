public class sb_array_max_presum {
    public static void prefix_sum(int arr[]) {
        int max_sum=Integer.MIN_VALUE;
        int prefixarray[]=new int[arr.length];
        prefixarray[0]=arr[0];
        for (int i = 1; i < prefixarray.length; i++) {
            prefixarray[i]=prefixarray[i-1]+arr[i];
        }
        for (int i = 0; i < arr.length; i++) {//brute force O(n^3) time complexity
            int start=i;
            for (int j = i; j < arr.length; j++) {
                int last=j;
                int curr_sum = start==0 ? prefixarray[last]:prefixarray[last]-prefixarray[start-1];  
                if(curr_sum>max_sum){
                    max_sum=curr_sum;
                }
                System.out.println(curr_sum);                       
            }    
        }  
        System.out.println("max sum is "+max_sum);  
    }

    public static void kadan(int arr[]) {
       int ms=Integer.MIN_VALUE;
       int cs=0;
       for (int i = 0; i < arr.length; i++) {
        cs+=arr[i];
        if(cs<0){
            cs=0;
        }
        ms=Math.max(cs,ms);
       }
    System.out.println(ms);   
    }
    public static void main(String[] args) {
        int arr[]={1,-2,6,-1,3};
        //prefix_sum(arr);
        kadan(arr);
    }
}
