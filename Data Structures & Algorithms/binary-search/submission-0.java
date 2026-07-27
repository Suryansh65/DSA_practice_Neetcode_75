class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int idx = -1;
        int l = 0;
        int r = n-1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target){
                idx = mid;
                break;
            }else if(nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return idx;
    }
}
