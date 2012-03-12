package symbol;

import java.util.ArrayList;
import java.util.HashMap;
import syntaxtree.*;

public class ClassSymbol extends Symbol {	
	public ClassSymbol baseClass;
	
	//for fast lookups
	protected HashMap<String, MethodSymbol> methods = new HashMap<String, MethodSymbol>();
	protected HashMap<String, VariableSymbol> fields = new HashMap<String, VariableSymbol>();
	
	//later on, we'll need to know the order of declarations
	protected ArrayList<Symbol> orderedSymbols = new ArrayList<Symbol>();
	
	public boolean isTypeOf(String s) {
		if (this.getId().equals(s)) {
			return true;
		}
		else {
			if (baseClass != null) {
				return baseClass.isTypeOf(s);
			}
		}
		
		return false;
	}
	
	public MethodSymbol lookupMethod(String id) {
		if (methods.containsKey(id)) {
			return methods.get(id);
		}
		if (baseClass != null) {
			return baseClass.lookupMethod(id);
		}
		return null;
	}
	
	public VariableSymbol lookupField(String id) {
		if (fields.containsKey(id)) {
			return fields.get(id);
		}
		if (baseClass != null) {
			return baseClass.lookupField(id);
		}		
		return null;
	}
		
	public boolean addField(String id, Type t) {
		if (!fields.containsKey(id)) {
			VariableSymbol v = new VariableSymbol();
			v.id = id;
			v.t = t;
			fields.put(id, v);
			orderedSymbols.add(v);
			return true;
		}
		
		return false;
	}
	
	public MethodSymbol addMethod(String id) {
		if (!methods.containsKey(id)) {
			MethodSymbol m = new MethodSymbol();
			m.id = id;
			methods.put(id, m);
			orderedSymbols.add(m);
			return m;
		}
		
		return null;
	}
	
	public void dumpContents(int indent) {
		indent(indent);
		//TODO: does this print out baseClass properties? Should it?
		if (this.baseClass == null) {
			System.out.println(id);
		}
		else{
			System.out.println(id + " -> " + baseClass);
		}
		
		indent++;
		indent(indent);
		System.out.println("Fields:");		
		for (Symbol s : orderedSymbols) {
			if (s instanceof VariableSymbol) {
				s.dumpContents(indent + 1);
			}
		}
		
		indent(indent);
		System.out.println("Methods:");		
		for (Symbol s : orderedSymbols) {
			if (s instanceof MethodSymbol) {
				s.dumpContents(indent + 1);
			}
		}
	}
}
