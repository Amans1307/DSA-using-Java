public class BST {
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

    //Mirror of BST
public static Node mirror(Node root) {
    if(root == null){
        return null;
    }
    Node left_mirror=mirror(root.left);
    Node right_mirror=mirror(root.right);
    root.left=right_mirror;
    root.right=left_mirror;
    return root;
}

//Sorted array to BST
public static Node create_BST(int arr[],int strt,int end) {
    //base case
    if (strt>end) {
        return null;
    }
    int mid=(end+strt)/2;
    Node root=new Node(arr[mid]);
    root.left=create_BST(arr, strt,mid-1);
    root.right=create_BST(arr, mid+1, end);
    return root;
}
public static void preorder(Node root) {
    if(root == null){
        return;
    }
    System.out.println(root.data);
    preorder(root.left);
    preorder(root.right);
}
    public static void main(String[] args) {
        int arr[]={3,5,6,8,10,11,12};
        int n=arr.length;
        // Node root=new Node(8);
        // root.left=new Node(5);
        // root.right=new Node(10);
        // root.left.left=new Node(3);
        // root.left.right=new Node(6);
        // root.right.right=new Node(11);
        //root=mirror(root);
        Node root=create_BST(arr, 0, n-1);
        preorder(root);
    }
}
