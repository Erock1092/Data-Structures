package _structs;


import java.util.LinkedList;

public class Hashmap<K,V> {
    private final static int SIZE = 10;
    private final static int NOT_FOUND = -1;
    private int numberOfMappings = 0;
    
    private class HashNode{
        private K key;
        private V value;

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
        private V getValue(K key){
            if(key.equals(this.key)){
                return value;
            }
            return null;
        }
        private boolean containsKey(K key){
            return this.key == key;
        }
        private void setValue(V value){
            this.value = value;
        }
    }

    private LinkedList<HashNode>[] hashmap;
    public Hashmap(){
        hashmap = new LinkedList[SIZE];
        for(int i = 0; i < SIZE; i++){
            hashmap[i] = new LinkedList<HashNode>();
        }
    }
    public Hashmap(int size){
        hashmap = new LinkedList[size];
        for(int i = 0; i < size; i++){
            hashmap[i] = new LinkedList<HashNode>();
        }
    }
    private int computeHash(K key){
        return key.hashCode();
    }
    public void put(K key, V value){
        int hash = computeHash(key);
        HashNode node = new HashNode(key, value);

        if(!hashmap[hash].contains(node)){
            int indexOfKey = containsKeyAt(key, hashmap[hash]);
            if(indexOfKey == NOT_FOUND){

                hashmap[hash].add(node);
                return;
            }
            else{
                
                hashmap[hash].get(indexOfKey).setValue(value); 
            }
        }
        numberOfMappings++;
    }
    public V get(K key){
        int hash = computeHash(key);
        for(HashNode node: hashmap[hash]){
            V temp = node.getValue(key);
            if(temp != null){
                return temp;
            }
        }
        return null;
    }
    private int containsKeyAt(K key, LinkedList<HashNode> lis){

               for(int i = 0; i < lis.size(); i++){
                   if(lis.get(i).containsKey(key)) {
                       return i;
                   }
               }

           return NOT_FOUND;
    }
    public void clear(){
        for(LinkedList<HashNode> lis: hashmap){
            lis.clear();
        }
        numberOfMappings = 0;
    }
    public boolean isEmpty(){
        return numberOfMappings == 0;
    }
    public V replace(K key, V value){
        int keyIndex = containsKeyAt(key, hashmap[computeHash(key)]);
        if(keyIndex == -1){
            return null;
        }
        V oldValue = null;
        for(int i = 0; i < hashmap[computeHash(key)].size(); i++){
            HashNode node = hashmap[computeHash(key)].get(i);
            K nodeKey = node.key;
            if(nodeKey == key){
                oldValue = node.value;
                node.setValue(value);
                return oldValue;
            }
        }
        return oldValue;

    }
}