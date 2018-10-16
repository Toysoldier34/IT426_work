package calculator;

public class Calculator {

    private double operator = 0;
    private char operand = '+';

    public double getOperator() {
        return operator;
    }

    public void setOperator(double operator) {
        this.operator = operator;
    }

    public char getOperand() {
        return operand;
    }

    public void setOperand(char operand) {
        this.operand = operand;
    }
}
