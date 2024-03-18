import java.util.*;
public class deque {
    public static void main(String[] args) {
        Deque<Integer> d=new LinkedList<>();
        d.addFirst(1);
        d.addFirst(2);
        d.addFirst(3);
        d.addFirst(4);
        d.add(5);       //addlast
        d.addLast(6);
        d.remove();       //remove first
        d.removeFirst();
        System.out.println(d);    //2,1,5,6
        d.removeLast();     //2,1,5
        System.out.println(d);
        
        System.out.println(d.getFirst());
        
        System.out.println(d.getLast());
        
        System.out.println(d.getClass());
    }
}
