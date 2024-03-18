//Queue using linked list
public class Queue_using_LL {
    static class node{
        int data;
        node next;
        node(int data){// node initialisation
            this.data=data;
            this.next=next;
        }
    }
    static class Queue{
        static node head=null;
        static node tail=null;

        public static boolean isEmpty() {
            return head==null && tail==null;
        }
        //add
        public static void add(int data) {
            node newnode=new node(data);
            if (head==null) {
                head=tail=newnode;
                return;
            }
            tail.next=newnode;
            tail=newnode;
        }
        //remove
        public static int remove() {
            if (head==null && tail==null) {
                System.out.println("empty");
                return -1;
            }
            int front=head.data;
            //case: single element
            if (tail==head) {
                tail=null;
                head=null;
            }else{
            head=head.next;
            }
            return front;
        }
        //peek
        public static int peek() {
            if (head==null && tail==null) {
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }

    
}
