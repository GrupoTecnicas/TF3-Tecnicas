package com.grupotf3;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.grupotf3"})
public class App
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        System.out.println("Spring rodando...");
    }
}
