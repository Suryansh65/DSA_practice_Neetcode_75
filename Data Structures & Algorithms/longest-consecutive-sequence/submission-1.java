class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer>set = new HashSet<>();
        int longest = 0;
        // Filling the HashSet
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }

        for(int i=0;i<n;i++){
            int prev = nums[i] - 1;
            if(!set.contains(prev)){
                //May be this num is starting point
                int start = nums[i];
                int length = 1;

                while(set.contains(start + 1)){
                    start++;
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;

    }
}
