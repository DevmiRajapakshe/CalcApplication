package com.calculator.ejb;

import javax.ejb.Stateless;
/**
 *
 * @author Devmi
 */
@Stateless
public class CalculatorImplementationSessionBean implements CalculatorSessionBeanRemote {
    
    //Implements the calculation interface and provides the implementation of adding, subtracting, multiplying, dividing, and getting
    //the mod of two numbers
    
    @Override
    public double addNumbers(double number1, double number2) throws ArithmeticException, NumberFormatException {
        return number1 + number2;
    }

    @Override
    public double subtractNumbers(double number1, double number2) throws ArithmeticException, NumberFormatException {
        return number1 - number2;
    }

    @Override
    public double multiplyNumbers(double number1, double number2) throws ArithmeticException,NumberFormatException {
        return number1 * number2;
    }

    @Override
    public double divideNumbers(double number1, double number2) throws ArithmeticException,NumberFormatException {
        if (number2 != 0) {
            //The division will only be possible if number2 is not 0. Otherwise, the result will be not defined.
            return number1 / number2;
        } else {
            throw new ArithmeticException("Division by zero is not possible");
        }
    }

    @Override
    public double getModOfNumbers(double number1, double number2) throws ArithmeticException,NumberFormatException {
        return number1 % number2;
    }
}