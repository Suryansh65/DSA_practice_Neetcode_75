class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int min = Integer.MAX_VALUE;
        while(l <= h){
            int mid = (l + h)/2;
            min = Math.min(min,nums[mid]);
            if(nums[h] <= nums[mid]){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return min;
    }
}
