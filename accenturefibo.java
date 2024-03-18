import java.util.Scanner;
public class accenturefibo {
    public static int fibo(int n){
        if(n==0 || n==1) return 1;
        return ((fibo(n-1)*fibo(n-1))+(fibo(n-2)*fibo(n-2)))%47;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter num");
        int n=sc.nextInt();
     
       // System.out.println(10%47);
         System.out.println(fibo(n));
    }
}

