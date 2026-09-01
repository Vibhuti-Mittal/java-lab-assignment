public class q1{
    public static void main(String[] args){
        try {
            int a = 10 / 0;
        } 
        catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        }

        try {
            String str = null;
            System.out.println(str.length());
        } 
        catch (NullPointerException e) {
            System.out.println("Null Pointer Exception: " + e.getMessage());   
        }

        try {
            int arr[] = {1, 2, 3};
            System.out.println(arr[5]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out of Bounds: " + e.getMessage());
        }

        try {
            int num = Integer.parseInt("abc");
        }
        catch (NumberFormatException e) {
            System.out.println("Number Format Exception: " + e.getMessage());
        }
    }
}