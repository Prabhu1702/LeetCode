class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();

        for (int num: nums){
            set.add(num);
        }
        int longeststreak=0;
    for(int num: set){
        if(!set.contains(num-1)){
            int currentnum=num;
            int currentstreak=1;

            while(set.contains(currentnum +1)){
                currentnum++;
                currentstreak++;
            }
        longeststreak= Math.max(currentstreak,longeststreak);
        }
    }
    return longeststreak;
    }
}