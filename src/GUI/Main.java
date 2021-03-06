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
    public static String str_pi;
    public static String str_prime;
    public static String str_root;
    public static String str_fixed;
    public static int score;

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
       TestCPUPrimeNumber cpu2 = new TestCPUPrimeNumber();
       cpu2.method1();
       TestCPUThreadRoots cpu3 = new TestCPUThreadRoots();
       cpu3.method2();
       TestCPUFixedPoint cpu4 = new TestCPUFixedPoint();
       cpu4.method4();

    }

    public static void main(String[] args) {
        launch(args);
    }

}