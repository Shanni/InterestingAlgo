// Partition Equal Subset Sum
class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num: nums){
            total += num;
        }
        if(total % 2 != 0){
            return false;
        }
        total /= 2;
        boolean[] dp = new boolean[total + 1];
        dp[0] = true;
        for(int num: nums){
            boolean[] copy = dp.clone();
            for(int i = 0; i + num <= total; i++){
                if(dp[i] == true){
                    copy[i + num] = true;
                }
            }
            dp = copy;
        }
        
        return dp[total];
    }
}