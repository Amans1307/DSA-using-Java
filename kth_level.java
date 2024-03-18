import java.lang.System.Logger.Level;
import java.util.ArrayList;
public class kth_level {
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
public static boolean getPath(Node root,int n,ArrayList<Node> path) {
    if (root == null) {
        return false;
    }
    path.add(root);
    if (root.data == n) {
        return true;
    }

    boolean foundleft= getPath(root.left, n, path);
    boolean foundright= getPath(root.right, n, path);
    if (foundleft || foundright) {
        return true;
    }
    path.remove(path.size()-1);
    return false;
}

    public static Node lca(Node root,int n1,int n2) {//O()
        ArrayList<Node> path1=new ArrayList<>();
        ArrayList<Node> path2=new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);

        //last common ancestor
        int i=0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if(path1.get(i) != path2.get(i)){
                break;
            } 
        }
        //last equal node -> i-1th
        Node lca=path1.get(i-1) ;
        return lca;
    }

    public static Node lca2(Node root,int n1,int n2) {//O(n)
        if (root == null) {// base case
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        Node leftlca=lca2(root.left, n1, n2);
        Node rightlca=lca2(root.right, n1, n2);
        //leftlca=val rightlca=null
        if (rightlca == null) {
            return leftlca;
        }
        if (leftlca == null) {
            return rightlca;
        }
        return root;
    }

    public static int lcadistance(Node root,int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftdist=lcadistance(root.left, n);
        int rightdist=lcadistance(root.right, n);
        
        if (leftdist==-1 && rightdist==-1) {
            return -1;
        }else if(leftdist==-1){
            return rightdist+1;
        }
        else{
            return leftdist+1;
        }
    }

    public static int mindist(Node root,int n1,int n2) {
        Node lca=lca2(root, n1, n2);
        int dist1=lcadistance(lca,n1);
        int dist2=lcadistance(lca,n2);
        return dist1+dist2;
    }


    public static int kth_ancestor(Node root,int k,int n) {
        if (root == null) { //base case
            return -1;
        }
        if (root.data == n) {
            return 0;
        }
        int leftdistance=kth_ancestor(root.left, k, n);
        int rightdistance=kth_ancestor(root.right, k, n);
        if (leftdistance == -1 && rightdistance == -1) {
            return -1;
        }
        int max=Math.max(leftdistance, rightdistance);
        if (max+1 == k) {
            System.out.println(root.data);
        }
        return max+1;
    }

    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }
        int leftchild=transform(root.left);
        int rightchild=transform(root.right);
        int data=root.data;

        int newLeft = root.left==null?0:root.left.data;
        int newright = root.right==null?0:root.right.data;
        root.data=newLeft+leftchild+newright+rightchild;
        return data;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3  
             / \   \
            4   5   6
         */
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);
        //int n1=4,n2=6;
        //System.out.println(lca(root, n1, n2).data );
        //System.out.println(lca2(root, n1, n2).data);
        //System.out.println(mindist(root, n1, n2));
        //int k=2,n=5;
        //kth_ancestor(root, k, n);
        transform(root);
        preorder(root);
    }
}
