class Solution {
    public String sortString(String str) {
        char word[] = str.toCharArray();
        Arrays.sort(word);
        // return word.toString();
        return new String(word);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = strs[i];
            String search = sortString(str);
            // if (map.containsKey(search)) {
            //     List<String> ls = map.get(search);
            //     // If the sorted word found in hashmap then put that word into the list
            //     ls.add(str);
            // } else {
            //     List<String> ls = new ArrayList<>();
            //     ls.add(search);
            //     map.put(search, ls);
            // }


            // OPTIMIZED APPROACH
            map.putIfAbsent(search,new ArrayList<>());
            map.get(search).add(str);
        }
        // Iterate on each values of HashMap to get Ans ArrayList
        for (List<String> ls : map.values()) {
            ans.add(ls);
        }
        return ans;
    }
}
