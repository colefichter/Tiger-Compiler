package visitor;

import java.util.*;
import symbol.*;
import syntaxtree.*;

public class BuildSymbolTableVisitor extends DepthFirstVisitor {
	public SymbolTable symbolTable = new SymbolTable(); // main symbol table for
														// the Program (root).

	// current class
	ClassSymbol currClass = null;

	// current method
	MethodSymbol currMethod = null;

	public class ErrorMsg {
		public boolean anyErrors = false;

		void complain(String msg) {
			anyErrors = true;
			System.out.println(msg);
		}
	}

	public ErrorMsg error = new ErrorMsg();

	public void visit(ClassDeclSimple n) {
		String id = n.i.toString();
		ClassSymbol c = symbolTable.addClass(id);
		if (c == null) {
			error.complain("class " + id + " is already defined");
		} else {
			currClass = c; // begin new scope
			// recurse into n
			for (int i = 0; i < n.vl.size(); i++) {
				n.vl.elementAt(i).accept(this);
			}
			for (int i = 0; i < n.ml.size(); i++) {
				n.ml.elementAt(i).accept(this);
			}
			currClass = null; // end scope
		}
	}

	public void visit(ClassDeclExtends n) {
		String id = n.i.toString();
		String baseClass = n.j.toString();
		ClassSymbol c = symbolTable.addClass(id);
		if (c == null) {
			// TODO: improve error handling (p 114)
			error.complain("class " + id + " is already defined");
		} else {
			currClass = c; // begin new scope
			c.baseClass = symbolTable.lookup(baseClass);
			// recurse into n
			for (int i = 0; i < n.vl.size(); i++) {
				n.vl.elementAt(i).accept(this);
			}
			for (int i = 0; i < n.ml.size(); i++) {
				n.ml.elementAt(i).accept(this);
			}
			currClass = null; // end scope
		}
	}

	public void visit(MethodDecl n) {
		String id = n.i.toString();
		//Type t = n.t.accept(this); // the return type
		Type t = n.t;
		MethodSymbol m = currClass.addMethod(id);
		if (m == null) {
			// TODO: improve error handling (p 114)
			error.complain("method " + id + " is already defined");
		} else {
			currMethod = m; // begin scope
			m.returnType = t;
			// recurse into n
			for (int i = 0; i < n.fl.size(); i++) {
				n.fl.elementAt(i).accept(this);
			}
			for (int i = 0; i < n.vl.size(); i++) {
				n.vl.elementAt(i).accept(this);
			}
			for (int i = 0; i < n.sl.size(); i++) {
				n.sl.elementAt(i).accept(this);
			}
			n.e.accept(this);
			currMethod = null; // end scope
		}
	}

	public void visit(VarDecl n) {
		//Type t = n.t.accept(this); // the variable type		
		String id = n.i.toString();
		if (currMethod == null) {
			if (!currClass.addField(id, n.t))
				error.complain(n.t.toString() + " '" + id + "' is already defined in class "
						+ currClass.getId());
		} else if (!currMethod.addLocal(id, n.t))
			error.complain(n.t.toString() + " '" + id + "' is already defined in method "
					+ currClass.getId() + "." + currMethod.getId());
	}

	public void visit(Formal n) {
		//Type t = n.t.accept(this); // the variable type
		String id = n.i.toString();
		if (!currMethod.addParam(id, n.t))
			error.complain(n.t + " '" + id
					+ "' is already defined as a parameter of method "
					+ currClass.getId() + "." + currMethod.getId());
	}
}
