package _structs;



public class MinHeap {

    private static final int DEFAULT_CAPACITY = 20;
    private int size;
    private int heap[];
    private int capacity;
    public MinHeap(){

        heap = new int[DEFAULT_CAPACITY];
        size = 0;
        heap[0] = Integer.MIN_VALUE;
        capacity = DEFAULT_CAPACITY;
    }
    public MinHeap(int capacity){
        heap = new int[capacity + 1];
        size = 0;
        heap[0] = Integer.MIN_VALUE;
        this.capacity = capacity;

    }
    private int getParent(int index){
        return index /2;
    }
    private int getLeft(int index){
        return (index*2);
    }
    private int getRight(int index){
        return (index * 2) + 1;
    }
    private boolean isLeaf(int pos){
        return (pos >= size/2 && pos <= size);
    }
    private void heapify(int pos){
        if(!isLeaf(pos)){ 
            if(heap[pos] > heap[getLeft(pos)] || heap[pos] > heap[getRight(pos)]){
                if(heap[getRight(pos)] > heap[getLeft(pos)]){
                    swap(pos, getLeft(pos));
                    heapify(getLeft(pos));
                }
                else if(heap[getLeft(pos)] > heap[getRight(pos)]){
                    swap(pos, getRight(pos));
                    heapify(getRight(pos));
                }
        
            }
        }
    }
    public int remove(){
        int pop = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return pop;
    }
    public void insert(int item){
        if(size  > capacity){
            return;
        }
        System.out.printf("inserting %d%n", item);
        size++;
        heap[size] = item;
        int currentIndex = size;
        while(heap[currentIndex] < heap[getParent(currentIndex)]){
            swap(currentIndex, getParent(currentIndex));
            currentIndex = getParent(currentIndex);
        }
    }
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public void print(){
       for(int i = 1; i < size; i++)
        System.out.println(heap[i]);
    }
    public void minHeap() 
    { 
        for (int pos = (size / 2); pos >= 1; pos--) { 
            heapify(pos); 
        } 
    } 
    
}