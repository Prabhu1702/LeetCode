class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack= new Stack<>();
        HashMap<Integer,Integer> nextGreater= new HashMap<>();

        for(int num: nums2){
        while(!stack.isEmpty() && num> stack.peek()){
            nextGreater.put(stack.pop(), num);
        }

         stack.push(num);
    }

    while(!stack.isEmpty()){
        nextGreater.put(stack.pop(),-1);
    }

    int[] result = new int[nums1.length];
    for(int i =0;i<nums1.length;i++){
            result[i]=nextGreater.get(nums1[i]);
    }
    return result;
}
}