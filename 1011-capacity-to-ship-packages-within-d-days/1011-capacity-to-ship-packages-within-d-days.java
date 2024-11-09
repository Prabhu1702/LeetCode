class Solution {
    
 
    private int sum_element(int[] weights) {
        int sum = 0;
        for (int weight : weights) {
            sum += weight;
        }
        return sum;
    }


    private boolean is_possible(int mid, int days, int[] weights) {
        int curr_load = 0;
        int day = 1;

        for (int weight : weights) {
            if (curr_load + weight > mid) {
                day += 1;
                curr_load = weight;
            } else {
                curr_load += weight;
            }
        }
        return day <= days;
    }

       private int max_element(int[] weights) {
        int max = weights[0];
        for (int weight : weights) {
            if (weight > max) {
                max = weight;
            }
        }
        return max;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = max_element(weights); 
        int high = sum_element(weights); 
        int mid=0;
        while (low < high) {
            mid = (low + high) / 2;

            if (is_possible(mid, days, weights)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
