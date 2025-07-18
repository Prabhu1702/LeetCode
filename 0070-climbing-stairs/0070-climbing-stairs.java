import java.util.HashMap;

class Solution {
    static HashMap<Integer, Integer> x = new HashMap<>();

    public int ways(int n) {
        if (n <= 1) return 1;

        if (x.containsKey(n)) return x.get(n);

        int result = ways(n - 1) + ways(n - 2);
        x.put(n, result);
        return result;
    }

    public int climbStairs(int n) {
        return ways(n);  
    }
}
