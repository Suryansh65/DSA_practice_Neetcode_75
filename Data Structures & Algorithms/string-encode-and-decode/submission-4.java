class Solution {

    public String encode(List<String> strs) {
        String encodedStr = new String("");
        for(int i=0;i<strs.size();i++){
            String str = strs.get(i);
            encodedStr += (str.length() + "#" + str);
        }
        return encodedStr;        
    }

    public List<String> decode(String str) {
        List<String>ans = new ArrayList<>();
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            int len = Integer.parseInt(str.substring(i,j));
            j++;
            String word = str.substring(j,j+len);
            ans.add(word);
            i = j+len;
        }
        return ans;
    }
}
