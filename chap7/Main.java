import java.io.*;

import syntaxtree.*;
import visitor.*;

public class Main {
	public static void CompileFile() {
		try {
			Program root = MiniJavaParser.Goal();			
			BuildSymbolTableVisitor bstv = new BuildSymbolTableVisitor();
			root.accept(bstv); // create symbol table
			if (!bstv.error.anyErrors) {
				TypeCheckVisitor tcv = new TypeCheckVisitor(bstv.symbolTable);
				root.accept(tcv); // do type checks
				if (tcv.error.anyErrors) {
					System.out
							.println("\tSyntax and/or semantic error detected.");
				} /*else {
					 System.out.println("\tType-checking successful.");
				}*/
			}
			
			MIPSTranslator mt = new MIPSTranslator(bstv.symbolTable);
			root.accept(mt);
			
			
		} catch (ParseException e) {
			System.out.println(e.toString());
		}
	}
	
	public void EmitPreamble() {
		//TODO:
		// - define an ASCII string which contains a new line
		// - label the start of the main method code
		// - set up a stack frame
		// - recursively visit appropriate sub-tree(s) to generate main method code
		// - pops the stack frame
		// - performs the exit syscall
	}
	
	public static void main(String[] args) {
		try {
			File dir = new File("C:\\tiger2\\testcases\\");
			String[] children = dir.list();
			boolean firstRun = true;
			for (int i = 0; i < children.length; i++) {
				// Get filename of file or directory
				String filename = children[i];
				if (filename.endsWith(".java")) {
					System.out.println(filename + ": ");
					File file = new File("C:\\tiger2\\testcases\\" + filename);
					FileInputStream stream = new FileInputStream(file);
					if (firstRun) {
						new MiniJavaParser(stream);
						firstRun = false;
					} else {
						MiniJavaParser.ReInit(stream);
					}
					/*Program root = MiniJavaParser.Goal();
					BuildSymbolTableVisitor bstv = new BuildSymbolTableVisitor();
					root.accept(bstv); // create symbol table
					if (!bstv.error.anyErrors) {
						// bstv.symbolTable.dumpContents();
						TypeCheckVisitor tcv = new TypeCheckVisitor(bstv.symbolTable);
						root.accept(tcv); // do type checks
						if (tcv.error.anyErrors) {
							System.out
									.println("\tType-checking completed (with errors).");
						} else {
							 System.out.println("\tType-checking successful.");
						}
					}*/
					
					CompileFile();
				}
			}// end for

		/*} catch (ParseException e) {
			System.out.println(e.toString());*/
		} catch (FileNotFoundException fnfe) {
			System.out.println("File not found!");
		}
	}
}
