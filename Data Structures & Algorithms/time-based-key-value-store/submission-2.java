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
        String value = "";
        if(map.containsKey(key)){
            for(Pair pair: map.get(key)){
                String v = pair.val;
                int t = pair.time;
                if(t <= timestamp){
                    value = v;
                }
            }
        }
        return value;

    }
}
