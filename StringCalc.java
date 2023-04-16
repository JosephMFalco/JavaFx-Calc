import java.util.ArrayList;
import java.util.List;

public class StringCalc {
   
   public String str;
   
   public StringCalc() {
      
      str = "1 + 1";
      
   }
   
   public StringCalc(String s) throws NoNumber {
      
      boolean valid = false;
      String[] tokens = s.split(" ");
      List<String> tokenList = java.util.Arrays.asList(tokens);
      int i = 0;
      
      //Create if Statement to find operators at the end of an expression
      if(s.charAt(s.length()-1) == '*' || s.charAt(s.length()-1) == '/' || s.charAt(s.length()-1) == '-' || s.charAt(s.length()-1) == '+')
         valid = false;
      else {
         
         //Create advanced for loop to iterate through tokenList
         for(String token : tokenList) {
            
            if(token.isEmpty()) {
                        
               valid = false;
               break;
                     
            }
            
            if(tokenList.size() >= 3) {
               
               //Create if statement to pass negative numbers
               if(token.length() >= 2 && token.charAt(0) == '-' && Character.isDigit(token.charAt(1))) {
                     
                  valid = true;
               
               }
               else if(token.charAt(0) == '*' || token.charAt(0) == '/' || token.charAt(0) == '-' || token.charAt(0) == '+') {
                  
                  //Create if statment to make sure an operator does not come at the start of an expression
                  if(i > 0 && i < tokenList.size()) {
                     
                     if(tokenList.get(i+1).isEmpty()) {
                        
                        //if token is empty expression is invalid ending the loop
                        valid = false; 
                        break;
                     
                     }
                     
                     //Create if statement to make sure numbers surround operators
                     if(Character.isDigit(tokenList.get(i-1).charAt(0)) && Character.isDigit(tokenList.get(i+1).charAt(0))) {
                        
                        valid = true;
                       
                     }
                  }
                  else {
                     
                     //if expression starts with operator is invalid ending the loop
                     valid = false;
                     break;
                     
                  }
         
               }
            }
            else
               valid = false;
            
            i++;  
         
         } 
      
      }
      
      //throw exception if expression is invalid
      if(!valid) 
        throw new NoNumber();
      else
         str = s;
 
   }
   
   public double getResult() {
      
      int i = 0;
      String[] tokens = str.split(" ");
      ArrayList<Double> numbers = new ArrayList<Double>();
      ArrayList<String> operators = new ArrayList<String>();
      double answer = 0;
      
      //create advanced for loop to iterate through tokens
      for(String token : tokens) {
         
         //Create if statement to discover negative numbers and pass them into the numbers list
         if(token.length() >= 2 && token.charAt(0) == '-' && Character.isDigit(token.charAt(1)))
            numbers.add(Double.parseDouble(token));
         //Create if statement to pass digits to the numbers list
         else if(Character.isDigit(token.charAt(0))) 
            numbers.add(Double.parseDouble(token)); 
         //If token is neither negative number or digit pass it to the operators list
         else
            operators.add(token);
      
      }
      
      //set up system that allows calculator to follow order of operations
      
      //iterate through operators finding mulitiplication or division
      for(String op : operators) {
         
         if(op.equals("*")) { 
         
            answer = numbers.get(i) * numbers.get(i+1);
            numbers.set(i+1, answer);
            numbers.remove(i);
            i--;
    
         }
         
         if(op.equals("/")) {
         
            answer = numbers.get(i) / numbers.get(i+1);
            numbers.set(i+1, answer);
            numbers.remove(i);
            i--;
  
         }
         
         i++;
         
         if(numbers.size() == i+1)
            i--;
         
      }
      
      i = 0;
      
      //iterate through operators finding addition or subtraction
      for(String op : operators) {
         
         if(op.equals("+")){
         
            answer = numbers.get(i) + numbers.get(i+1);
            numbers.set(i+1, answer);
            numbers.remove(i);
            i--;
         
         }
            
         if(op.equals("-")){
            
            if(numbers.get(i+1) < 0)
               numbers.set(i+1, -numbers.get(i+1));
            answer = numbers.get(i) - numbers.get(i+1);
            numbers.set(i+1, answer);
            numbers.remove(i);
            i--;
         
         }
         
         i++;
         
         if(op.equals("*"))
            i = 0;
         if(op.equals("/"))
            i = 0;
            
         if(numbers.size() <= i+1)
            i--;
         
        
      }
   
      return answer;
   }

}