import java.util.*;
public class interleave {
    public static void interleave_queue(Queue<Integer> q) {
        Queue<Integer> tempQ=new LinkedList<>();
        int n=q.size();
        for (int i = 0; i < n/2; i++) {//first half of the original queue is added to temp queue
            tempQ.add(q.remove());
        }
        while (!tempQ.isEmpty()) {
            q.add(tempQ.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interleave_queue(q);
        while(!q.isEmpty()){
            System.out.println(q.remove()+" ");
        }
        System.out.println();
    }
}
