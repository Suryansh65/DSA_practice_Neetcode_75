class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int ans[] = new int[2];

        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<n;i++){
            int comp = target - nums[i];
            if(map.containsKey(comp)){
                ans[0] = map.get(comp);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}
