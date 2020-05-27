package _structs;


public class BinarySearchTree<T extends Comparable>{

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
        size++;
        return true;
    }
    protected boolean insert(Node item){
        return insert(item, root);
    }
    public boolean insert(T data){
        return insert(new Node(data));
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
   public int size(){
       return size;
   }
 
   protected T get(T item){
       Node temp = root;
       if(temp == root)
        return (T)root.data;

        while(!item.equals(temp.data)){

            if(temp.data.compareTo(item) == 0){
                return (T)temp.data;
            }
            else if(temp.data.compareTo(item) < 0){
                temp = root.left;
            }
            else{
                temp = root.right;
            }
        }
        return null;
   }
   protected Node contains(Node node, T item){
       int compare = item.compareTo(node.data);
       if(compare == 0){
           return node;
        }
        else if(compare < 0){
            contains(node.left, item);
        }
        else{
            contains(node.right, item);}
        return null;
        
    }
    public boolean contains(T item){
        return !contains(root, item).equals(null);
    }
    public boolean isEmpty(){
        return size() == 0;
    }
    public boolean remove(T item){
        return !remove(item, root).equals(null);
    }
    protected Node remove(T item, Node node){
        if(contains(item)){
            if(item.compareTo(node.data) == 0){
                Node temp = node;
                node.data = removeMinumum(node.right);
                size--;
                return temp;
            }
            else if(item.compareTo(node.data) < 0){
                remove(item, node.left);
            }
            else if(item.compareTo(node.data) > 0){
                remove(item, node.right);
            }
        }
        return null;
    }
    protected T removeMinumum(Node node){
        Node temp = node;
        while(!temp.equals(null)){
            temp = temp.left;

    }
        T data = (T) temp.data;
        node = null;
        return data;
    }
}
