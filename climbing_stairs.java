public class climbing_stairs{
public static int  stairs_ways(int n) {
    if(n==0){
        return 1;
    }
    if (n==-1) {
        return 0;
    }
    return stairs_ways(n-1)+stairs_ways(n-2);
}
public static void main(String[] args) {
    int n=4;
    System.out.println(stairs_ways(n));
}
}