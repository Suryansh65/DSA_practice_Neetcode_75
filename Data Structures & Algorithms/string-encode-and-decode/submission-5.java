class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for(String str: strs){
            encoded.append(str.length()).append('#').append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String>ans = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
            int j = i;
            while(str.charAt(j) != '#'){
                j++;
            }
            //parse the length of string
            int len = Integer.parseInt(str.substring(i,j));
            // Deduce substring
            String substr = str.substring(j+1,j+1+len);
            ans.add(substr);
            //update the pointers
            i = j + 1 + len;
        }
        return ans;
    }
}
