import java.util.ArrayList;
public class Balanced_bst {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }

    public static void getinorder(Node root,ArrayList<Integer> inorder) {
        if(root == null){
            return;
        }
        getinorder(root.left,inorder);
        inorder.add(root.data);
        getinorder(root.right,inorder);
    }

    public static Node createBst(ArrayList<Integer>inorder,int st,int end) {
        int mid=(st+end)/2;
        if(st > end){   //base case
            return null;
        }
        Node root=new Node(inorder.get(mid));
        root.left=createBst(inorder,st,mid-1);
        root.right=createBst(inorder,mid+1,end);
        return root;
    }
    public static Node balancedbst(Node root) {
        //inorder traversal
        ArrayList<Integer> inorder=new ArrayList<>();
        getinorder(root,inorder);

        //sorted inorder-> balanced bst
        root=createBst(inorder,0,inorder.size()-1);
        return root;
    }   

    public static void preorder(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String[] args) {
        Node root=new Node(8);
         root.left=new Node(5);
         root.right=new Node(11);
         root.left.left=new Node(3);
         root.left.right=new Node(6);
         root.right.right=new Node(12);
         root.right.left=new Node(10);
         root=balancedbst(root);
         preorder(root);
    }
}
