class Solution {
    public int[] getConcatenation(int[] nums) {
        int x=2*nums.length;
        int [] arr= new int[x];

        for (int i =0;i<x;i++){
            arr[i]=nums[i%nums.length];
        }
        return arr;
    }
}