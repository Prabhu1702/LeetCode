class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack=new Stack<>();

        if(k==num.length()){
            return "0";
        }
       for (char digit : num.toCharArray()) {
           while (!stack.isEmpty() && k > 0 && stack.peek() > digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
       }

       while(k>0){
        stack.pop();
        k--;
       }

       StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        result.reverse();

        // Remove leading zeros
        while (result.length() > 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }
}