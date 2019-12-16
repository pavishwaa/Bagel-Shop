/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finel.project.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import javax.print.*;
import javax.print.attribute.*;

public class FinalBillController {

    private double subTotal;
    private Date date = new Date();
    private double totalBill;
    private double total;
    private double b_price;
    private double c_price;
    private int qty_begal;
    private int qty_coffee;
    private String Coffee;
    private String Begal;
    
    @FXML
    private TextField txt_subTotal;

    @FXML
    private TextField txt_tax;

    @FXML
    private TextField txt_total;

    @FXML
    private Label label_bill;
  
    @FXML
    private Button btn_order;

    @FXML
    private MenuItem menu_print;

    @FXML
    private MenuItem menu_printer;

    @FXML
    private Button btn_cancel;

    
    public void setText1(double total_price, double coffeePrice, String begal, String coffee,int qty_begal, int qty_coffee)
    {
        Coffee = coffee;
        Begal = begal;
        this.qty_begal = qty_begal;
        this.qty_coffee = qty_coffee;
        b_price = total_price;
        c_price = coffeePrice;
        subTotal = total_price + coffeePrice;
        this.txt_subTotal.setText("" + subTotal );
        this.label_bill.setText(">>>>" + coffeePrice);
        totalBill = subTotal * 0.13;
        txt_tax.setText("" + totalBill);
        total = totalBill + subTotal ;
        txt_total.setText("" + total);
        
    }
    
    
    @FXML
    void onOrderClick(ActionEvent event) 
    {
        if(btn_order == event.getSource())
        {
            JOptionPane.showMessageDialog(null, "Thank You!!");
        }
        if(btn_cancel == event.getSource())
        {
            System.exit(0);
        }
    }
    
    @FXML
    void onSelect(ActionEvent event) throws FileNotFoundException 
    {
        if(menu_print == event.getSource())
        {
            File writeFile = new File("Bill.txt");
            FileOutputStream fileStream = new FileOutputStream(writeFile);
            PrintWriter outStream = new PrintWriter(fileStream);
            
            outStream.println("************Sheridan Bagel House*******************");
            outStream.println("Date : " + date);
            outStream.println("Items             Qty            Amount ");
            outStream.println(Begal+ "\t"+ qty_begal+"\t\t"+ "$"+b_price);
            outStream.println(Coffee+ "\t" + qty_coffee + "\t"+ "$"+c_price);
            outStream.println("*******************************");
            outStream.println("Sub Total  \t\t" +"$"+ + subTotal);
            outStream.println("Tax 13% \t\t  " + "$"+totalBill);
            outStream.println("Total \t\t" + "$"+total);
            
            outStream.close();
        }
        
        if(menu_printer == event.getSource())
        {
            File readFile = new File("Bill.txt"); 
            if(!readFile.exists())
            {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "File not found.");
                alert.showAndWait();
            }
            else
            {
                PrintRequestAttributeSet pras =     new HashPrintRequestAttributeSet();
                DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                PrintService ps[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
                PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();
                PrintService service = ServiceUI.printDialog(null, 200, 200, ps, defaultService, flavor, pras);
            if(service != null)
            {
                try
                {
                    DocPrintJob job = service.createPrintJob();
                    DocAttributeSet das = new HashDocAttributeSet();
                    FileInputStream fis = new FileInputStream("FinalBillController.java");
                    Doc doc = new SimpleDoc(fis, flavor, das);
                    try
                    {
                    job.print(doc, pras);
                    System.out.println("Job sent to printer.");
                    //fis.close();
                    }
                    catch (PrintException e)
                    {
                        System.out.println("Print error!" + e.getMessage());
                    }
                }
                catch(FileNotFoundException e1)
                {
                    System.out.println("File not found!" + e1.getMessage());
                }
            }
            
            
            }      
        }
    }
}

