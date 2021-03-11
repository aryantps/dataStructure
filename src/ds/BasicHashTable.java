package ds;
//X rep. key generic type
//Y rep. value generic type
public class BasicHashTable<X, Y> {
    //basic ds will be hash entry
    private HashEntry[] data;
    private int capacity; //total entries that can be kept
    private int size;

    public BasicHashTable(int tableSize) {
        this.capacity = tableSize;
        this.data = new HashEntry[this.capacity];
        this.size = 0;
    }

    //takes a key return value
    public Y get(X key) {
        //
    }

    public int size() {
        return this.size;
    }

    private int calculateHash(X key) {
        //
    }

    private class HashEntry<X, Y> {
        private X key;
        private Y value;

        public HashEntry(X key, Y value){
            this.key = key;
            this.value = value;
        }

        public X getKey() {
            return key;
        }

        public void setKey(X key) {
            this.key = key;
        }

        public Y getValue() {
            return value;
        }

        public void setValue(Y value) {
            this.value = value;
        }
    }
}
