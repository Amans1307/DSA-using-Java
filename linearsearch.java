public class linearsearch{
    public static int linear(int number[],int key){
        for(int i=0;i<number.length;i++){
            if(number[i]==key){
                return i;
            }
        }  
        return -1;
    }

    public static void main(String[] args) {
        int number[]={10,20,33,44,65,67};
        int key=1;
        int a=linear(number,key);
        if(a==-1){
            System.out.println("key not found");
        }  
        else{
            System.out.println(a);
        }  
    }

}