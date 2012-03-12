package symbol;

import java.util.*;

public class SymbolTable {
	//for fast lookups
	protected HashMap<String, ClassSymbol> t = new HashMap<String, ClassSymbol>();
	
	//later on, we'll need to know the order of declarations
	protected ArrayList<ClassSymbol> orderedClasses = new ArrayList<ClassSymbol>();
	
	public ClassSymbol lookup(String id) {
		if (t.containsKey(id)) {
			return t.get(id);
		}
		return null;
	}
	
	//Adds a new class to the table. If the ID already exists, returns null. If successful, returns the ClassSymbol instance.
	public ClassSymbol addClass(String id) {
		//System.out.println(id);
		if (!t.containsKey(id)) {
			ClassSymbol c = new ClassSymbol();
			c.id = id;
			t.put(id, c);
			orderedClasses.add(c);
			return c;
		}
		
		return null;
	}
	
	public void dumpContents() {		
		System.out.println("Classes (" + t.size() + "):");
		for (int i = 0; i < orderedClasses.size(); i++) {
			ClassSymbol c = orderedClasses.get(i);			
			c.dumpContents(1);
		}		
		System.out.println("");		
	}
}
