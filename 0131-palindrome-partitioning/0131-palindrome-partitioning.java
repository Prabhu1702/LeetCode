class Solution {
    public void palindrome(String s,int index,List<String> path , List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }

        for(int i=index;i<s.length();i++){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                palindrome(s,i+1,path,ans);
                path.remove(path.size()-1);
            }
        }

    }

    boolean isPalindrome(String s, int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
            
        }
        return true;
    }


    public List<List<String>> partition(String s) {
        List<List<String>> ans= new ArrayList<>();
        List<String> path= new ArrayList<>();

        palindrome(s,0,path,ans);
        return ans;
    }
}