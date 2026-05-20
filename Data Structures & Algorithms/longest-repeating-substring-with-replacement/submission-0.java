class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character,Integer>map = new HashMap<>();
        int i = 0;
        int maxFreq = 0;
        int len = 0;
        for(int e = 0;e<n;e++){
            char ch = s.charAt(e);
            map.put(ch,map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq,map.get(ch));

            while((e - i + 1) - maxFreq > k){
                //Move left pointer to Make sure the distinct elements should validate the requirement
                map.put(s.charAt(i),map.get(s.charAt(i)) - 1);
                i++;
            }
            len = Math.max(len,e-i+1);
        }
        return len;
    }
}
