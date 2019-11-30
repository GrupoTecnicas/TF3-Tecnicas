package com.grupotf3;


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
public class App extends Application
{
    private ConfigurableApplicationContext springContext;
    private Parent rootNode;
    public static void main( String[] args )
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        stage.setScene(new Scene(rootNode, 700, 700));
        stage.setMinWidth(700);
        stage.setMinHeight(700);
        stage.show();
    }

    public void init() throws Exception{
        springContext = SpringApplication.run(App.class);
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/fxml/MainWindow.fxml"));
        fxmlLoader.setControllerFactory(springContext::getBean);
        rootNode = fxmlLoader.load();
    }

    public void stop() throws Exception{
        springContext.close();
    }
}
