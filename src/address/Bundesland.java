/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package address;

import java.util.Arrays;
import java.util.Scanner;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

/**
 *
 * @author 20140056
 */
public class Bundesland {
    StringProperty Bundesland = new SimpleStringProperty("");
    StringProperty Hauptstadt = new SimpleStringProperty("");
    IntegerProperty Einwohner = new SimpleIntegerProperty(0);
    DoubleProperty Flaeche = new SimpleDoubleProperty(0);
    ObjectProperty<Image> img = new SimpleObjectProperty<>(new Image("res/HTL_IF.png"));
    StringProperty Landeshauptmann = new SimpleStringProperty();
    StringProperty Regierungssitze = new SimpleStringProperty();
    StringProperty Restparteien = new SimpleStringProperty();
    
    
    
    public Bundesland(String src){
      
      String[] peaces = src.split(";");
      
            this.Bundesland = new SimpleStringProperty(peaces[1]);
            this.img = new SimpleObjectProperty<Image>( new Image("res/" + peaces[0])) ;
            this.Hauptstadt = new SimpleStringProperty(peaces[2]); 
            this.Landeshauptmann = new SimpleStringProperty(peaces[3]);
            this.Regierungssitze = new SimpleStringProperty(peaces[4]);
            this.Restparteien = new SimpleStringProperty(peaces[5]);
            this.Einwohner = new SimpleIntegerProperty(Integer.parseInt(peaces[6]));
            this.Flaeche = new SimpleDoubleProperty(Double.parseDouble(peaces[7]));
            Arrays.toString(peaces);
            
       }

    public String getBundesland() {
        return Bundesland.get();
    }

    public void setBundesland(StringProperty Bundesland) {
        this.Bundesland = Bundesland;
    }

    public String getHauptstadt() {
        return Hauptstadt.get();
    }

    public void setHauptstadt(StringProperty Hauptstadt) {
        this.Hauptstadt = Hauptstadt;
    }

    public Integer getEinwohner() {
        return Einwohner.get();
    }

    public void setEinwohner(IntegerProperty Einwohner) {
        this.Einwohner = Einwohner;
    }

    public Double getFlaeche() {
        return Flaeche.get();
    }

    public void setFlaeche(DoubleProperty Flaeche) {
        this.Flaeche = Flaeche;
    }

    public Image getImg() {
        return img.get();
    }

    public void setImg(ObjectProperty<Image> img) {
        this.img = img;
    }

    public String getLandeshauptmann() {
        return Landeshauptmann.get();
    }

    public String getRegierungssitze() {
        return Regierungssitze.get();
    }

    public String getRestparteien() {
        return Restparteien.get();
    }
    

    @Override
    public String toString() {
        return super.toString();
    }
    public String getRegierung(){
        return "Landeshauptman:    " + "\t" + getLandeshauptmann() + "\n" +
               "Regierungssitze:   " + "\t\t{" + getRegierungssitze() + "}\n" +
               "Restparteien:      " + "\t\t{" + getRestparteien()+"}";
    }
    
  

  }

