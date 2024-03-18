import java.util.ArrayList;
public class pairsum {
    public static boolean pairsum1(ArrayList<Integer>arr,int target) {
        //Brute force  O(n^2)
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i+1; j < arr.size(); j++) {
                if ((arr.get(i)+arr.get(j))==target) {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean pairsum1optmised(ArrayList<Integer>arr,int target,int n) {
        //optimised 2 pointer approach  O(n)
        int lp=0;
        int rp=n-1;
        while(lp<rp){
        //case 1
        if ((arr.get(lp)+arr.get(rp))==target) {
            return true;
        }
        //case 2
        else if ((arr.get(lp)+arr.get(rp))<target) {
            lp++;
        }
        // case 3
        else {
            rp--;
        }
    } 
    return false;   
    }
    //pair sum 2 optimised using 2 pointer approach
    public static boolean optmisd(ArrayList<Integer>arr,int target,int n) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i)>arr.get(i+1)) {
                int largest=i;
                int rp=i;
                int smallest=i+1;
                int lp=i+1;
                while (lp!=rp) {
                    if ((arr.get(lp)+arr.get(rp))==target) {
                        return true;
                    }
                    //case 2
                    else if ((arr.get(lp)+arr.get(rp))<target) {
                        lp=(lp+1)%n;
                    }
                    // case 3
                    else {
                        rp=(n+rp-1)%n;
                    }   
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList <Integer> arr=new ArrayList<>();
        int target=16;
        arr.add(11);
        arr.add(1);
        arr.add(5);
        arr.add(8);
        arr.add(9);
        arr.add(10);
        int n=arr.size();
        System.out.println(arr);
        //System.out.println(pairsum(arr, target)); 
        //System.out.println(pairsum1optmised(arr, target, n));
        System.out.println(optmisd(arr, target, n));
    }
}