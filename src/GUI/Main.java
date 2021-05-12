package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import testbench.*;

public class Main extends Application {
    //public Button test;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("interface.fxml"));
        primaryStage.setTitle("Pisicile Salbatice Benchmarck");
        primaryStage.setScene(new Scene(root, 800, 400));
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