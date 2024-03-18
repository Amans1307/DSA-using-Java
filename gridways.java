public class gridways {
    public static int countgrid(int i,int j,int rows,int cols) {
        //base case
        if (i==rows-1 || j==cols-1) {//rows=n,cols=m
            return 1;
        }
        else if (i==rows || j==cols) {
            return 0;
        }
            int w1=countgrid(i, j+1, rows, cols);//right steps
            int w2=countgrid(i+1, j, rows, cols);//down steps
            return w1+w2;
    }
    public static void main(String[] args) {
        int rows=3;
        int cols=3;
        int totalways=countgrid(0, 0, rows, cols);
        System.out.println("total ways to reach destination :"+totalways);
    }
}
