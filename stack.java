import java.util.EmptyStackException;
public class stack<E>{
    Object[] data;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    public stack(){
        data = new Object[DEFAULT_CAPACITY];
    }
    public stack(int capacity){
        data = new Object[capacity];

    }
    public E peek(){
        if(size == 0)
        {
            throw new EmptyStackException();
            
        }
        return (E)data[size];
    }
    public E pop(){
        if(size == 0)
        {
            throw new EmptyStackException();
            
        }

        E top = (E)data[size];
        
        size--;
        return top;
    }
    public void push(E element){
        if(size == data.length){
            throw new StackOverflowError();
        }
        size++;
        data[size] = element;

    }
    
    

}