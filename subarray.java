public class subarray {
    public static void pairs(int a[]) {
        int p=0;
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;j++){
                {
                    System.out.print("("+a[i]+","+a[j]+")");
                    p++;
                }

            }
            System.out.println();
        }
        System.out.println("number of comparison is "+p);
    }
    public static void main(String[] args) {
        int a[]={7,9,3,4};
        pairs(a);
    }
}
