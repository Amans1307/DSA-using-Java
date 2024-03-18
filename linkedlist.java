public class linkedlist{
    public static class node{
        int data;
        node next;
        public node(int data) { //constructor
            this.data=data;
            this.next=null;
        }
    } 
    public static node head;
    public static node tail;
    public static int size; 
    
    public void addfirst(int data) {
        node newnode=new node(data); // creating new node
        size++;
        if (head==null) {
            head=tail=newnode;
            return;
        }
        // make new node`s next =head
        newnode.next=head;
        head=newnode;
    }


    public void addlast(int data) {
        node newnode=new node(data); // creating new node
        size++;
        if (head==null) {
            head=tail=newnode;
            return;
        }
        tail.next=newnode;
        tail=newnode;
    }
    public void addmiddle(int inx,int data) {
        node newnode=new node(data);// creating new node
        node temp=head;
        int i=0;
        if (head==null) {
            addfirst(data);
            return;
        }
        size++;
        while (i<inx-1) {
            temp=temp.next;
            i++;
        }
        newnode.next=temp.next;
        temp.next=newnode;
    }   
    public void print() {
        if (head==null) {
            System.out.println("LL is empty");
            return;
        }
        node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public int removefirst() {
        size--;
        //case1:when list is empty
        if (head==null) {
            System.out.println("list is empty");
        }
        //case 2:when only one element is present
        else if (size==1) {
            head=tail=null;
        }
        else {
            head=head.next;        
        }  
        return head.data;    
    }
    public int removelast() {
        //case1:when list is empty
        if (head==null) {
            System.out.println("list is empty");
            size--;
        }
        //case 2:when only one element is present
        else if (size==1) {
            head=tail=null;
            int val=head.data;
            size--;
            return val;
        }
            node prev=head;
            for (int i = 0; i < size-2; i++) {
                prev=prev.next;
            }
            int val=prev.next.data;
            prev.next=null;
            tail=prev;
            size--;
        return val;
    }

    public int itrsearch(int key) {
        node temp=head;
        int i=0;
        while (temp!=null) {
            if (temp.data==key) {
                return i;   
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    public void reverseLL() {
        node prev=null;
        node curr=tail=head;
        node next;
        while (curr!=null) {
            next=curr.next;
            curr.next=prev;// reversing step
            prev=curr;
            curr=next;    
        }
        head=prev;
    }

    public void deletefromlast(int n) {
        // calculate size
        int sz=0;
        node temp=head;
        while (temp!=null) {
            temp=temp.next;
            sz++;
        }
        //delete from size-n+1 from start
        if (sz==n) {
            head=head.next;         //delete first element
            return;
        }
        int i=1;
        int indxtofind=sz-n;
        node prev=head;
        while (i!=indxtofind) {
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;//main step of deletion
    }

    public node findmid(node head) {
        node fast=head;
        node slow=head;
        while (fast == null || fast.next == null) {//alternative  (fast != null && fast.next != null)
            slow=slow.next;//+1
            fast=fast.next.next;//+2
        }
        return slow;
    }
// checking palindrom 
    public boolean checkpalindrome() {
        if (head==null || head.next==null) {// LL has only one node
            return true;
        }
        //step1: find mid
        node midnode=findmid(head);

        //step 2: second half reverse
        node prev=null;
        node curr=midnode;  
        node next;
        while (curr!=null) {//reversing step
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        node left=head;
        node right=prev;// right half head
        //step 3: check 1st half and 2nd half
        while (left!=null) {
            if (left.data != right.data) {
                return false;
            }
            left=left.next;
            right=right.next;
        }
        return true;
    }

    

    public static void main(String[] args) {
        linkedlist l1= new linkedlist();
        // l1.print();
        l1.addlast(2);
        // // l1.print();
          l1.addlast(1);
        // // l1.print();
          l1.addlast(1);
        // // l1.print();
          l1.addlast(2);
        // // l1.print();
       //  l1.addmiddle(2, 9);
         l1.print();
        //  l1.addlast(13);
        // // l1.print();
        //  l1.addmiddle(3, 10);
        // l1.print();
        //System.out.println(l1.size);
        //System.out.println(size);
        // l1.removefirst();
        //l1.print();
        // System.out.println(l1.size); 
       // System.out.println(l1.size);
        //l1.removelast();
        //l1.removefirst();
        //l1.removelast();
        //l1.print();
       // System.out.println(l1.size);
       // l1.print(); 
        //System.out.println(l1.itrsearch(3));
        //System.out.println(l1.itrsearch(211));
        //l1.print();
       // l1.reverseLL();
      //   l1.print();
        // l1.deletefromlast(3);
        //  l1.addfirst(1);
        //  l1.addfirst(2);
        //  l1.addfirst(1);
        //  l1.print(); 
        System.out.println(l1.checkpalindrome());
    }   
}