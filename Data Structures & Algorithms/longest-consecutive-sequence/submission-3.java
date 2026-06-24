class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        HashSet<Integer>set = new HashSet<>();

        if(n == 0)return 0;

        //setting values into the set
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        for(int i=0;i<n;i++){
            int prev = nums[i] - 1;
            if(!set.contains(prev)){
                // starting point
                int start = nums[i];
                int len = 1;
                while(set.contains(start + 1)){
                    start++;
                    len++;
                }
                max = Math.max(max,len);
            }
        }
        return max;
    }
}
