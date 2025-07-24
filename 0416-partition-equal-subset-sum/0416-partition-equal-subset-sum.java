class Solution {
    public boolean subsetSum(Boolean [][]dp, int target, int []nums,int index){
        if(target==0) return true;
        if(index<0) return false;

        if(dp[index][target] != null) return dp[index][target];

        boolean nottake= subsetSum(dp,target,nums,index-1);
        boolean take=false;
        if(target>=nums[index])
            take=subsetSum(dp,target-nums[index],nums,index-1);

        return dp[index][target] = take || nottake;

    }

    public boolean canPartition(int[] nums) {
        int total=0;

        for(int num: nums){
            total +=num;
        }

        if(total % 2 !=0) return false;

        int target = total/2;

        Boolean [][]dp=new Boolean[nums.length][target+1];
        return subsetSum(dp,target,nums,nums.length-1);
    }
}