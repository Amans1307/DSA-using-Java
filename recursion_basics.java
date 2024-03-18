public class recursion_basics{

public static void lastnum(int n){// reverse counting
    if(n==1){
        System.out.print(n+" ");
        return;
    }
    System.out.print(n+" ");
    lastnum(n-1);
}
//
public static void firstnum(int n){
    if(n==1){
        System.out.print(n+" ");
        return;
    }
    firstnum(n-1);
    System.out.print(n+" ");
}

public static void main(String[] args) {
    int n=5;
    lastnum(n);
    System.out.println("second question");
    firstnum(n);
}
}