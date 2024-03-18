public class largest {
    public static int Largest(int num[]) {
        int large=Integer.MIN_VALUE;
        int small=Integer.MAX_VALUE;
        for(int i=0;i<num.length;i++){
            if(num[i]>large){
                large=num[i];
            }
            if (num[i]<small){
                small=num[i];    
            } 
        }  
        System.out.println("Smallest number is "+small);
        return large; 
    }
    public static void main(String[] args) {
        int num[]={92,22,5,64,8,2};
        System.out.println("largest no is "+Largest(num));        
    }   
}
