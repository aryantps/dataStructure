package ds;

/** <p>Represents an queue data structure</p>
 * @author Aryant
 */
public class BasicQueue<X> {
    private X[] data; //data - primitive array of type X
    private int front;
    private int end;

    //constructor if size is passed
    public BasicQueue(int size) {
        this.front = -1; //represent empty queue
        this.end = -1;   ////represent empty queue
        data = (X[])new Object[size];
    }

    //default constructor
    public BasicQueue() {
        this(1000);
    }

    public int size(){
        //if queue is empty
        if (front==-1 && end==-1) {
            return 0;
        }else {
            return end - front + 1;
        }
    }

    public void enQueue(X item) {
        //if queue if full
        if ((end + 1) % data.length ==front) {
            throw new IllegalStateException("Queue is full");
        }
        //if queue is empty => no item till now
        else if (size() == 0) {
            front++;
            end++;
            data[end] = item;
        }else {
            end = end + 1;
            data[end] = item;
        }
    }

    public X deQueue() {
        X item = null; //placeholder

        //if queue is empty
        if (size() == 0){
            throw new IllegalStateException("Queue is already EMPTY");
        }
        // if this is last item on queue
        else if (front == end) {
            item = data[front];
            data[front] = null; //freeing memory
            front = -1;
            end = -1;
        }
        //otherwise
        else {
            item = data[front];
            data[front] = null; //freeing memory
            front = front + 1;
        }

        return item;
    }

    public boolean ifContains(X item){
        boolean found = false;

        //if empty queue
        if (size()==0){
            return false;
        }
        for (int i=front; i < end; i++) {
            if(data[i] == item) {
                found = true;
                break;
            }
        }
        return found;
    }

    public X peekAt(int position){
        if (size() == 0 || position > size()) {
            throw new IllegalArgumentException("INVALID position argument");
        }else
        return data[front + position];
    }
}
