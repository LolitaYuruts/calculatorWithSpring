import bean.api.Calculator;
import bean.api.ConsoleReader;
import config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Calculator calculator = (Calculator) context.getBean(Calculator.class);
        ConsoleReader consoleReader = (ConsoleReader) context.getBean(ConsoleReader.class);

        double numberOne = consoleReader.getNumber();
        double numberTwo = consoleReader.getNumber();
        char operation = consoleReader.getOperation();

        System.out.println(calculator.calculate(numberOne, numberTwo, operation));
    }
}
