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


    public void setOnAction(ActionEvent event){
        testfinal.setText("CPU DIGITS OF PI TESTING "+Main.alo+"\n"+"CPU PRIME NUMBER TESTING x50000 "+Main.alo3);
    }

}
