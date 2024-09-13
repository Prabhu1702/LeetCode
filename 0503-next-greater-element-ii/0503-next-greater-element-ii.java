class Solution {
    public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;                    // Get the length of the array
    int[] result = new int[n];              // Result array to store the next greater elements
    Stack<Integer> stack = new Stack<>();   // Stack to keep track of indices

    // Initialize result array with -1 (default value if no greater element is found)
    for (int i = 0; i < n; i++) {
        result[i] = -1;
    }

    // Traverse the array twice to handle the circular nature
    for (int i = 0; i < 2 * n; i++) {
        int index = i % n;  // Circular index, wraps around when i >= n
        while (!stack.isEmpty() && nums[stack.peek()] < nums[index]) {
            result[stack.pop()] = nums[index];  // Update result for the popped index
        }
        stack.push(index);  // Push the current index onto the stack
    }

    return result;  // Return the result array
}

}