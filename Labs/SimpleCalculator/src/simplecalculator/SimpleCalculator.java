/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

/**
 *
 * @author Christian Choi
 */
public class SimpleCalculator {
    
    public double addition(double operand1, double operand2) {
        return operand1 + operand2;
    }
    
    public double subtraction(double operand1, double operand2) {
        return operand1 - operand2;
    }
    
    public double multiplication(double operand1, double operand2) {
        return operand1 * operand2;
    }
    
    public double division(double operand1, double operand2) throws ArithmeticException {
        return operand1 / operand2;
    }
    
}
