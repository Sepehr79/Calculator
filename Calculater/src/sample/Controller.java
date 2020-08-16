package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    //Numbers
    @FXML private Button one;
    @FXML private Button two;
    @FXML private Button three;
    @FXML private Button four;
    @FXML private Button five;
    @FXML private Button six;
    @FXML private Button seven;
    @FXML private Button eight;
    @FXML private Button nine;
    @FXML private Button zero;
    @FXML private Button dot;

    //Math signs
    @FXML private Button division;
    @FXML private Button multiplication;
    @FXML private Button minus;
    @FXML private Button plus;
    @FXML private Button equals;
    @FXML private Button radical;

    private boolean prRad = false;
    private boolean prDiv = false;
    private boolean prMul = false;
    private boolean prMin = false;
    private boolean prPls = false;

    //Display
    @FXML private Label display;

    //Commands
    @FXML private Button c;
    @FXML private Button del;

    //work with display and save previous number
    private String number = "";
    private String bufferNumber = "0";

    public void numClick(ActionEvent actionEvent) {
        //numbers maximum can have 9 digits
        if (number.length() == 9) return;

        if (actionEvent.getSource() == one){
            number += "1";
        }else if (actionEvent.getSource() == two){
            number += "2";
        }else if (actionEvent.getSource() == three){
            number += "3";
        }else if (actionEvent.getSource() == four){
            number += "4";
        }else if (actionEvent.getSource() == five){
            number += "5";
        }else if (actionEvent.getSource() == six){
            number += "6";
        }else if (actionEvent.getSource() == seven){
            number += "7";
        }else if (actionEvent.getSource() == eight){
            number += "8";
        }else if (actionEvent.getSource() == nine){
            number += "9";
        }else if (actionEvent.getSource() == zero){
            number += "0";
        }else if (actionEvent.getSource() == dot){
            number += ".";
        }
        display.setText(number);
    }

    public void commandClick(ActionEvent actionEvent) {
        if (actionEvent.getSource() == c){
            number = "";
            display.setText("0");
        }
        if (actionEvent.getSource() == del){
            if (number.length() > 1) {
                number = number.substring(0, number.length() - 1);
                display.setText(number);
            }else {
                number = "";
                display.setText("0");
            }
        }
    }

    public void mathSignClick(ActionEvent actionEvent) {

        if (actionEvent.getSource() == radical){
            prRad = true;
            bufferNumber = display.getText();
            number = "";
        }

        calculate();

        if (actionEvent.getSource() == plus){
            prPls = true;
        }
        if (actionEvent.getSource() == minus){
            prMin = true;
        }
        if (actionEvent.getSource() == multiplication){
            prMul = true;
        }
        if (actionEvent.getSource() == division){
            prDiv = true;
        }
        bufferNumber = display.getText();
        number = "";
    }

    private void calculate(){

        if (prRad){
            number = String.valueOf(Math.sqrt(Double.valueOf(display.getText())));
            prRad = false;
        }
        if(prPls){
            number = String.valueOf(Double.valueOf(bufferNumber) + Double.valueOf(display.getText()));
            prPls = false;
        }
        if(prMin){
            number = String.valueOf(Double.valueOf(bufferNumber) - Double.valueOf(display.getText()));
            prMin = false;
        }
        if(prDiv){
            number = String.valueOf(Double.valueOf(bufferNumber) / Double.valueOf(display.getText()));
            prDiv = false;
        }
        if(prMul){
            number = String.valueOf(Double.valueOf(bufferNumber) * Double.valueOf(display.getText()));
            prMul = false;
        }

        if (number.length() > 9)
            number = number.substring(0, 9);
        display.setText(number);
    }
}
