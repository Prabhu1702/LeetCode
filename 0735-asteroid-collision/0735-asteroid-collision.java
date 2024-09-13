import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            // Assume the asteroid will be added to the stack unless it's destroyed
            boolean destroyed = false;

            // Check for a collision scenario: stack's top is positive and current asteroid is negative
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                // Compare absolute values for collision resolution
                if (stack.peek() < -asteroid) {
                    // Current left-moving asteroid is larger, destroy the top of the stack
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                    // Both asteroids are of equal size, destroy both
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    // Stack's top is larger, current asteroid is destroyed
                    destroyed = true;
                    break;
                }
            }

            // If the current asteroid wasn't destroyed, push it to the stack
            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert the remaining stack to an array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
