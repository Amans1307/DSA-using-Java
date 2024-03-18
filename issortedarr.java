public class issortedarr {
    public static boolean issoted(int arr[],int i) {
        if(i==arr.length-1){
            return true;
        }
        if(arr[i]>arr[i+1]){
            return false;
        }
        return issoted(arr, i+1);    
    }
    public static int firstoccurence(int arr[],int i,int key) {
        if(i==arr.length){
            return -1;
        }
        if(arr[i]==key){
            return i;
        }
        return firstoccurence(arr, i+1,key);
    }
    public static int lastoccurence(int arr[],int i,int key) {
        if(i==arr.length){
            return -1;
        }
        lastoccurence(arr, i-1,key);
        if(arr[i]==key){
            return i;
        }
    return -1;    
    }
    public static int power(int n,int x) {
        if(x==0){
            return 1;
        }
        return n*power(n, x-1);    
    }
    public static void main(String[] args) {
        //int arr[]={1,5,7,9,11,11,1};
        //int key=1;
        //System.out.println(issoted(arr,0));
       // System.out.println(firstoccurence(arr,0,key));
        //System.out.println(lastoccurence(arr,arr.length-1,key));
        System.out.println(power(3,1));  
    }
    
}
