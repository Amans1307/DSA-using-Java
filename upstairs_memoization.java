import java.util.*;
public class upstairs_memoization {
    public static int memoizationss(int n,int ways[]) {// O(n) time complexity
        if(n==0){
            return 1;
        }
        if (n==-1) {
            return 0;
        }
        if(ways[n]!=-1){//already present
            return ways[n];
        }
        ways[n]=(memoizationss(n-1,ways) + memoizationss(n-2,ways));
        return ways[n];
    }
    public static int tabulation(int n) {
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<=n;i++){
            if(i==1){
                dp[i]=dp[i-1]+0;
            }
            else{
                dp[i]=dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n=5;
        int ways[]=new int[n+1];
        Arrays.fill(ways,-1);
        System.out.println(memoizationss(n, ways));
        System.out.println(tabulation(n));
    }
}
