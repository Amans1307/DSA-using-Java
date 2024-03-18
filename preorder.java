import java.util.*;
public class preorder { //time complexity->O(n)
    static class Node{      //binary tree class
        int data;
        Node left;
        Node right;

        Node(int data){        // constructor
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    static class Binarytree{
        static int idx=-1;//static type bcoz in every recursion call it must be change
        public static Node buildtree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode=new Node(nodes[idx]);
            newNode.left=buildtree(nodes);
            newNode.right=buildtree(nodes);

            return newNode;
        }
        public static void preorderT(Node root) {
            if (root==null) {  // base case for empty tree or leaf node accessing
                return;
            }
            System.out.print(root.data+" ");
            preorderT(root.left);
            preorderT(root.right);
        }

        public static void inorderT(Node root) {
            if (root==null) {  // base case for empty tree or leaf node accessing
                return;
            }  
            inorderT(root.left);
            System.out.print(root.data+" ");
            inorderT(root.right);
        }

        public static void postorderT(Node root) {
            if (root==null) {  // base case for empty tree or leaf node accessing
                return;
            }  
            postorderT(root.left);
            postorderT(root.right);
            System.out.print(root.data+" ");
        }

        //level order traversal
        public static void levelorder(Node root) {
           if (root==null) {
            return;
           } 

           Queue<Node> q =new LinkedList<>();
           q.add(root);
           q.add(null);

           while (!q.isEmpty()) {
                Node currNode=q.remove();
                if (currNode==null) {//condition of null 
                     System.out.println();
                     if (q.isEmpty()) {
                        break;
                     }
                     else{
                        q.add(null);
                     }
                }else{
                    System.out.print(currNode.data+" ");
                    if (currNode.left!=null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right!=null) {
                        q.add(currNode.right);
                    }
                }
           }
        }
    }

    

    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Binarytree tr=new Binarytree();// object
        Node root=tr.buildtree(nodes);
        //System.out.println(root.data);
        // tr.preorderT(root);//member function
        // System.out.println();
        // tr.inorderT(root);
        // System.out.println();
        // tr.postorderT(root);
        tr.levelorder(root);
    }
}