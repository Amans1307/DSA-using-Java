import java.lang.System.Logger.Level;
import java.util.ArrayList;

//Brute force to calculate diameter of tree
public class height {
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
    //calculate height of the tree
    public static int heightoftree(Node root) {
        if (root==null) {
            return 0;
        }
        int lh=heightoftree(root.left);
        int rh=heightoftree(root.right);
        return Math.max(lh, rh)+1;
    }

    public static int diameter(Node root) {
        if (root==null) {
            return 0;
        }
        int ldiameter=diameter(root.left);
        int rdiameter=diameter(root.right);
        int lh=heightoftree(root.left);
        int rh=heightoftree(root.right);
        int self=lh+rh+1;
        return Math.max(self,(Math.max(ldiameter,rdiameter)));
    }

    static class info{
        int height;
        int diameter;

        public info(int dimtr,int ht){
            this.height=ht;
            this.diameter=dimtr;
        }
    }

    public static info diametr_optimised(Node root) {
        if (root==null) {
            return new info(0, 0);//object returning
        }
        info linfo=diametr_optimised(root.left);
        info rinfo=diametr_optimised(root.right);
        int Fdiameter=Math.max(Math.max(linfo.diameter, rinfo.diameter),linfo.height+rinfo.height+1);
        int Fheight=Math.max(linfo.height, rinfo.height)+1;
        info i=new info(Fdiameter, Fheight);//object
        return i;
    }

    public static boolean isIdentical(Node root,Node subroot) {//subroot in root tree milne ke bad element ki value same h ki ni check krenge 
        if (root == null && subroot==null) {
            return true;
        }else if(root==null || subroot==null || root.data!=subroot.data){
            return false;
        }
        if (!isIdentical(root.left, subroot.left)) {
            return false;
        }
        if (!isIdentical(root.right, subroot.right)) {
            return false;
        }
        return true;
    }

    public static boolean same(Node root,Node subroot) {//work of this function:->subroot kaha lie krti h in root 
        //base case
        if (root == null) {
            return false;
        }
        if (root.data == subroot.data) {
            if (isIdentical(root,subroot)) {
                return true;
            }
        }

        return isIdentical(root.left, subroot) || isIdentical(root.right, subroot);// check subroot in left nd right subnode of tree
    }

    // //calculate count of nodes in tree 
    // public static int countoftree(Node root) {
    //     if (root==null) {
    //         return 0;
    //     }
    //     int lcount=countoftree(root.left);
    //     int rcount=countoftree(root.right);
    //     return lcount+rcount+1;
    // }

    // //sum of the node of the tree
    // public static int sumoftree(Node root) {
    //     if (root==null) {
    //         return 0;
    //     }
    //     int leftsum=sumoftree(root.left);
    //     int rightsum=sumoftree(root.right);
    //     return leftsum+rightsum+root.data;
    // }

    public static void kth_level(Node root,int level,int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.println(root.data);
            return;
        }
        kth_level(root.left, level+1, k);
        kth_level(root.right, level+1, k);
    }

    public static void lcs(Node root,int n1,int n2) {
        ArrayList<Integer>path1=new ArrayList<>();
        ArrayList<Integer>path2=new ArrayList<>();
        getPath(root,n1,path1);
        getPath(root,n2,path2);
        //last common ancestor
        int i=0;
        for (; i < path1.get() && path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            } 
        }
        //last equal node -> i-1th
        Node lca=path1.get(i-1);

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
        //System.out.println(heightoftree(root));  
        // System.out.println(countoftree(root));
        // System.out.println(sumoftree(root));
        //System.out.println(diametr_optimised(root).diameter);
        /*
                2
               / \
              4   5
        */
        Node subroot=new Node(2);
        subroot.left=new Node(4);
        subroot.right=new Node(5);
        //System.out.println(same(root, subroot)); 
        //kth_level(root,1,3);
        int n1=4,n2=6;
    }
}
