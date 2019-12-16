package finel.project.java;

import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChooseTopping_Controller {

    private double price = 0;
    //private static double p1;
    private double begalPrice;
    private double coffeePrice;
    private int begalNumber;
    private double sum;
    private String Coffee;
    private String Begal;
    private int qty_begal;
    private int qty_coffee;
    
    @FXML
    private CheckBox chk_cheese;

    @FXML
    private CheckBox chk_butter;

    @FXML
    private CheckBox chk_blueberry;

    @FXML
    private CheckBox chk_raspberry;

    @FXML
    private CheckBox chk_peach;

    @FXML
    private Button btn_calculate;

    @FXML
    private Button btn_cancel;

    @FXML
    private TextField txt_begal;

    @FXML
    private Button btn_add;

    @FXML
    private MenuItem m_add;

    @FXML
    private MenuItem m_cal;

    @FXML
    private MenuItem m_cancel;
    
    @FXML
    private Label label_price;
    
    @FXML
    private Label label_option;
     
    @FXML
    private Label label_add;

    public void setText(double price_begal, double price_coffee, int begalNum, String begal, String coffee, int qty_begal, int qty_coffee)
    {
        //this.label_price.setText(" Begal --> "+ price_begal + "coffee --> " + price_coffee);
        begalPrice = price_begal;
        coffeePrice = price_coffee;
        begalNumber = begalNum; 
        Coffee = coffee;
        Begal = begal;
        this.qty_coffee = qty_begal;
        this.qty_begal = qty_begal;
    }
    
    public void add()
    {
        {
            int num1 = Integer.parseInt(txt_begal.getText());
            if(num1 <= begalNumber)
            {
                 System.out.println("Bagel num : " + begalNumber);
                  begalNumber = begalNumber - num1; 
                  System.out.println("Bagel num : " + begalNumber);
            }
               
        }
    }
    

    @FXML
    void buttonClick(ActionEvent event) 
    {  
        
        if(btn_add == event.getSource())           
        {
            int num = Integer.parseInt(txt_begal.getText());
 
        ArrayList list = new ArrayList();
        ArrayList<Double> list1 = new ArrayList<Double>();
            if(Integer.parseInt(txt_begal.getText()) > begalNumber)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "You left only " + begalNumber + " bagel." );
                alert.showAndWait();
            }
            if(chk_cheese.isSelected())
            {
                list.add(chk_cheese);
                list1.add(0.50);
            }
            if(chk_butter.isSelected())
            {
                list.add(chk_butter);
                list1.add(0.25);
            }
            if(chk_blueberry.isSelected())
            {
                list.add(chk_blueberry);
                list1.add(0.75);
            }
            if(chk_raspberry.isSelected())
            {
                list.add(chk_raspberry);
                list1.add(0.75);
            }
            if(chk_peach.isSelected())
            {
                list.add(chk_peach);
                list1.add(0.75);
            }
            add();
            double p1 =0;
           
                double[] d = new double[list1.size()]; 
                p1 = 0;
                for(Double i: list1)
                {
                    
                    sum = i; 
                    p1 = (num * sum);    
                    
                }
                System.out.println("<<<<<<>>>>>>>>" + p1);
              
               txt_begal.clear();
                chk_blueberry.setSelected(false);
                chk_butter.setSelected(false);
                chk_cheese.setSelected(false);
                chk_peach.setSelected(false);
                chk_raspberry.setSelected(false);
                list1.clear();
                list.clear();
 
                price = p1 + begalPrice;
                
               
                
//                label_add.setText("<<<<<<<< --" );
//                label_option.setText(">>>>>>> -- " + p1);
        } 
        
        
        
        try 
        {
            if (event.getSource() == btn_calculate) 
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FinalBill.fxml"));
                Parent root2 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle(" Bill !! ");
                stage.setScene(new Scene(root2));
                FinalBillController display1 = fxmlLoader.getController();
                display1.setText1(price, coffeePrice,Begal,Coffee,qty_begal,qty_coffee);
                stage.show();    
            }
        } 
        catch (IOException e) 
        {
            System.out.println("cant load window..");
        }

        if(btn_cancel==event.getSource())
        {
           
                System.exit(0);
        }
   }
    
    
    @FXML
    void menuEvents(ActionEvent event)
    {
        if(m_cancel == event.getSource())
        {
                System.exit(0);
        }
        
        try 
        {
            if (event.getSource() == m_cal) 
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FinalBill.fxml"));
                Parent root2 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle(" Bill !! ");
                stage.setScene(new Scene(root2));
                FinalBillController display1 = fxmlLoader.getController();
                display1.setText1(price, coffeePrice, Begal, Coffee,qty_begal,qty_coffee);
                stage.show();    
            }
        }
        catch (IOException e) 
        {
            System.out.println("cant load window..");
        }
        
        if(event.getSource() == m_add)
        {
            int num = Integer.parseInt(txt_begal.getText());
 
        ArrayList list = new ArrayList();
        ArrayList<Double> list1 = new ArrayList<Double>();
            if(Integer.parseInt(txt_begal.getText()) > begalNumber)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR, "You left only " + begalNumber + " bagel." );
                alert.showAndWait();
            }
            if(chk_cheese.isSelected())
            {
                list.add(chk_cheese);
                list1.add(0.50);
            }
            if(chk_butter.isSelected())
            {
                list.add(chk_butter);
                list1.add(0.25);
            }
            if(chk_blueberry.isSelected())
            {
                list.add(chk_blueberry);
                list1.add(0.75);
            }
            if(chk_raspberry.isSelected())
            {
                list.add(chk_raspberry);
                list1.add(0.75);
            }
            if(chk_peach.isSelected())
            {
                list.add(chk_peach);
                list1.add(0.75);
            }
            add();
            double p1 =0;
           
                double[] d = new double[list1.size()]; 
                p1 = 0;
                for(Double i: list1)
                {
                    
                    sum = i; 
                    p1 = (num * sum);    
                    
                }
                System.out.println("<<<<<<>>>>>>>>" + p1);
              
               txt_begal.clear();
                chk_blueberry.setSelected(false);
                chk_butter.setSelected(false);
                chk_cheese.setSelected(false);
                chk_peach.setSelected(false);
                chk_raspberry.setSelected(false);
                list1.clear();
                list.clear();
 
                price = p1 + begalPrice;
               
        }
        if(m_cal == event.getSource())
        {
              try 
        {
            if (event.getSource() == m_cal) 
            {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FinalBill.fxml"));
                Parent root2 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle(" Bill !! ");
                stage.setScene(new Scene(root2));
                FinalBillController display1 = fxmlLoader.getController();
                display1.setText1(price, coffeePrice, Begal, Coffee,qty_begal,qty_coffee);
                stage.show();    
            }
        }
        catch (IOException e) 
        {
            System.out.println("cant load window..");
        }
        }
    }
    
    
}
