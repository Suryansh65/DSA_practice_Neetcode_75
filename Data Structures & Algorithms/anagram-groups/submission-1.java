class Solution {
    private static String sortString(String str){
        char ch[] = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        HashMap<String,List<String>>map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            String str = strs[i];
            String search = sortString(str);
            map.putIfAbsent(search,new ArrayList<>());
            map.get(search).add(str);
        }
        for(List<String>ls : map.values()){
            ans.add(ls);
        }
        return ans;
    }
}
