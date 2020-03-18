package bean.impl;

import aop.LogAnnotation;
import bean.api.Calculator;
import bean.api.ConsoleReader;
import org.apache.log4j.Logger;

public class CalculatorImpl implements Calculator {
    ConsoleReader consoleReader;

    public CalculatorImpl (ConsoleReader consoleReader){
        this.consoleReader = consoleReader;
    }

    @LogAnnotation
    @Override
    public double calculate(double a, double b, char operation) {
        double result = 0;
        switch (operation) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0) {
                    throw new IllegalArgumentException("Dividing by zero is forbidden");
                }
                result = a / b;
                break;
            default:
                System.out.println("Unknown operation. You can choose '+', '-', '*' or '/'. Retry please");
                result = calculate(a, b, consoleReader.getOperation());
        }
        return result;
    }
}
