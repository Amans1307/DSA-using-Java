import java.util.*;
public class build {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            
        }
    }
//Inorder traversal 
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
//Insertion 
    public static Node insert(Node root,int val) {
        if (root == null) {
            root=new Node(val);
            return root;
        }

        if (root.data > val) {
            //left subtree
            root.left=insert(root.left, val);
        }
        else{
            //right subtree
            root.right=insert(root.right, val);
        }
        return root;
    }
//searching
     public static boolean search(Node root,int key) {      //O(n)
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        else if(root.data > key){
            return search(root.left, key);
        }
        else{
            return search(root.right, key);
        }
    }
//deleting
    public static Node delete(Node root,int key) {
        if (root.data < key) {
            root.right = delete(root.right, key);
        }
        else if (root.data > key) {
            root.left=delete(root.left, key);
        }
        else{//voila
            //case-1  -  leaf node
            if (root.left == null && root.right == null) {
                return null;
            }
            //case-2 -  only one child
            if (root.left == null) {
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case -3 - two child
            Node IS=findInorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right, IS.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root=root.left;
        }
        return root;
    }

    public static void print_in_range(Node root,int k1,int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            print_in_range(root.left, k1, k2);
            System.out.print(root.data+" ");
            print_in_range(root.right, k1, k2);
        }else if(root.data > k2){
            print_in_range(root.right, k1, k2);
        }
        else{
            print_in_range(root.left, k1, k2);
        }
    }
    public static void printpath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println("null");
    }
    public static void printroot2leaf(Node root,ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {//base case
            printpath(path);
        }
        printroot2leaf(root.left, path);
        printroot2leaf(root.right, path);
        path.remove(path.size()-1);
    }

    private static boolean isValid(Node root ,Node min ,Node max) {
        if (root == null) {
            return true;
        }
        if (min !=null && root.data <= min.data) {
            return false;
        }
        else if (max!=null && root.data >= max.data) {
            return false;
        }
        return isValid(root.left, min, root)&&isValid(root.right, root, max);
    }

    public static void main(String[] args) {
        //int key=7;
        //int k1=5, k2=12;
        int values[]={8,5,3,6,10,11,14};
        Node root=null;

         for (int i = 0; i < values.length; i++) {
            root=insert(root, values[i]);
         }
        ///inorder(root);
        // System.out.println();
        //  if (search(root, key)) {
        //      System.out.println("found");
        //  } 
        //  else{
        //      System.out.println("not found");
        //  }
        // root = delete(root, key);
        //System.out.println();
        //inorder(root);
        //print_in_range(root, k1, k2);
        //System.out.println();
        //printroot2leaf(root,new ArrayList<>());
        if (isValid(root, null, null)) {
            System.out.println("valid");
        } else{
            System.out.println("Invalid");
        }
    }
}