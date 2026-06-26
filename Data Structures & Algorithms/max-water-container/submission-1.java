class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int l = 0;
        int r = n-1;
        int ans = Integer.MIN_VALUE;
        while(l < r){
            int water = Math.min(heights[l] , heights[r]) * (r - l);
            ans = Math.max(ans,water);
            if(heights[l] < heights[r]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }
}
