import bean.api.Calculator;
import config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class Main {
    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Calculator calculator = (Calculator) context.getBean(Calculator.class);

        double numberOne = calculator.getNumber();
        double numberTwo = calculator.getNumber();
        char operation = calculator.getOperation();

        System.out.println(calculator.count(numberOne, numberTwo, operation));
    }
}
