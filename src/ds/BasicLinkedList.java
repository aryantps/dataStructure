package ds;

public class BasicLinkedList<X> {
    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList(){
        first = null;
        last = null;
        nodeCount = 0;
    }

    public void add(X item){
        //if adding for first time
        if (first == null) {
            first = new Node(item);
            last = first;
        }
        //otherwise add at last of LL
        else {
            Node newLastNode = new Node(item);
            last.setNextNode(newLastNode);
            last = newLastNode;
        }
        nodeCount++;
    }

    //insert at a given position
    public void insert(X item, int position){
        if (size() < position){
            throw new IllegalStateException("Linked List is smaller than the position entered !!");
        }

        Node currentNode = first;
        //search node that is will be just below new inserted node
        for (int i = 1; i < position; i++) {
            currentNode = currentNode.getNextNode();
        }

        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        nodeCount++;
    }

    //removes from front
    public X remove(){
        //if LL is empty
        if (first == null) {
            throw new IllegalStateException("Linked List is already empty");
        }
        X nodeItem = first.getNodeItem();

        //update first pointer
        first = first.getNextNode();
        nodeCount--;
        return nodeItem;

    }

    public X removeAt(int position) {
        if (first == null) {
            throw new IllegalStateException("Linked list is already empty");
        }

        Node currentNode = first;
        Node prevNode = first;

        for (int i = 1; i < position; i++){
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        X nodeItem = currentNode.getNodeItem();
        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;
        return nodeItem;
    }

    public X peekAt(int position){
        if(size() < position){
            throw new IllegalArgumentException("Index out of bound");
        }
        else if (first == null) {
            throw new IllegalStateException("Linked List is empty and nothing to peek at");
        }
        else{
            Node currentNode = first;
            for (int i = 0; i < size() && currentNode != null; i++) {
                if (i == position){
                    return currentNode.getNodeItem();
                }
                currentNode = currentNode.getNextNode();
            }
        }
        //if didn't find anything
       return null;

    }

    //find position of first occurrence of item
    public int find(X item) {
        if (first == null) {
            throw new IllegalStateException("Linked List is empty and noting to find !");
        }
        Node currentNode = first;
        for (int i = 0; i < size() && currentNode != null; i++) {
            if (currentNode.getNodeItem().equals(item)) {
                return i;
            }
            currentNode = currentNode.getNextNode();
        }
        // if did not find anything
        return -1;
    }

    public String toString(){
        StringBuffer contents = new StringBuffer();
        Node currentNode = first;

        while (currentNode != null) {
            contents.append(currentNode.getNodeItem());
            currentNode = currentNode.getNextNode();

            if (currentNode != null){
                contents.append(" => ");
            }
        }
        return contents.toString();
    }

    public int size(){
        return nodeCount;
    }

    private class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(X item){
            this.nextNode = null;
            this.nodeItem = item;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public X getNodeItem() {
            return nodeItem;
        }

        public void setNodeItem(X nodeItem) {
            this.nodeItem = nodeItem;
        }
    }
}
