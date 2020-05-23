package _structs;

import java.util.Arrays;
import java.util.Collections;

public class ArrayList<E> implements List {
    
    private E[] data;
    private final int DEFAULT_CAPACITY = 10;
    private int size = 0;
  
    
    /*
        Default Constructor declares array with default capacity
    */
    public ArrayList(){
        
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
        
    }
    /*
        Copy constructor casts array to ArrayList
        @param data the array being cast to ArrayList
    */
    public ArrayList(Object[] data){
        this.data = (E[])Arrays.copyOf(data, data.length + (data.length >> 1));
        size = data.length - Collections.frequency(Arrays.asList(data), null);
        
    }
    /*
        Constructor allocates ArrayList capacity to int in the parameter
        @param capacity the capacity by which to set local capacity.
    */
    public ArrayList(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
       
    }
    public void clear(){
        size = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    @Override
    public int size() {
        
        return size;
    }

    @Override
    public void add(int index, Object e) {
        if(data.length == size){
            ensureCapacity(size + (size >> 1));
        }
        for(int i = size; i > index; i--){
            data[i] = data[i-1];
        }
        data[index] = (E)e;
        size++;
        
    }

    @Override
    public boolean add(Object element){
        add(size, element);
        return true;
    }

    

    @Override
    public boolean contains(Object o) {
        for(Object e: data){
            if(e.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index) {
        if(index > size){
            throw new ArrayIndexOutOfBoundsException();
        }
        return data[index];
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        for(Object e: data){
            if(o.equals(e)){
                return index;
            }
            index++;
        }
        return -1; // Object not found
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E remove(int index) {
        Object temp = data[index]; 
        for(int i = index; i < size; i++){
            data[i] = data[i + 1];
        }
        size--;
        return temp;
    }

    @Override
    public E remove(Object o) {
        if(contains(o) && !o.equals(null)){
            int index = indexOf(o);
            return remove(index);
           
        }
        return null;
    }
    public void ensureCapacity(int minCapacity){
        if(data.length < minCapacity){
            data = Arrays.copyOf(data, minCapacity);
            
            
        }
        return;
    }
    public void trimToSize(){
        data = Arrays.copyOf(data, size);
    }
    public void printList(){
        for(int i = 0; i < size; i++){
            
            System.out.printf("%s ", data[i].toString());
        }
        System.out.println();
    }
    public void set(int index, E element){

        data[index] = element;
    }
    


    
}
