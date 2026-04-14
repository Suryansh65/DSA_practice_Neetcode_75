class Solution {
    public boolean isAnagram(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        if(n1 != n2) return false;
        HashMap<Character,Integer>map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(char ch: t.toCharArray()){
            if(map.get(ch) == null || map.get(ch) == 0)return false;
                map.put(ch, map.get(ch)-1);
            if(map.get(ch) == 0){
                map.remove(ch);
            }
        }
        return map.size() == 0 ? true : false;
    }
}
