class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer>map = new HashMap<>();
        int i = 0;
        int j = 0;
        int len = 0;
        while(j < n){
            char ch = s.charAt(j);
            if(map.containsKey(ch) && map.get(ch) >= i){
                i = map.get(ch) + 1;
            }
            map.put(ch,j);
            j++;
            len = Math.max(len,j-i);
        }
        return len;
    }
}
