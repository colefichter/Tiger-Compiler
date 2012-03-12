import java.io.*;

public class Main {   
   public static void main(String [] args) {
      try {    	  
    	  //File file = new File("C:\\tiger2\\testcases\\Factorial.java");
    	  File file = new File("C:\\tiger2\\testcases\\BubbleSort.java");
    	  //File file = new File("C:\\tiger2\\testcases\\Test1.java");
    	  FileInputStream stream = new FileInputStream(file);    	  
    	  MiniJavaParser parser = new MiniJavaParser(stream);
    	  parser.Goal();
    	  System.out.println("Parse succeeded.");         
      }
      catch (FileNotFoundException fnfe)
      {
    	  System.out.println("File not found!");
      }
      catch (ParseException e) {
         System.out.println("Parser Error : \n"+ e.toString());
      }
   }
}


