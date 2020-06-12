package T2;

public class Factorial {
    public long factot(long x){
        long sum=0;
        if (x<=1){
            return 1;
        }else {
            sum = x * factot(x - 1);
            return sum;
        }
    }
    public static void main(String[] args) {
        Factorial a=new Factorial();

        System.out.println( a.factot(20));
    }
}
