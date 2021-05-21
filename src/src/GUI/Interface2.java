package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.stage.StageStyle;
import testbench.TestCPUFixedPoint;
import testbench.TestCPUPrimeNumber;
import testbench.TestCPUThreadRoots;
import testbench.TestCPUDigitsOfPi;

public class Interface2 {
    @FXML
    private Button exit;
    @FXML
    private Button text;

    public void handleButton(ActionEvent event) {
        TestCPUDigitsOfPi cpu = new TestCPUDigitsOfPi();
        cpu.method();
        TestCPUPrimeNumber cpu2 = new TestCPUPrimeNumber();
        cpu2.method1();
        TestCPUThreadRoots cpu3 = new TestCPUThreadRoots();
        cpu3.method2();
        TestCPUFixedPoint cpu4 = new TestCPUFixedPoint();
        cpu4.method4();
        try{

            Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 817, 450));
            registerStage.show();
            Stage stage = (Stage) text.getScene().getWindow();
            stage.close();

        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }

    }
    public void exitButtonOnAction(ActionEvent event){

            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();

    }


}
