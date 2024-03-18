public class arrayimplement {
        static class Queue{
            static int arr[];
            static int size;
            static int rear;
//constructor 
            Queue(int n){
                arr=new int[n];
                size=n;
                rear=-1;
            }
            public static boolean isEmpty() {
                return rear==-1;
            }
            //add
            public static void add(int data) {
                if (rear==size-1) {
                    System.out.println("queue is full");
                }
                rear=rear+1;
                arr[rear]=data;
            }
            //remove
            public static int remove() {
                if (rear==-1 /*isEmpty() */) {
                    System.out.println("queue is empty");
                    return -1;
                }
                int front=arr[0];
                for (int i = 0; i < rear; i++) {
                    arr[i]=arr[i+1];
                }
                rear=rear-1;
                return front;
            }
            //peek
            public static int peek() {
                if (isEmpty()) {
                    return -1;
                }
                else{
                    return arr[0];
                }
            }
            
        }
        public static void main(String[] args) {
            Queue Q=new Queue(3);//object creation
            Q.add(1);
            Q.add(2);
            Q.add(3);
            while (!Q.isEmpty()) {
                System.out.println(Q.peek()); 
                Q.remove();
            }
    }
        
}
