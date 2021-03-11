package ds;


/** <p>Represents an stack data structure</p>
 * @author Aryant
 */
public class BasicStack<X>{
    private X [] data; //data - primitive array of type X
    private int stackPointer; //internal pointer on data st

    /**
     * <p>Constructor to initialize array</p>
     */
    public BasicStack(){
        data = (X[]) new Object[1000];  //size is 1000
        stackPointer = 0;
    }


    /**
     * <p>Method to insert/push into stack</p>
     * @param newItem item which has to be pushed
     */
    public void push(X newItem){
        data[stackPointer++] = newItem; //++ is post-increment => first value assign then increment
    }


    /**
     * <p>Method to delete/pop from stack</p>
     * (Note : Not actually deleting just decrement stackPointer)
     * @return return item which is popped out from stack
     */
    public X pop(){
        if (stackPointer==0) {
            throw new IllegalStateException("Nothing in the stack");
        }
        return data[--stackPointer]; //pre-decrement => decrement first then return
    }


    /**
     * <p>Method to check if item exists in stack</p>
     * @param item item which has to be checked
     * @return return true if stack contains item otherwise false
     */
    public boolean ifContains(X item) {
        boolean found = false;

        for (int i=0;i < stackPointer; i++) {
            if (data[i].equals(item)) {
                found = true;
                break;
            }
        }
        return  found;
    }

    /**
     * <p>Method to check if item exists in stack</p>
     * @param item item which has to be checked
     * @return return item if found
     */
    public X access(X item) {
        while (stackPointer > 0) {
            X tempItem = pop();
            if (item.equals(tempItem)) {
                return tempItem;
            }
        }
        // if item not found in stack throw exception
        throw new IllegalArgumentException("Could not Find item in stack: " + item);
    }

    /**
     * <p>Method to give size of stack</p>
     * @return return size of stack
     */
    public int size() {
        return stackPointer;
    }

    /**
     * <p>Method to return top element of stack</p>
     * @return Returns top element of stack
     */
    public X peek(){
        if (stackPointer >= 0){
            return data[stackPointer];
        }
        throw new IllegalStateException("Nothing in the stack");
    }

    /**
     * <p>Method to traverse the stack</p>
     */
    public void traverse(){
        for (int index = 0;index <= stackPointer; index++) {
            System.out.print("At "+index+" = "+ data[index]);
            System.out.println();
        }
    }

}
