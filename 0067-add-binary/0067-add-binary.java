class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1; // Pointer for string a
        int j = b.length() - 1; // Pointer for string b
        int carry = 0;

        // Iterate while there are digits in a or b, or there's a carry
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0'; // Convert character to integer
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0'; // Convert character to integer
                j--;
            }

            result.append(sum % 2); // Add the binary digit (0 or 1)
            carry = sum / 2; // Calculate carry for the next position
        }

        return result.reverse().toString(); // Reverse the result and return
    }
}
