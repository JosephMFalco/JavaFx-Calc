import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class Calculator extends Application {
   
   public static void main(String[] args) {
      
      launch(args);
      
   }
   
   Label result;
   public String str = "";
   StringCalc calc;
   
   @Override
   public void start(Stage primaryStage) {
      
      //create buttons for number 1-9
      Button zero = new Button("0");
      zero.setOnAction(new ZeroButtonHandler());
      
      Button one = new Button("1");
      one.setOnAction(new OneButtonHandler());
      
      Button two = new Button("2");
      two.setOnAction(new TwoButtonHandler());
     
      Button three = new Button("3");
      three.setOnAction(new ThreeButtonHandler());
     
      Button four = new Button("4");
      four.setOnAction(new FourButtonHandler());
      
      Button five = new Button("5");
      five.setOnAction(new FiveButtonHandler());
     
      Button six = new Button("6");
      six.setOnAction(new SixButtonHandler());
     
      Button seven = new Button("7");
      seven.setOnAction(new SevenButtonHandler());
      
      Button eight = new Button("8");
      eight.setOnAction(new EightButtonHandler());
      
      Button nine = new Button("9");
      nine.setOnAction(new NineButtonHandler());
      
      Button negative = new Button("(-)");
      negative.setOnAction(new NegativeButtonHandler());
      
      Button decimal = new Button(".");
      decimal.setOnAction(new DecimalButtonHandler());
      
      //create vboxed so organize numbers
      VBox firstVB = new VBox(10, seven, four, one, decimal);
      VBox secondVB = new VBox(10, eight, five, two, zero);
      VBox thirdVB = new VBox(10, nine, six, three, negative);
      
      
      //create buttons for mathmathical signs
      Button mult = new Button("*");
      mult.setOnAction(new MultButtonHandler());
     
      Button div = new Button("/");
      div.setOnAction(new DivButtonHandler());
      
      Button add = new Button("+");
      add.setOnAction(new AddButtonHandler());
      
      Button sub = new Button("-");
      sub.setOnAction(new SubButtonHandler());
      
      Button equal = new Button("=");
      equal.setOnAction(new EqualButtonHandler());
      
      Button clear = new Button("CE");
      clear.setOnAction(new ClearButtonHandler());
        
      //create Vbox to organize signs
      VBox fourthVB = new VBox(10, div, mult, sub, add, equal, clear);
      
      result = new Label("");
      
      GridPane grid = new GridPane();
      grid.setHgap(10);
      
      grid.add(firstVB, 0, 1);
      grid.add(secondVB, 1, 1);
      grid.add(thirdVB, 2, 1);
      grid.add(fourthVB, 3, 1);
      
      VBox mainVB = new VBox(10, result, grid);
      
      Scene scene = new Scene(mainVB);
      primaryStage.setScene(scene);
      primaryStage.setWidth(160);
      primaryStage.setHeight(300);
      
      primaryStage.show();
      
      
  }
  
  class DecimalButtonHandler implements EventHandler<ActionEvent> {
  
     @Override
     public void handle(ActionEvent event) {
      
         str += ".";
         result.setText(str);
      
     }
   
  }
   
  class ZeroButtonHandler implements EventHandler<ActionEvent> {
   
     @Override
     public void handle(ActionEvent event) {
      
         str += "0";
         result.setText(str);
      
     }
   
  }
  
  class OneButtonHandler implements EventHandler<ActionEvent> {
   
      @Override
      public void handle(ActionEvent event) {  
      
         str += "1";
         result.setText(str); 
   
      }
   
   }
   
   class TwoButtonHandler implements EventHandler<ActionEvent> {
      
      @Override
      public void handle(ActionEvent event) {  
      
         str += "2";
         result.setText(str); 
   
      }    
   
   }
   class ThreeButtonHandler implements EventHandler<ActionEvent> {
       
      @Override
      public void handle(ActionEvent event) {  
      
         str += "3";
         result.setText(str); 
   
      }  
   
   }
   class FourButtonHandler implements EventHandler<ActionEvent> {
       
      @Override
      public void handle(ActionEvent event) {  
      
         str += "4";
         result.setText(str);  
   
      }
   
   }
   class FiveButtonHandler implements EventHandler<ActionEvent> {
   
      @Override
      public void handle(ActionEvent event) {  
      
         str += "5";
         result.setText(str);  
   
      }
   
   }
   class SixButtonHandler implements EventHandler<ActionEvent> {
       
      @Override
      public void handle(ActionEvent event) {  
      
         str += "6";
         result.setText(str);  
   
      } 
   
   }
   class SevenButtonHandler implements EventHandler<ActionEvent> {
       
      @Override
      public void handle(ActionEvent event) {  
      
         str += "7";
         result.setText(str);     
   
      }
 
   }
   class EightButtonHandler implements EventHandler<ActionEvent> {
       
      @Override
      public void handle(ActionEvent event) {  
      
         str += "8";
         result.setText(str); 
   
      }   
   
   }
   class NineButtonHandler implements EventHandler<ActionEvent> {
      
      @Override
      public void handle(ActionEvent event) {  
      
         str += "9";
         result.setText(str);  
   
      }  
   
   }
   
   class NegativeButtonHandler implements EventHandler<ActionEvent> {
   
     @Override
     public void handle(ActionEvent event) {
      
         str += "-";
         result.setText(str);
      
     }
   
  }
   
   class MultButtonHandler implements EventHandler<ActionEvent> {
      
      @Override
      public void handle(ActionEvent event) {  
      
         str += " * ";
         result.setText(str);  
   
      }

   }
   
   class DivButtonHandler implements EventHandler<ActionEvent> {
      
      @Override
      public void handle(ActionEvent event) {  
      
         str += " / ";
         result.setText(str);  
   
      }

   }
   
   class AddButtonHandler implements EventHandler<ActionEvent> {
      
      @Override
      public void handle(ActionEvent event) {  
      
         str += " + ";
         result.setText(str);  
   
      }

   }
   
   class SubButtonHandler implements EventHandler<ActionEvent> {
      
      @Override
      public void handle(ActionEvent event) {  
      
         str += " - ";
         result.setText(str);  
   
      }
  
   }
   
   class EqualButtonHandler implements EventHandler<ActionEvent> {
      
      @Override
      public void handle(ActionEvent event) {
         
         try {
            
            calc = new StringCalc(str);

            double answer = calc.getResult();
            
            str = "";
            str = Double.toString(answer);
            
            result.setText(str);    
         }
         catch (NoNumber e) {
            
            result.setText(e.getMessage());
         
         }
         
      }
   
   }
   
   class ClearButtonHandler implements EventHandler<ActionEvent> {
      
      @Override
      public void handle(ActionEvent event) {
         
         str = "";
         result.setText(str);
      
      }
   
   }
   
}