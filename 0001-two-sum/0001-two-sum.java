class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> result= new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int compliment= target- nums[i];

            if(result.containsKey(compliment)){
                return new int [] {result.get(compliment),i};
            }

            result.put(nums[i],i);
        }
        return new int [] {};
    }
}