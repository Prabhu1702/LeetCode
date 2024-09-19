

class LRUCache {

    class Node {
        int key, value;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private HashMap<Integer, Node> cache; // stores key and reference to the node in the doubly linked list
    private Node head, tail; // MRU at head, LRU at tail

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0, 0); // Dummy head node
        tail = new Node(0, 0); // Dummy tail node
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Key not found
        }
        Node node = cache.get(key);
        moveToHead(node); // Move the accessed node to the head (MRU)
        return node.value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value; // Update the value
            moveToHead(node); // Move the updated node to the head (MRU)
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode); // Add new node at the head (MRU)
            
            if (cache.size() > capacity) {
                Node lru = popTail(); // Remove the least recently used node
                cache.remove(lru.key); // Remove it from the map
            }
        }
    }

    // Helper function to add a new node to the head (MRU)
    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Helper function to remove a node from its current position
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper function to move a node to the head (MRU)
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    // Helper function to pop the tail (LRU node)
    private Node popTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */