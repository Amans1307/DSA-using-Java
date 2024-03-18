import java.util.LinkedList;
public class framework {
    public static void main(String[] args) {
        //create- objects int,float,boolean  -> Integer,Float,Boolean
        LinkedList<Integer> ll=new LinkedList<>();// inbuilt linkedlist
        //add
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
        //0->1->2
        System.out.println(ll);
        //remove
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);
    }
}
