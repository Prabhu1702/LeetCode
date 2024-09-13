//in this code we have created 2 dataset one hash map and one stack. what we are doing is pushing element from nums2 into stack and when we push other element we check if its greater than the existing element (we pop the existing element and the num we are currently pushing) together into the hasp map or we just push the element into the stakck. after full iteration we check if stack is empty or not if not we push the stack element and -1 together into the map. after this we check the elements in nums1 and check corresponding value of the element in hashmap.

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