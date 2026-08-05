class TimeMap {
    class Pair{
        String val;
        int time;
        Pair(String val, int timestamp){
            this.val = val;
            this.time = timestamp;
        }
    }
    HashMap<String,ArrayList<Pair>>map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new ArrayList<>());
        }
        map.get(key).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<Pair>p = map.get(key);
        int l = 0;
        int r = p.size()-1;
        String ans = "";
        while(l <= r){
            int mid = l + (r-1) / 2;
            if(p.get(mid).time <= timestamp){
                ans = p.get(mid).val;
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return ans;

    }
}
