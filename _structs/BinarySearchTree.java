package _structs;


public class BinarySearchTree<T extends Comparable>{

    protected class Node<T extends Comparable> {
        private Node<T> left = null;
        private Node<T> right = null;
        private T data;
        

        protected Node(T data) {
            this.data = data;
        }
        private int compareTo(Node<T> node){

            return data.compareTo(node.data);
        }
        public String toString(){
            if(data != null)
                return data.toString();
            else{
                return "";
            }  
        }
    }

    private Node<T> root = null;

    private int size = 0;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(T data) {
        root = new Node(data);
        size = 1;
    }

    private boolean insert(Node<T> item, Node<T> node) {
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
    private boolean insert(Node<T> node){
        return insert(node, root);
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
   private void inorder(Node<T> root){

    if(!(root.left == null))
            inorder(root.left);

    System.out.printf("%s\s\s", root.toString());

    if(!(root.right == null))
            inorder(root.right);
        
        
   }
   private void preorder(Node<T> root){

            System.out.printf("%s\s\s", root.data);

            if(!(root.left == null))
                preorder(root.left);
            if(!(root.right == null))
                preorder(root.right);
        
         
   }
   private void postorder(Node<T> root){
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
       Node<T> temp = new Node(item);
       if(temp.equals(root))
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
    protected T getMin(Node<T> node){
        T data = (T) node.data;
        while(node.left != null){
            data = (T) node.data;
            node = node.left;
        }
        return data;
    }
    protected Node<T> delete(T data, Node<T> node){

        if(node == null) return node;
        int compare = data.compareTo(node.data);

        if(compare ==  0){
                
            if(node.left == null && node.right == null){
                if(node.equals(root)){
                    this.root = null;
                }
                node = null;
                return null;
            }
            
          
            else if(node.left != null && node.right !=  null){
                
                Node<T> temp = node;
                T min = getMin(temp.right);
                node.data = min;
                delete(min, node.right);
                return null;
            
            }
        }
        if(compare < 0){
            if(node.left.data.equals(data)){
                if(node.left.left == null || node.left.right == null){
                    node.left = node.left.right;
                    return null;
                }
            }
            return delete(data, node.left);
        }
        if(compare > 0){
            if(node.right.data.equals(data)){
                if(node.right.right == null || node.right.left == null){
                    node.right = node.right.left;
                    return null;
                }
                return delete(data, node.right);
            }
        }
            return null;
        }
    
    public void delete(T data){
        delete(data, root);
    }
    public static void main(String[] args) 
    { 
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>(); 
  
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
        tree.preorderTraversal(); 
    } 
}
