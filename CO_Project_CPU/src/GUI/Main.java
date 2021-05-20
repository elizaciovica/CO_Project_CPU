package GUI;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import testbench.*;

public class Main extends Application {

    //public Button test;
    public static String alo;
    public static String alo2;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("interface2.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(new Scene(root, 817, 450));
        primaryStage.show();

    }
    public void handleButton() {
       TestCPUDigitsOfPi cpu = new TestCPUDigitsOfPi();
       cpu.method();

    }

    public static void main(String[] args) {
        launch(args);
    }

}