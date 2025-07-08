class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int [] ple = new int [n];
        int [] nle = new int [n];
        Stack<Integer> stack= new Stack<>();
         int MOD = 1_000_000_007;
        
        for(int i=0;i<=n-1;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ple[i]=-1;
            }
            else
                ple[i]=stack.peek();

            stack.push(i);
        }

        stack.clear();
        

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                nle[i]=n;
            }
            else{
                nle[i]=stack.peek();
            }
            stack.push(i);
        }

          long total = 0;
        for (int i = 0; i < n; i++) {
            long left = i - ple[i];  
            long right = nle[i] - i;
            long contrib = ((arr[i] * left) % MOD * right) % MOD;
            total = (total + contrib) % MOD;
        }
        return (int) total;
    }
}