import java.util.*;
public class Queue_using2stck {
    public static class Queue{
        static Stack<Integer> s1=new Stack<>();
        static Stack<Integer> s2=new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        //push              O(n)
        public static void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());// push from s1 to s2
            }
            s1.push(data);

            while (!s2.isEmpty()) {//push from s2 to s1
                s1.push(s2.pop());
            }
        }
        //remove            O(1)
        public static int remove() {
            if (s1.isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            else{
                return s1.pop();
            }
        }

         //peek                 O(1)
         public static int peek() {         
            if (s1.isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            else{
                return s1.peek();
            }
        }
    }
    
    public static void main(String[] args) {
        Queue q=new Queue();        //object of class Queue
        q.add(1);               //member functions
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
