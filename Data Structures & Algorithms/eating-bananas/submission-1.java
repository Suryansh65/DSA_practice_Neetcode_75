class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int max = Integer.MIN_VALUE;
        for(int i:piles){
            max = Math.max(max,i);
        }
        int l = 1;
        int r = max;
        if(h == n)return max;
        int ans = 0;
        while(l <= r){
            int mid = (l + r)/2;
            if(checkvalid(mid,h,piles)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid + 1;
            }
        }
        return ans;
    }
    private static boolean checkvalid(int k, int h, int piles[]){
        long hours = 0;
        for(int i=0;i<piles.length;i++){
            hours += (piles[i] + k-1)/k;
            if(hours > h)return false;
        }
        return true;
    }
}
