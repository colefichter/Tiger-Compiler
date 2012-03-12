import java.io.*;
import syntaxtree.*;
import visitor.*;

public class Main {
	public static void main(String[] args) {

		try {
			//File file = new File("C:\\tiger2\\testcases\\BinarySearch.java");
			//File file = new File("C:\\tiger2\\testcases\\BinaryTree.java");
			//File file = new File("C:\\tiger2\\testcases\\BubbleSort.java");
			File file = new File("C:\\tiger2\\testcases\\Factorial.java");
			//File file = new File("C:\\tiger2\\testcases\\LinearSearch.java");
			//File file = new File("C:\\tiger2\\testcases\\LinkedList.java");
			//File file = new File("C:\\tiger2\\testcases\\QuickSort.java");
			//File file = new File("C:\\tiger2\\testcases\\Test1.java");
			//File file = new File("C:\\tiger2\\testcases\\TreeVisitor.java");
			FileInputStream stream = new FileInputStream(file);
			Program root = new MiniJavaParser(stream).Goal();
			
			// Print the original source code from the abstract syntax tree:
			root.accept(new PrettyPrintVisitor());
			//root.accept(new ASTPrintVisitor());
			
			// Print the abstract syntax tree:
			//root.accept(new ASTPrintVisitor());	// Should this have been called "UglyPrintVisitor"? :)
			
		} catch (ParseException e) {
			System.out.println(e.toString());
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
		}

		/*try {  
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
		}*/
	}
}
