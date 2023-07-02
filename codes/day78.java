public class day78 {
    public int numTrees(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            int sum=0;
            for(int j=1;j<=i;j++){
                int left = dp[j-1];
                int right = dp[i-j];
                sum+=left*right;
            }
            dp[i] = sum;
        }
        return dp[n];
    }
}
}
