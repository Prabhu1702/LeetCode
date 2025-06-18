class Solution {
    public int missingNumber(int[] nums) {
        int i=0;
    int sum= (nums.length * (nums.length+1))/2;
    int sum2=0;
    int missing=0;
    for(i=0;i<nums.length;i++){
        sum2+=nums[i];
    }
    if(sum!=sum2){
        missing=sum-sum2;
    }
    return missing;
    }
}