class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer>map = new HashMap<>();
        List<Integer>[] buc = new ArrayList[n+1];
        for(int i=0;i<buc.length;i++){
            buc[i] = new ArrayList<>();
        }
        List<Integer>ans = new ArrayList<>();

        //Filling the map
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        //Filling the bucket
        for(Map.Entry<Integer,Integer>entry: map.entrySet()){
            buc[entry.getValue()].add(entry.getKey()); 
        }

        //Finding out kth frequent number
        for(int j = buc.length-1;j>=0 && k > 0;j--){
            if(buc[j].size() == 0)continue;
            for(int t:buc[j]){
                if(k == 0)break;
                ans.add(t);
                k--;
            }
        }
        int res[] = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}
