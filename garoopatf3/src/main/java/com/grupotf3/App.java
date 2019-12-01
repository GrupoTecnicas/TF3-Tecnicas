package com.grupotf3;


import com.grupotf3.Interface.Windows;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


@SpringBootApplication
@ComponentScan(basePackages = {"com.grupotf3"})
public class App
{
    public static void main( String[] args )
    {
        Windows.open(args);
    }
}
