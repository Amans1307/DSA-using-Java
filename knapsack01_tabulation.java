public class knapsack01_tabulation {
    public static int knpsk(int val[],int wt[],int W,int n,int dp[][]) {
        for(int i=0;i<dp.length;i++){//0th colomn
            dp[i][0]=0;
            }
        for(int j=0;j<dp[0].length;j++){//0th row
            dp[0][j]=0;
            }
            for(int i=1;i<n+1;i++){
                for(int j=1;j<W+1;j++){
                    int v=val[i-1];
                    int w=wt[i-1];
                    if(w<=j){
                        dp[i][j]=Math.max(val[i-1]+dp[i-1][j-w],dp[i-1][j]);
                    }
                    else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
    return dp[n][W];    
    }
    public static int arrayprinting(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j<dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
        return 0;
    }
    public static void main(String[] args) {
        int val[]={15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int W=7;
        int n=val.length;
        int dp[][]=new int[n+1][W+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                dp[i][j]=-1;
            }
        }
       System.out.println(knpsk(val, wt, W, n,dp));
       System.out.println(arrayprinting(dp));
    }
}
