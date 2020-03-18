package config;

import aop.Aspect;
import bean.api.Calculator;
import bean.api.ConsoleReader;
import bean.impl.CalculatorImpl;
import bean.impl.ConsoleReaderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
public class Config {

    @Bean
    public Calculator calculatorBean() {
        return new CalculatorImpl(consoleReaderBean());
    }

    @Bean
    public ConsoleReader consoleReaderBean() {
        return new ConsoleReaderImpl();
    }

    @Bean
    public Aspect aspect(){return new Aspect();}
}
