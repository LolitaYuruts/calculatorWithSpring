package bean.impl;

import bean.api.Calculator;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CalculatorImpl implements Calculator {
    private static final Logger log = Logger.getLogger(CalculatorImpl.class);

    @Override
    public double count(double a, double b, char operation) {
        log.info("It's the beginning of the method 'count'");
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
                result = count(a, b, getOperation());
        }
        log.info("It's the end of the method 'count'");
        return result;
    }

    @Override
    public double getNumber() {
        log.info("It's the beginning of the method 'getNumber'");
        double number = 0;
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextDouble()) {
            number = scanner.nextDouble();
        } else {
            System.out.println("You have to enter a number. Retry please");
            scanner.next();
            number = getNumber();
        }
        log.info("It's the end of the method 'getNumber'");
        return number;
    }

    @Override
    public char getOperation() {
        log.info("It's the beginning of the method 'getOperation'");
        char operation = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the operation");
        operation = scanner.next().charAt(0);
        log.info("It's the end of the method 'getOperation'");
        return operation;
    }
}
