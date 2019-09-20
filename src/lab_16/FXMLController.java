/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_16;

import address.Bundesland;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author 20140056
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
    
    List<Bundesland> l = new ArrayList<>();
    @FXML
    private ListView<Bundesland> lv;
    ObservableList<Bundesland> obl = FXCollections.observableArrayList();
    @FXML
    private Label bundeslandId;
    @FXML
    private Label wappenId;
    @FXML
    private Label einwohnerId;
    @FXML
    private Label flaecheId;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lv.setItems(obl);
        Scanner sc = null;  
        try{
            
            String pfad = "/res/" + "bundeslaender_2017.csv"; 
            InputStream is = this.getClass().getResourceAsStream(pfad); 
           
            // sc = new Scanner(is); old version, scanner was used to read from Stream. 
            //generate BufferedReader to read from InputStram.
             BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String s = null;
            while((s = br.readLine()) != null){
               //build object and add afterward states to obervable list.
              obl.add(new Bundesland(s));
              //print states
             System.out.println(new Bundesland(s));
                
            }

            ListView<String> list = new ListView<String>();
            
        } catch(Exception e){
                 System.out.println(e.getMessage());
           }
        
         lv.setCellFactory(new Callback<ListView<Bundesland>, ListCell<Bundesland>>() {
            @Override public ListCell<Bundesland> call(ListView<Bundesland> list) {
                return new BundeslandListCell();
            }
        });
         System.out.println(lv);
         //eventhandler for a mouse event when clicking a state
        lv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("in Bedingung");
                Bundesland b =  lv.getSelectionModel().getSelectedItem();
               Alert al = new Alert(Alert.AlertType.INFORMATION, b.getRegierung(), ButtonType.OK);
               al.setTitle(b.getBundesland());
               al.setHeaderText("Zusatzinformationen zur Landesregierung von: " +  b.getBundesland());
               al.getDialogPane().setPrefWidth(550);
               al.show();
            }
        });
        
        
                 
    }    
    
}
