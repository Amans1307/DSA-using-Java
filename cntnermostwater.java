import java.util.ArrayList;
public class cntnermostwater {
    public static int mostwater(ArrayList<Integer> height) {// Brute force
        int max=0;                                          //O(n^2)
        for (int i = 0; i < height.size(); i++) {
            for (int j = i+1; j < height.size(); j++) {
                int minheight=Math.min(height.get(i),height.get(j));
                int width=j-i;
                int water=minheight*width;
                if (max<water) {
                    max=water;
                }
            }
        }
        return max;
    }
public static int optmostwater(ArrayList<Integer> height) {//optimised O(n)
    int max=0;
    int lp=0;
    int rp=height.size()-1;
    while (lp<rp) {   
        int minheight=Math.min(height.get(lp),height.get(rp));
        int width=rp-lp;
        int water=minheight*width;
        if(height.get(lp)<height.get(rp)) {
            lp++;
        } else {
            rp--;
        }
        max=Math.max(max, water);
    }
    return max;
}

    public static void main(String[] args) {
        ArrayList<Integer> height=new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        //int maxWater=mostwater(height);
        //System.out.println(maxWater);
        System.out.println(optmostwater(height));

    }
}