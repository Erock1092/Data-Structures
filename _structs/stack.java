package _structs;
import java.util.EmptyStackException;
public class Stack<E>{
    Object[] data;
    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    public stack(){
        data = new Object[DEFAULT_CAPACITY];
    }
    public Stack(int capacity){
        data = new Object[capacity];

    }
    public E peek(){
        if(empty())
        {
            throw new EmptyStackException();
            
        }
        return (E)data[size];
    }
    public E pop(){
        if(empty())
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
        data[size] = element;
        size++;

    }
    public boolean empty(){
        return size == 0;
    }
    public int search(Object object){
        int position = size;
        while(position >= 0){
            if(object.equals(data[position])){
                return position;
            }
            position--;
        }
        return -1;
    }
}
