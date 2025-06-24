class Solution {
    public int[] rearrangeArray(int[] nums) {
    List<Integer> positive= new ArrayList<>();
    List<Integer> negative= new ArrayList<>();

    for(int i =0;i<nums.length;i++){
        if(nums[i]>0)
            positive.add(nums[i]);

        else
            negative.add(nums[i]);
    }

    int [] result= new int [nums.length];
    int p=0,k=0,n=0;

    while(p<positive.size() && k<negative.size()){
        result[n++]=positive.get(p++);
        result[n++]=negative.get(k++);
    }
    return result;


    }
}