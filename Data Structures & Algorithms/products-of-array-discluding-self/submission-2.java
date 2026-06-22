class Solution {
    public int[] productExceptSelf(int[] nums) {
         int n = nums.length;
        int ans[] = new int[n];
         int arrl[] = new int[n];
         int arrr[] = new int[n];

         arrl[0] = 1;
         arrr[n-1] = 1;
         //Filling arrl
         for(int i=1;i<n;i++){
            arrl[i] = arrl[i-1] * nums[i-1];
         }

         //Filling arrr
         for(int i=n-2;i>=0;i--){
            arrr[i] = arrr[i+1] * nums[i+1];
         }
         for(int j=0;j<n;j++){
            ans[j] = arrl[j] * arrr[j];
         }
         return ans;
    }
}  
