public class Main {   
   public static void main(String [] args) {
      try {
    	  System.out.println("Run from the console. Type program input for lexical analysis.");
    	  System.out.println("Use CTRL+C to indicated EOF.");
         new MiniJavaParser(System.in).Goal();
         System.out.println("Lexical analysis successfull");
      }
      catch (ParseException e) {
         System.out.println("Lexer Error : \n"+ e.toString());
      }
   }
}


