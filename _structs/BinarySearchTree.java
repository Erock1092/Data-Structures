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
        if(root == null){

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
    protected T getMin(Node node){
        T data = (T) node.data;
        while(node.left != null){
            data = (T) node.data;
            node = node.left;
        }
        return data;
    }
    protected Node delete(T data, Node node){
        if(node == null) return node;
        
        if(data.compareTo(node.data) > 0){
                
            delete(data, node.right);
            
        }
            
        else if(data.compareTo(node.data) < 0){
                
            delete(data, node.left);
            
        }
        else{
            if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }
            node.data = getMin(node.right);
            node.right = delete((T) node.data, node.right);
        }
        return node;
    }
    
    public void delete(T data){
        delete(data, root);
    }
    public static void main(String[] args) 
    { 
        BinarySearchTree tree = new BinarySearchTree(); 
  
        /* Let us create following BST 
              50 
           /     \ 
          30      70 
         /  \    /  \ 
        20   40  60   80 */
        tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
  
        System.out.println("Inorder traversal of the given tree"); 
        tree.inorderTraversal(); 
  
        System.out.println("\nDelete 20"); 
        tree.delete(20); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorderTraversal(); 
  
        System.out.println("\nDelete 30"); 
        tree.delete(30); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorderTraversal(); 
  
        System.out.println("\nDelete 50"); 
        tree.delete(50); 
        System.out.println("Inorder traversal of the modified tree"); 
        tree.inorderTraversal(); 
    } 
}
