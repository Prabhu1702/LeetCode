class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> letter= new HashSet<>();

        for(char c : sentence.toCharArray()){
            letter.add(c);
        }

        return letter.size()==26;
    }
}