//Find non repeating letter in a stream of characters
import java.util.*; 
public class Non_repeating {
    public static void non_repeating_char(String str) {
        int freq[]=new int[26];
        Queue<Character> q=new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while (!q.isEmpty() && freq[q.peek()-'a']>1) {
                q.remove();
            }
            if (q.isEmpty()) {  // when queue become empty
                System.out.println(-1+" ");
            }
            else{               //when frequency of character become equal to 1
                System.out.println(q.peek()+" ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String str="aabccxb";
        non_repeating_char(str);
    }
}
