class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>>ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1])continue;
            int num = nums[i];
            int target = -(num);
            int l = i+1;
            int r = n-1;
            while(l < r){
                int sum = nums[l] + nums[r];
                if(sum < target){
                    l++;
                }else if(sum > target){
                    r--;
                }else{
                    List<Integer>temp = new ArrayList<>();
                    temp.add(num);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);

                    l++;
                    r--;
                    // removing duplicates
                    while(l < r && nums[l] == nums[l-1])l++;
                    while(l < r && nums[r] == nums[r+1])r--;
                }
            }

        }
        return ans;
    }
}
