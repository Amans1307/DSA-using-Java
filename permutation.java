public class permutation {
    public static void findpermutaion(String str,String ans) {  //O(n*n!)
        //base case
        if (str.length()==0) {
            System.out.println(ans);
            return;
        }
        //recursion
        for (int i = 0; i < str.length(); i++) {
            char curr=str.charAt(i);
            //abcde=ab+de
            String originalstr=str.substring(0, i)+str.substring(i+1);
            findpermutaion(originalstr,curr+ans);
        }
    }

    public static void main(String[] args) {
        String str="abc";
        findpermutaion(str, "");
    }
}
