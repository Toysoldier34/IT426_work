import java.util.Scanner;

/**
 * Pay manager
 * @author Tony Thompson
 * @version 2.0
 */
public class PayManager
{


    /**
     * Main method
     * @param args main args
     */
    public static void main(String[] args)
    {
        String name;

        // test our pay calculator
        try (Scanner console = new Scanner(System.in))
        {
            //enter a name
            System.out.println("Enter a name: ");
            name = console.nextLine();
            System.out.println("Your name is: " + name);

            //get a pay rate and print the pay
            double payRate = console.nextDouble();
            PayCalculator calculator = new PayCalculator(payRate, name);
            int hours = console.nextInt();
            double pay = calculator.calculatePay(false, hours);
            calculator.printEmployee();
            System.out.println("Pay: " + pay);
        }
        catch (Exception ex)
        {
            System.out.println(ex + "Error!");
        }

    }
}
