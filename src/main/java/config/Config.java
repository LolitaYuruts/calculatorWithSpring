package config;

import bean.impl.CalculatorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CalculatorImpl getCalculatorBean() {
        return new CalculatorImpl();
    }
}
