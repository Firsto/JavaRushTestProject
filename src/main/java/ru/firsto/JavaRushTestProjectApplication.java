package ru.firsto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages = {"ru.firsto.model"})
public class JavaRushTestProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaRushTestProjectApplication.class, args);
    }
}
