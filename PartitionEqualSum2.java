// 1 5 7 11
class Solution {
    public boolean canPartition(int[] nums) {
        int total=0;
        for(int n:nums)total+=n;
        if(total%2!=0)return false;
         Arrays.sort(nums);
        total/=2;
        int lstart=0,lend=0;
        int rstart=nums.length-2,currsum=nums[nums.length-1];
        if(currsum==total)return true;
        while(lend<=rstart){
            if(currsum+nums[lend]==total || currsum+nums[rstart]==total || currsum==total)return true;
            if(currsum+nums[rstart]<total)currsum+=nums[rstart--];
            else{
                currsum+=nums[lend++];
                 while(currsum>total && lstart<lend){
                   currsum-=nums[lstart++];
                }
            }
        }
        return false;
    }