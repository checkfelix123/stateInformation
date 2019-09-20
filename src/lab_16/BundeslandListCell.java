/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_16;

import address.Bundesland;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

/**
 *
 * @author 20140068
 */
public class BundeslandListCell extends ListCell<Bundesland>{
    @Override
    protected void updateItem(Bundesland item, boolean empty) {
        super.updateItem(item, empty);
        GridPane pane = new GridPane();
        
        if(item != null){
            pane.getColumnConstraints().addAll(new ColumnConstraints(120), new ColumnConstraints(120), new ColumnConstraints(150), new ColumnConstraints(130), new ColumnConstraints(110));
            pane.addRow(0, new Label(item.getBundesland()), new ImageView(item.getImg()), new Label(item.getHauptstadt()),
                new Label(Integer.toString(item.getEinwohner())), new Label(Double.toString(item.getFlaeche())));
            setGraphic(pane);
           
        }
    }
}
