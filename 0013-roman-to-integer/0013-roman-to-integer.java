class Solution {
    // Map to store Roman numeral characters and their integer values
    private static final Map<Character, Integer> romanMap = new HashMap<>();
    
    // Static block to initialize the map
    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }
    
    // Method to convert a Roman numeral string to an integer
    public int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;
        
        // Iterate over the characters of the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = romanMap.get(s.charAt(i));
            
            // If the current value is less than the previous value, subtract it
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                // Otherwise, add it to the total
                total += currentValue;
            }
            
            // Update the previous value to the current value
            prevValue = currentValue;
        }
        
        return total;
    }
}