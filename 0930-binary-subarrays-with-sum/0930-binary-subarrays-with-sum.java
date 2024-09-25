class Solution {
    // Helper function to count subarrays with sum less than or equal to 'goal'
    public int lessEqualToK(int[] nums, int goal) {
        if (goal < 0) {
            return 0;  // If the goal is negative, no subarrays can have a sum less than or equal to it
        }
        
        int sum = 0, left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            // If sum exceeds the goal, shrink the window by moving the left pointer
            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            // Add the number of valid subarrays ending at the current right index
            count += (right - left + 1);
        }

        return count;
    }

    // Method to count subarrays with sum exactly equal to the 'goal'
    public int numSubarraysWithSum(int[] nums, int goal) {
        return lessEqualToK(nums, goal) - lessEqualToK(nums, goal - 1);
    }
}

  
