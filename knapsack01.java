public class knapsack01 {
    public static int knapsack(int val[],int wt[],int W,int n) {
        if(W==0 || n==0){
            return 0;
        }
        if(wt[n-1]>W){
            return knapsack(val, wt, W, n-1);
        }
        else{
            return Math.max(val[n-1]+knapsack(val,wt,W-wt[n-1],n-1),knapsack(val, wt, W, n-1));
        }
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        System.out.println(knapsack(val, wt, W, 5));
    }
}
