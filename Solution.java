class Solution {
    public static void isPalindrome(int x) {
        if(x<=0){
            System.out.print(false);
        }
        while(x!=0){
            int n=x;
            int rem=x%10;
            int sum=rem*10+rem;
            x=x/10;  
            
         
    }
    if(sum==n){
        System.out.print(true);
    }
    else{
       System.out.print(false);
    }
    }     
    public static void main(String[] args) {
        isPalindrome(121);
    }     
}