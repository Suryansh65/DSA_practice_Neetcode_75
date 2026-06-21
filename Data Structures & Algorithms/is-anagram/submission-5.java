class Solution {
    public boolean isAnagram(String s, String t) {
        int n = s.length();
        int m = t.length();
        //IF length are not same then return false immediately
        if(n != m)return false;
        HashMap<Character,Integer>map = new HashMap<>();
        //Iterate over string s
        for(int i = 0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }

        //Iterate over string t to reduce the count one by one
        for(int j=0;j<m;j++){
            char ch = t.charAt(j);
            if(!map.containsKey(ch))return false;
                map.put(ch,map.get(ch)-1);
                if(map.get(ch) == 0){
                    map.remove(ch);
                }
        }
        return true;
    }
}
