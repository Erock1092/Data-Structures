
package _structs;
import java.util.Objects;


public class DoubleLinkedList<E> implements List {
    @SuppressWarnings("All")
    private int size = 0;
    private Node head = null;
    /*
        Nested Node class contains references encapsulated data, previous node and next node.
        Uses generic element type.
        @author Eric Ackley
        @version 1.0
    */
    private class Node{
        private Node last = null;
        private Node next = null;
        private E data;
        /*
            Default Node constructor initializes all references to null
            @author Eric Ackley
            @version 1.0
        */
        public Node(){
            
            data = null;
        }
        /*
            Node constructor encapsulates object in the paramater.
            @param o object to be encapsulated
            @author Eric Ackley
            @version 1.0
        */
        public Node(Object o){
            data = (E)o;
        }
        /*
            toString returns data as a String
            @returns data as string
        */
        public String toString(){
            return data.toString();
        } 
        
    }
    public DoubleLinkedList(){
        head = null;
        size = 0;

    }
    public DoubleLinkedList(Object o){
        head = new Node(o);
        size = 1;

    }
    public boolean add(Object o){
        if(head.equals(null)){
            head = new Node(o);
        }
        Node temp = head;
        while(!temp.next.equals(null)){
            temp = temp.next;
        }
        Node toAdd = temp.next;
        toAdd.next  = new Node(o);
        toAdd.last = temp;
        return true;
    }
    public void add(int index, Object o){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node temp = head; 
        if(index == 0){
            head = new Node(o);
            head. next = temp;
            size++;
            return;

        }
        Node next = temp.next;
        for(int i  = 0; i < index; i++){
            
            temp = temp.next;
            next = temp.next;
        }
        Node toAdd = new Node(o);
        // relink each reference so that the added node is 
        temp.next = toAdd;
        toAdd.next = next;
        toAdd.last = temp;
        size++;
    
    }
    public void clear(){
        head = null;
    }
    public E remove(Object o){
        Node temp = head;
        if(temp.equals(o)){
            head = head.next;
            return (E)temp.data;
        }
        Node prev = null, next = head.next;
        while(!o.equals(temp) || !temp.equals(null)){
            prev = temp;
            temp = next;
            next = next.next;           
        }
        prev.next = next;
        next.last = prev;
        return (E)temp.data;
    }
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node temp = head, prev = null, next = head.next;
        for(int i = 0; i < index; i++){
            prev = temp;
            temp = next;
            next = next.next;

        }
        
        
        prev.next = next;
        next.last = prev;
        
        size--;
        return (E)temp.data;

    }
    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.printf("%s ", temp.toString());
            temp = temp.next;
        }
    }
    public boolean contains(Object o){
        Node temp = head;
        for(int i = 0; i < size; i++){
            if(temp.data.equals(o)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int indexOf(Object o){
        Node temp = head;
        for(int index = 0; index < size; index++){
            if(temp.data.equals(o)){
                return index;
            }
            temp = temp.next;
        }
        return -1;
    }
    public int size(){
        return size;
    }
    public int hashcode(){
        return Objects.hash(this);
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
         
        }
        Node temp = head;
        if(index == 0){ 
            return (E)temp.data;
        }
        else{
            for(int i =0; i < index; i++){
                
                temp = temp.next;
            }
            
            
            return (E)temp.data;
        }

    }
   
}

