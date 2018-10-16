package calculator;

/**
 * stores operator and operand values
 */
public class Calculator {

    private double operator = 0;
    private char operand = '+';


    /**
     * operator getter
     * @return double operator
     */
    public double getOperator() {
        return operator;
    }


    /**
     * operator setter
     * @param operator double operator
     */
    public void setOperator(double operator) {
        this.operator = operator;
    }


    /**
     * operand getter
     * @return char operand
     */
    public char getOperand() {
        return operand;
    }


    /**
     * operand setter
     * @param operand char operand
     */
    public void setOperand(char operand) {
        this.operand = operand;
    }
}
