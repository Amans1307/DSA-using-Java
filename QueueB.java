import java.util.*;
public class QueueB {
    static class stack_using_queue{
        static Queue<Integer> q1=new LinkedList<>();
        static Queue<Integer> q2=new LinkedList<>();
        public static boolean isempty() {
            return q1.isEmpty() && q2.isEmpty();
        }
        //push
        public static void push(int data) {
            if(!q1.isEmpty()){
                q1.add(data);
            }
            if(!q2.isEmpty()){
                q2.add(data);
            }
        }
        //pop
        public static int pop() {
            if(isempty()){
                System.out.println("its empty");
                return -1;
            }
            int top=-1;
            //case 1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top=q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }
            //case 2
            if(!q2.isEmpty()){
                while(!q2.isEmpty()){
                    top=q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

        //peek
        public static int peek() {
            if(isempty()){
                System.out.println("its empty");
                return -1;
            }
            int top=-1;
            //case 1
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top=q1.remove();
                    q2.add(top);
                }
            }
            //case 2
            if(!q2.isEmpty()){
                while(!q2.isEmpty()){
                    top=q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }    
    public static void main(String[] args) {
        stack_using_queue s=new stack_using_queue();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isempty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
