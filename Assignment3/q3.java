import java.util.Scanner;

public class q3{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        try
        {
            System.out.println("Enter First Number: ");
            double a = Double.parseDouble(sc.nextLine());
            
            System.out.println("Enter Second Number: ");
            double b = Double.parseDouble(sc.nextLine());
            
            System.out.println("Enter Operator: ");
            String op = sc.nextLine();
            
            double result;
            
            switch(op)
            {
                case "+" : 
                    result = a + b;
                    break;
                    
                case "-" : 
                    result = a - b;
                    break;
                    
                case "*" : 
                    result = a * b;
                    
                case "/" :
                    if(b == 0)
                    throw new ArithmeticException("Division by zero");
                    result = a/b;
                    break;
                    
                default :
                    throw new IllegalArgumentException("Invalid Operator");
            }
            System.out.println("Answer : " + result); 
        }
        catch(ArithmeticException e)
        {
            System.out.println("Error: " + e);
        }
        catch(NumberFormatException e)
        {
            System.out.println("Error: " + e);
        }
        catch(IllegalArgumentException e)
        {
            System.out.println("Error: " + e);
        }
        sc.close();
    }
}