public class Fib_No_Fibonacci {


    static int counter= 0;

    public static int fib(int n){
        counter++;

        if(n==0 || n==1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }


    public static void main(String[] args){

        int n=7;
        System.out.println("Fib of "+n+" = " +fib(n));

        System.out.println("Counter : "+counter );



    }



}
