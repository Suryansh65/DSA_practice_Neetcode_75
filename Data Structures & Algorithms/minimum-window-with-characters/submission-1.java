class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        String ans = "";
        int startIdx = 0;
        int min = Integer.MAX_VALUE;
        int l = 0;
        int totalRequired = m;
        int windowMap[] = new int[256];
        int targetMap[] = new int[256];

        /*Edge case*/
        if(n < m)return ans;

        /*Fill target Map*/
        for(int i=0;i<m;i++){
            targetMap[t.charAt(i)]++;
        }

        /*Sliding Window*/
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            windowMap[ch]++;

            //If this is the character I required than we have to reduce totalRequired
            if(targetMap[ch] > 0 && windowMap[ch] <= targetMap[ch]){
                totalRequired--;
            }
            //Shrink the window
            while(totalRequired == 0){
                char leftCh = s.charAt(l);
                windowMap[leftCh]--;

                if(targetMap[leftCh] > 0 && windowMap[leftCh] < targetMap[leftCh]){
                    totalRequired++;
                }
                int len = r - l + 1;
                if(len < min){
                    min = len;
                    startIdx = l;
                }
                l++;
            }
        }
            if(min == Integer.MAX_VALUE){
                return "";
            }else{
                return s.substring(startIdx,startIdx + min);
            }

    }
}
