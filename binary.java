public class binary {
    public static int binary_search(int a[],int key) {
        int first=0;
        int last=a.length-1;
        while(first<=last){
            int mid=(first+last)/2;
            if(key==a[mid]){
                return mid;
            }
            else if(key>a[mid]){
                first=mid+1;
            }
            else{
                last=mid-1;
            }
        }        
        return -1;   
    }
    public static void main(String[] args) {
        int a[]={2,5,7,9,12,43};
        int key=1;
        int p=binary_search(a,key);
        System.out.println(p);
    }   
}
