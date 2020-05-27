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
            if(node.left == null){
                node.left = item;
            }
            else{
                insert(item, node.left);
            }
        }
        else if(item.compareTo(node) >= 0){
            if(node.right == null){
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
        if(root.data == null){

            root = new Node(data);
            return true;
        }
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

    if(!(root.left == null))
            inorder(root.left);

    System.out.printf("%s\s\s", root.data);

    if(!(root.right == null))
            inorder(root.right);
        
        
   }
   private void preorder(Node root){

            System.out.printf("%s\s\s", root.data);

            if(!(root.left == null))
                preorder(root.left);
            if(!(root.right == null))
                preorder(root.right);
        
         
   }
   private void postorder(Node root){
    if(!(root.left == null))
        postorder(root.left);
    if(!(root.right == null))    
        postorder(root.right);

           System.out.printf("%s\s\s", root.data);
        
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
    public boolean isEmpty(){
        return size() == 0;
    }

}
