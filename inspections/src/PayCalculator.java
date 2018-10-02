/**
 * Pay Calculator
 * @author Tony Thompson
 * @version 2.0
 */
public class PayCalculator
{
    public static final double OVERTIME_RATE = 0.5;
    public static final int OVERTIME_HOUR_LIMIT = 40;
    private double pay;
    private String employeeFullName;


    /**
     * Pay Calculator
     * @param pay pay rate
     * @param employeeFullName Name of employee
     */
    public PayCalculator(double pay, String employeeFullName)
    {
        this.pay = pay;
        this.employeeFullName = employeeFullName;
    }


    /**
     * Calculates Pay
     * @param salaried employee salaried status
     * @param hours hours worked
     * @return pay amount
     */
    public double calculatePay(boolean salaried, int hours)
    {
        if (salaried)
        {
            return pay;
        }
        else
        {
            double total = hours * pay;

            if (hours > OVERTIME_HOUR_LIMIT)
            {
                total += hours * (OVERTIME_RATE * pay);
            }

            return total;
        }
    }


    /**
     * Prints Employee
     */
    public void printEmployee()
    {
        System.out.println(employeeFullName);
    }

    @Override
    public String toString() {
        return employeeFullName;
    }

}


