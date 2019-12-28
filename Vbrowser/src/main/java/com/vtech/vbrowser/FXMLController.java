package com.vtech.vbrowser;

import com.sun.javafx.webkit.WebConsoleListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.web.WebView;

public class FXMLController implements Initializable {
    
    public String url;
    public Alert ea = new Alert(AlertType.NONE);
    @FXML
    public Button gbtn;
    public WebView webeng;
    public TextField txt;
    
    
    @FXML
    public void txtset(ActionEvent e){
        url = txt.getText();
        webeng.getEngine().load(url);
    }
    
    
    public void gobtn(ActionEvent e){
    webeng.getEngine().load(url);
    
    txt.setText(webeng.getEngine().getLocation());
    if("about:blank".equals(webeng.getEngine().getLocation())){
          ea.setAlertType(AlertType.WARNING);
          ea.setContentText("Error loading url...");
          ea.show();
          URL url = this.getClass().getResource("/err/err.html");
          webeng.getEngine().load(url.toString());
    }
    }
    
    
   public void gohomebtn(ActionEvent e){
    webeng.getEngine().load("https://www.google.com/");
    txt.setText(webeng.getEngine().getLocation());
    }
   
      public void refreshthepage(ActionEvent e){
          webeng.getEngine().reload();
      }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
// Do nothing...
    }    
}
