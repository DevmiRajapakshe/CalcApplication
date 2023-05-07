package com.calculator.ejb;

import javax.ejb.Remote;

/**
 *
 * @author Devmi
 */
@Remote
public interface CalculatorSessionBeanRemote {

    //defines five methods to add, subtract, multiply, divide, and to get the module of 2 numbers
    public double addNumbers(double number1, double number2) throws ArithmeticException, NumberFormatException;
    public double subtractNumbers(double number1, double number2) throws ArithmeticException, NumberFormatException;
    public double multiplyNumbers(double number1, double number2) throws ArithmeticException, NumberFormatException;
    public double divideNumbers(double number1, double number2) throws ArithmeticException, NumberFormatException;
    public double getModOfNumbers(double number1, double number2) throws ArithmeticException, NumberFormatException;
}