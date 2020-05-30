package _structs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Graph<T> {
    private Map<T, LinkedList<T>> adjacencies; 
    
    public void addVertex(T vertex){
        if(adjacencies.containsKey(vertex)){
            throw new IllegalArgumentException();
        }
        adjacencies.put(vertex, new LinkedList<T>());
    }
    public Graph(){
        adjacencies = new HashMap<T, LinkedList<T>>();
    }
    public Graph(java.util.Collection<T> vertices){
        adjacencies = new HashMap<T, LinkedList<T>>(vertices.size());
        for(T data: vertices){
            adjacencies.put(data, new LinkedList<T>());
        }
    }
    public void connect(T from, T to){

        if(from == to){ throw new IllegalArgumentException(); }

        if(adjacencies.containsKey(from) && adjacencies.containsKey(to)){
            adjacencies.get(from).add(to);
            adjacencies.get(to).add(from);
        }
        
    }
    public boolean contains(T data){
        return adjacencies.containsKey(data);
    }
    public boolean remove(T data){
        LinkedList<T> temp = adjacencies.get(data);
        for(T vertice: temp){
            LinkedList<T> adj = adjacencies.get(vertice);
            adj.remove((Object) data);
        }
        return adjacencies.remove(data, temp);
    }
    public String toString(){
        StringBuilder string = new StringBuilder();
        for(T vertex: adjacencies.keySet()){

            string.append(vertex.toString() + ": ");

            for(T connections: adjacencies.get(vertex)){

                string.append(connections.toString() + " ");
            }
            string.append("\n");
        }
        return string.toString();
    }
}