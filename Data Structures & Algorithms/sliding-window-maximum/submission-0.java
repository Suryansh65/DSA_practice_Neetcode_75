class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer>ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(!dq.isEmpty() && dq.getFirst() <= i-k){
                dq.removeFirst();
            }
            while(!dq.isEmpty() && nums[dq.getLast()]<= nums[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            if(i >= k-1){
                ans.add(nums[dq.peekFirst()]);
            }
        }
        //Coverting arraylist to array
        int res[] = new int[ans.size()];
        for(int i=0;i<res.length;i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
