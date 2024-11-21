class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result= new StringBuilder();
        int minlength=Integer.MAX_VALUE;

        for(String str : strs){
            minlength=Math.min(minlength, str.length());
        }

        for(int i =0;i<minlength;i++){
            char current= strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].charAt(i)!= current){
                        return result.toString();
                }
            }
            result.append(current);
        }
      return result.toString();
    }
    
}