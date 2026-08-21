class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Node head;
    private final Node tail;
    private final HashMap<Integer,Node>map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;

    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        Node n = map.get(key);
        moveTohead(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.value = value;
            map.put(key,n);
            moveTohead(n);
        }else{
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            addTohead(newNode);

            if(map.size() > capacity){
                Node tail = removeTail();
                map.remove(tail.key);
            }
        }
    }

    // Operations
    public void addTohead(Node node){
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    // Remove node
    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public Node removeTail(){
        Node t = tail.prev;
        removeNode(t);
        return t;
    }

    public void moveTohead(Node node){
        removeNode(node);
        addTohead(node);
    }
}
