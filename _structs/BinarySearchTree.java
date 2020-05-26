package _structs;

import java.util.Iterator;

public class BinarySearchTree<T extends Comparable> implements Iterable<T> {

    protected class Node<T extends Comparable> {
        private Node left = null;
        private Node right = null;
        private T data;

        protected Node(T data) {
            this.data = data;
        }
        private int compareTo(Node node){

            return data.compareTo(node.data);
        }
    }

    private Node root = null;

    protected int size = 0;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(T data) {
        root = new Node(data);
        size = 1;
    }

    protected boolean insert(Node item, Node node) {
        if (item.compareTo(node) < 0) {
            if(node.left.equals(null)){
                node.left = item;
            }
            else{
                insert(item, node.left);
            }
        }
        else if(item.compareTo(node) >= 0){
            if(node.right.equals(null)){
                node.right= item;
            }
            else{
                insert(item, node.right);
            }
        }
        return true;
    }
    protected boolean insert(Node item){
        return insert(item, root);
    }
    public boolean insert(T data){
        return insert(new Node(data));
    }
    
    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
   public void inorderTraversal(){
      inorder(root);
   }
   public void preorderTraversal(){
       preorder(root);
   }
   public void postorderTraversal(){
       postorder(root);
   }
   private void inorder(Node root){
        if(!root.equals(null)){
            inorder(root.left);
            System.out.printf("%s\s\s", root.data);
            inorder(root.right);
        }
   }
   private void preorder(Node root){
       if(!root.equals(null)){
            System.out.printf("%s\s\s", root.data);
            preorder(root.left);
            preorder(root.right);
        }

   }
   private void postorder(Node root){
       if(!root.equals(null)){
           postorder(root.left);
           postorder(root.right);
           System.out.printf("%s\s\s", root.data);
        }
   }
}