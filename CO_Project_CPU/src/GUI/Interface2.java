package GUI;

import testbench.TestCPUDigitsOfPi;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.stage.StageStyle;


public class Interface2 {
    @FXML
    private Button exit;

    public void handleButton(ActionEvent event) {
        TestCPUDigitsOfPi cpu = new TestCPUDigitsOfPi();
       cpu.method();
        try{

            Parent root = FXMLLoader.load(getClass().getResource("test.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 817, 450));
            registerStage.show();

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