/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finel.project.java;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 *
 * @author Vishwa
 */
public class ChooseBagel_Controller //implements Initializable
{
    private double price_begal; 
    private double price_coffee;
    private int whiteBegl=0;
    private int wheateBegl=0;
    private int number;
    private String Coffee;
    private String Begal;
    private int begal;
    private int coffee;
    
    @FXML
    private RadioButton radNoBagel;

    @FXML
    private ToggleGroup group1;

    @FXML
    private RadioButton radWhite;

    @FXML
    private RadioButton radWheat;

    @FXML
    private RadioButton radNoCoffee;

    @FXML
    private ToggleGroup group2;

    @FXML
    private RadioButton radRegCoffee;

    @FXML
    private RadioButton radCappaccino;

    @FXML
    private RadioButton radCafeAuLait;

    @FXML
    private TextField txt_white;

    @FXML
    private TextField txt_wheat;

    @FXML
    private TextField txt_regCoffee;

    @FXML
    private TextField txt_cappaccino;

    @FXML
    private TextField txt_cafeAuLait;

    @FXML
    private Label label_begalPrice;

    @FXML
    private Label label_coffeePrice;

    @FXML
    private Button btn_topping;
    

    @FXML
    private Button btn_reset;
    

    @FXML
    void handleButtonAction(ActionEvent event) 
    {
        
        if(txt_wheat.getText().equals(""))
        {
            whiteBegl = Integer.parseInt(txt_white.getText());
            number = whiteBegl;
        }
        if(txt_white.getText().equals(""))
        {
            wheateBegl = Integer.parseInt(txt_wheat.getText());
            number = wheateBegl;
        }
        /*
        * calculate price of begal and open second window.
        */   
      
        if (event.getSource() == btn_topping) 
        
        {
            //btn.setVisible(false);
            if (radWheat.isSelected()) 
            {
              //btn_topping.setDisable(true);
                begal = Integer.parseInt(txt_wheat.getText());
                Begal = radWheat.getText();
                price_begal = 1.50 * begal;
                label_begalPrice.setText("Begal--> " + price_begal);
            }
            if (radWhite.isSelected()) 
            {
                //btn_topping.setDisable(true);
                begal = Integer.parseInt(txt_white.getText());
                Begal = radWhite.getText();
                price_begal = 1.25 * begal;
                //label_begalPrice.setText("Begal--> " + price_begal);
            }
            if (radRegCoffee.isSelected()) {
                //btn_topping.setDisable(true);
                int coffee = Integer.parseInt(txt_regCoffee.getText());
                Coffee = radRegCoffee.getText();
                price_coffee = 1.25 * coffee;
                //label_coffeePrice.setText("Coffee price--> " + price_coffee);
            }   
            if (radCappaccino.isSelected()) {
                //btn_topping.setDisable(true);
                coffee = Integer.parseInt(txt_cappaccino.getText());
                Coffee = radCappaccino.getText();
                price_coffee = 2.0 * coffee;
                //label_coffeePrice.setText("Coffee price--> " + price_coffee);
            }   
            if (radCafeAuLait.isSelected()) {
                //btn_topping.setDisable(true);
                coffee = Integer.parseInt(txt_cafeAuLait.getText());
                Coffee = radCafeAuLait.getText();
                price_coffee = 1.75 * coffee;
            }
            
        }
        try 
        {
            if (event.getSource() == btn_topping) 
            {
                if(!radNoBagel.isSelected() && !radWheat.isSelected() && !radWhite.isSelected() && txt_wheat.getText().equals("") && txt_white.getText().equals(""))
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Please select one for further ");
                    alert.showAndWait();
                }
                else
                {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ChooseBagel_SecondPg.fxml"));                
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setTitle(" Choose begal Topping !! ");
                    stage.setScene(new Scene(root1));
                
                    display.setText(price_begal, price_coffee, number, Begal,Coffee, begal,coffee);
                    stage.show();
                }
            }  
        } 
        catch (IOException e) 
        {
            System.out.println("cant load window..");
        }
        if (event.getSource() == btn_reset) 
        {
            radCafeAuLait.setSelected(false);
            radCappaccino.setSelected(false);
            radNoBagel.setSelected(false);
            radWheat.setSelected(false);
            radWhite.setSelected(false);
            radRegCoffee.setSelected(false);
            radNoCoffee.setSelected(false);
            txt_cafeAuLait.clear();
            txt_cappaccino.clear();
            txt_regCoffee.clear();
            txt_wheat.clear();
            txt_white.clear();
        }
    }

    private static class display {

        private static void setText(double price_begal, double price_coffee, int number, String Begal, String Coffee, int begal, int coffee) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public display() {
        }
    }
}
