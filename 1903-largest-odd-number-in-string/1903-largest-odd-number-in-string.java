class Solution {
    public String largestOddNumber(String num) {
        String max="";
       for(int i=0;i<num.length();i++){
        if(num.charAt(i) % 2 == 1){
                max= num.substring(0, i + 1);
            
        }
       }
       if(max!="0"){
        return max;
       }
       return "";
    }
}