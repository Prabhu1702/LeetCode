class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
           
            boolean destroyed = false;

           
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                
                if (stack.peek() < -asteroid) {
                    
                    stack.pop();
                } else if (stack.peek() == -asteroid) {
                   
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                  
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
}
    }
}