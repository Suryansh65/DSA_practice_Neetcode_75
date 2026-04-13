class Solution {
    public boolean hasDuplicate(int[] nums) {
      //sort and check for near duplicates
      Arrays.sort(nums);
      int n = nums.length;
      for(int i=1;i<n;i++){
        if(nums[i] == nums[i-1])return true;
      }
      return false;
    }
}