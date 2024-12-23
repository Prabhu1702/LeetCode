class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> hash=new HashMap<>();
        StringBuilder result= new StringBuilder();
        for(char c: s.toCharArray()){
           hash.put(c, hash.getOrDefault(c, 0) + 1);
        }
            List<Character> list= new ArrayList(hash.keySet());
            list.sort((a,b) -> hash.get(b)-hash.get(a));

            for(char ch:list){
                for(int i=0;i<hash.get(ch); i++){
                        result.append(ch);
                }
            }
            return result.toString();
    }
}