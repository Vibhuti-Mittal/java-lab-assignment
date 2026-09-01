public class q2{
    public static void main(String[] args){
        try{
            System.out.println("Outer Try Block");
            try{
                System.out.println("Inner Try Block");
                int n = 10, m = 0;
                System.out.println("Answer: " + n/m);
            }
            catch(ArithmeticException e){
                    System.out.println("Inner Catch: " + e);
            }
            String str = null;
            System.out.println(str.length());
            }
        catch(NullPointerException e)
        {
                System.out.println("Outer Catch: " + e);
        }
    }
}