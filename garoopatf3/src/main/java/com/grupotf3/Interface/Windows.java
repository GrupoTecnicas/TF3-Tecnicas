package com.grupotf3.Interface;

import java.util.Observable;
import java.util.logging.Logger;

import com.grupotf3.App;
import com.grupotf3.Interface.Controle.FachadaRemota;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Windows extends Application{

    private ConfigurableApplicationContext springContext;
    private Parent rootNode;
    private Scene mainPage, passageiro, motorista;

    public static void open(String [] args){
        Application.launch(args);
    }
    private GridPane createGrid(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(40, 40, 40, 40));
        grid.setHgap(10);
        grid.setVgap(10);
        ColumnConstraints colunaUm = new ColumnConstraints(500,500,Double.MAX_VALUE);
        colunaUm.setHalignment(HPos.RIGHT);

        ColumnConstraints colunaDois = new ColumnConstraints(500, 500, Double.MAX_VALUE);
        colunaDois.setHgrow(Priority.ALWAYS);

        grid.getColumnConstraints().addAll(colunaUm, colunaDois);

        return grid;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Garoopa - Grupo 3");
        GridPane grid = createGrid();
        menu(grid,primaryStage);
        primaryStage.setScene(new Scene(grid,800,500));
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(500);
        primaryStage.show();
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

    private void menu(GridPane grid, Stage stage){
        Label headerLabel = new Label("Bem vindo ao Garoopa!");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        grid.add(headerLabel, 0,0,2,1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        Button areaPassageiro = new Button("Área do Passageiro");  
        Button areaMotorista = new Button("Área do Motorista");

        areaPassageiro.setOnAction(event -> passageiroS(stage, passageiro));
        areaMotorista.setOnAction(event -> motoristaS(stage,motorista));

        grid.add(areaPassageiro,0,1);
        grid.add(areaMotorista, 1,1);
    }

    private void passageiroS(Stage stage, Scene scene){
        VBox vBox = new VBox(5);
        Label nome = new Label("CPF: ");
        TextField cpf = new TextField();
        Label bOrg = new Label("Bairro origem: ");
        TextField bOrigem = new TextField();
        Label bDest = new Label("Bairro destino: ");
        TextField bDestino = new TextField();
        Label formaPgto = new Label("Forma de pagamento: ");
        ChoiceBox cb = new ChoiceBox<>(FXCollections.observableArrayList("DINHEIRO","DEBITO","CREDITO"));
        Label catV = new Label("Motoristas disponíveis: ");
        ChoiceBox catVeiculo = new ChoiceBox<>(FXCollections.observableArrayList("NORMAL","SIMPLES","LUXO"));
        vBox.getChildren().addAll(nome,cpf,bOrg,bOrigem,bDest,bDestino,formaPgto,cb,catV,catVeiculo);
        scene = new Scene(vBox,800,500);
        stage.setScene(scene);

    }

    private void motoristaS(Stage stage, Scene scene){

    }
}