package GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.scene.control.TextField;

public class TestController {
    @FXML
    private TextArea testfinal;
    @FXML
    private Button set;
    @FXML
    private Button exit;
    int [] myarray = new int[20000];


    public void setOnAction(ActionEvent event){

        int i,j,n=20000,a,k=0;

        testfinal.setText("CPU DIGITS OF PI TESTING "+Main.str_pi+"\n"+"CPU PRIME NUMBER TESTING x50000 "+Main.str_prime+"\n"+"CPU THREADED ROOTS "+Main.str_root+"\n"+"CPU FIXED POINT "+Main.str_fixed+"\n"+"\n"+"\n"+"Your score is "+Main.score+"\n");

    }
    public void exitButtonOnAction(ActionEvent event){
        Main.score = 0;
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();

    }

}
