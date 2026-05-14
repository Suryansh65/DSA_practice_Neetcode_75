class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n-1;
        int ans = 0;
        while(left < right){
            int water = Math.min(heights[left],heights[right]) * (right - left);
            ans = Math.max(ans,water);
            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
