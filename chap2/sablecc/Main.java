//import minijava.parser.*;
import minijava.lexer.*;
import minijava.node.*;
import java.io.*;

public class Main{
    
    public static void main(String[] arguments){
	try{
	    
	    // Create a lexer instance.
	    Lexer l = new Lexer(new PushbackReader
		(new InputStreamReader(System.in), 1024));
		
	    Token t = l.next();
	    while (!t.getText().equals("")){ 
		System.out.print(t.toString());
		t = l.next(); 
	    }
	}
	catch(Exception e){
	    System.out.println(e.getMessage());
	}
	
    }
}

