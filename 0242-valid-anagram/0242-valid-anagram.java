class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }

        HashMap<Character,Integer> hash= new HashMap<>();

        for(char c: s.toCharArray()){
            if(hash.containsKey(c)){
                hash.put(c,hash.get(c)+1);
            }
            else{
                hash.put(c,1);
            }

        }  
        for(char x: t.toCharArray()){
            if(!hash.containsKey(x)){
                return false;
            }
            hash.put(x,hash.get(x)-1);
            if(hash.get(x)==0){
                hash.remove(x);
            }
        } 

         if(!hash.isEmpty()){
            return false;
         }

         return true;
    }
}