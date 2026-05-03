class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        // create HashMap
        HashMap<Integer, Integer> map = new HashMap<>();

        // Filling of Hashmap
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // creating bucket
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();

        // Filling emty bucket
        for (int i = 0; i <= n; i++) {
            bucket.add(new ArrayList<>());
        }

        // Filling bucket
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();
            bucket.get(freq).add(num);
        }
        ArrayList<Integer> res = new ArrayList<>();
        // Loop from the end to beginning
        for (int j = n; j > 0; j--) {
            for (int i : bucket.get(j)) {
                res.add(i);
                k = k -1;
                if(k == 0)return ArraylistToArray(res);
            }
        }
        return ArraylistToArray(res);

    }

    public int[] ArraylistToArray(ArrayList<Integer> res){
        // Converting ArrayList into int array
        int ans[] = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
