class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            //skip duplicates
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i + 1;
            int r = nums.length-1;
            while(l < r){
                int total = nums[i] + nums[l] + nums[r];
                if(total == 0){
                    ans.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    //skip duplicates l and r
                    while(l < r && nums[l] == nums[l + 1])l++;
                    while(l < r && nums[r] == nums[r-1])r--;
                    l++;
                    r--;
                }else if(total < 0){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ans;
    }
}
