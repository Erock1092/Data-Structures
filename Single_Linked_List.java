package structs;
import java.util.Objects;
public class Single_Linked_List<E> implements List{
    private Node head;
    private int size;
    private class Node{
        private Node next = null;
        private E data;
        public Node(Object o){
            data = (E)o;
        }
        
    }
    /*
    Default Constructor initializes empty list with null head
    */
    public Single_Linked_List(){
        size = 0;
        head = null;
    }
    /*
    Constructor initializes list with object in parameter as head
    @param o the head of the list

    */
    public Single_Linked_List(Object o){
        size = 1;
        head = new Node(o);
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
    /*
    adds an element to the list
    @param o the object to add
    */
    public boolean add(Object o){
        if(head == null){
            head = new Node(o);
            size++;
            return true;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(o);
            size++;
            return true;
        }
        
    }
    public void add(int index, E elem){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
         
        }
        Node temp = head, prev = null;
        for(int i = 0; i < index; i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = new Node(elem);
        prev.next.next = temp;
        size++;
    }
    public int size(){
        return size;
    }
    /*

    */
    public E remove(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
         
        }
        Node temp = head, prev = null;
        if(index == 0){
            head = head.next;
            size--;
            return temp.data;
        }
        else{
            for(int i =0; i < index; i++){
                prev = temp;
                temp = temp.next;
            }
            
            prev.next = temp.next;
            size--;
            return temp.data;
        }
    }
    public E remove(Object o){
        Node temp = head, prev = null;
        if(temp != null && temp.equals(o)){
            head = temp.next;
            return temp.data;
        }
        while(!temp.data.equals(o) && !temp.equals(null)){
            prev = temp;
            temp = temp.next;
        }
        
        prev.next = temp.next;
        size--;
        return temp.data;
    }
    public void clear(){
        head = null;
        size = 0;
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
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
         
        }
        Node temp = head;
        if(index == 0){ 
            return temp.data;
        }
        else{
            for(int i =0; i < index; i++){
                
                temp = temp.next;
            }
            
            
            return temp.data;
        }
    }
    public void printList(){
        Node temp = head;
        for(int i = 0; i < size; i++){
            System.out.printf("%s ", temp.data);
            temp = temp.next;
        }
        System.out.println();
    }
    public int hashcode(){
        return Objects.hash(this);
    }
    public boolean isEmpty(){
        return size == 0;
    }
    
}
