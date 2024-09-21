class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];  // Frequency array for 26 uppercase English letters
        int left = 0, right = 0, maxFreq = 0, maxLength = 0;

        // Iterate over the string with the right pointer
        while (right < s.length()) {
            // Increment the frequency of the current character
            freq[s.charAt(right) - 'A']++;
            
            // Update the most frequent character's count in the current window
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            
            // Check if the window is valid (number of changes needed <= k)
            while ((right - left + 1) - maxFreq > k) {
                // If it's invalid, shrink the window by moving the left pointer
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // Calculate the maximum length of a valid window
            maxLength = Math.max(maxLength, right - left + 1);
            
            // Expand the window by moving the right pointer
            right++;
        }
        
        return maxLength;
    }
}
