class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map <Integer,Integer> greater=new HashMap<>();
        Stack<Integer> stack=new Stack<>();

        for(int nums:nums2){

            while(!stack.isEmpty() && nums>stack.peek()){
                greater.put(stack.pop(),nums);
            }

            stack.push(nums);
        }
         while (!stack.isEmpty()) {
            greater.put(stack.pop(), -1);
        }

        int [] result=new int[nums1.length] ;
        
        for(int i=0;i<nums1.length;i++)
        {
            result[i]=greater.get(nums1[i]);
        }
        return result;
           }
}