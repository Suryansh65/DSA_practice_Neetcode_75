class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int ans = -1;
        int l = 0;
        int h = n-1;
        while(l <= h){
            int mid = (l + h)/2;
            if(nums[mid] == target){
                ans = mid;
                break;
            }
            //check which half is sorted
            if(nums[mid] >= nums[l]){
                // Left Sorted
                //check if target exist in this half
                if(target >= nums[l] && target <= nums[mid]){
                    h = mid-1;
                }else{
                    l = mid+1;
                }
            }else{
                //Right is sorted: Check if target exist in this half
                if(target >= nums[mid+1] && target <= nums[h]){
                    // exist here
                    l = mid+1;   
                }else{
                    h = mid-1;
                }
            }
        }
        return ans;
    }
}
