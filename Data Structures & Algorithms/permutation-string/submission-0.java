class Solution {
    private boolean isMatch(int target[], int window[]){
        for(int i=0;i<26;i++){
            if(target[i] != window[i])return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(m < n)return false;
        int targetFreq[] = new int[26];
        int freq[] = new int[26];

        //Filling targetFreq array
        for(char ch:s1.toCharArray()){
            targetFreq[ch - 'a']++;
        }
        //Making a window of length n
        for(int i=0;i<n;i++){
            char ch = s2.charAt(i);
            freq[ch - 'a']++;
        }
        if(isMatch(targetFreq,freq))return true;
        for(int r=n;r<m;r++){
            char right = s2.charAt(r);
            char left = s2.charAt(r-n);
            freq[left - 'a']--;
            freq[right - 'a']++;
            if(isMatch(targetFreq,freq))return true;
        }
        return false;
    }
}
