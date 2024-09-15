public class Solution {
    private static final int MOD = 1_000_000_007; // Define MOD

    public static int sumSubarrayMins(int[] arr) { // Updated method name
        int n = arr.length;
        if (n == 0) return 0;
        int[] pse = new int[n]; // Previous Smaller Element
        int[] nse = new int[n]; // Next Smaller Element

        // Calculate PSE
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Calculate NSE
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the sum of minimums
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int leftCount = i - pse[i];
            int rightCount = nse[i] - i;
            long contribution = (long) arr[i] * leftCount * rightCount;
            sum = (sum + contribution) % MOD;
        }

        return (int) sum;
    }
}
