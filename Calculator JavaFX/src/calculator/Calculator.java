package calculator;

public class Calculator {

    /*
    Store only 1 operand and 1 operator and replace answer back into operator

    default operator to 0
    default operand to +


    pressing operand button only changes the current operand immediately with no other checks,
        or have operand button clear text field after saving
    pressing number concats it to temp display field, use getText to get back
    check for leading 0/nothing to prevent pressing 0 first
    pressing enter does math with temp display field and stored value

     */


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
