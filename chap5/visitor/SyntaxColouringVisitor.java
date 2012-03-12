package visitor;

import syntaxtree.*;

public class SyntaxColouringVisitor implements Visitor {

	private void begin() {
		System.out.println("<html><body>");
	}

	private void end() {
		System.out.println("</body></html>");
	}

	private void blue(String text) {
		color(text, "blue");
	}

	private void red(String text) {
		color(text, "red");
	}
	
	private void green(String text) {
		color(text, "green");
	}

	private void grey(String text) {
		color(text, "grey");
	}
	
	private void black(String text) {
		color(text, "black");
	}
	
	private void color(String text, String color) {
		System.out.print("<font color='" + color + "'>" + text + "</font>");		
	}
	
	private void newline() {
		System.out.print("<br />");
	}

	// MainClass m;
	// ClassDeclList cl;
	public void visit(Program n) {
		begin();
		n.m.accept(this);
		for (int i = 0; i < n.cl.size(); i++) {
			System.out.println();
			n.cl.elementAt(i).accept(this);
		}
		end();
	}

	// Identifier i1,i2;
	// Statement s;
	public void visit(MainClass n) {
		// System.out.print("class ");
		blue("class ");		
		n.i1.accept(this);
		grey(" {");
		newline();
		//System.out.print("  public static void main (String [] ");
		blue("  public static ");
		green("void ");
		black("main (");
		green("String");
		black("[] ");
		n.i2.accept(this);
		//System.out.println(") {");
		//System.out.print("    ");
		black(") {");
		newline();
		black("    ");
		
		n.s.accept(this);
		//System.out.println("  }");
		//System.out.println("}");
		black("  }");
		newline();
		black("}");
		newline();
	}

	// Identifier i;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclSimple n) {
		System.out.print("class ");
		n.i.accept(this);
		System.out.println(" { ");
		for (int i = 0; i < n.vl.size(); i++) {
			System.out.print("  ");
			n.vl.elementAt(i).accept(this);
			if (i + 1 < n.vl.size()) {
				System.out.println();
			}
		}
		for (int i = 0; i < n.ml.size(); i++) {
			System.out.println();
			n.ml.elementAt(i).accept(this);
		}
		System.out.println();
		System.out.println("}");
	}

	// Identifier i;
	// Identifier j;
	// VarDeclList vl;
	// MethodDeclList ml;
	public void visit(ClassDeclExtends n) {
		System.out.print("class ");
		n.i.accept(this);
		System.out.println(" extends ");
		n.j.accept(this);
		System.out.println(" { ");
		for (int i = 0; i < n.vl.size(); i++) {
			System.out.print("  ");
			n.vl.elementAt(i).accept(this);
			if (i + 1 < n.vl.size()) {
				System.out.println();
			}
		}
		for (int i = 0; i < n.ml.size(); i++) {
			System.out.println();
			n.ml.elementAt(i).accept(this);
		}
		System.out.println();
		System.out.println("}");
	}

	// Type t;
	// Identifier i;
	public void visit(VarDecl n) {
		n.t.accept(this);
		System.out.print(" ");
		n.i.accept(this);
		System.out.print(";");
	}

	// Type t;
	// Identifier i;
	// FormalList fl;
	// VarDeclList vl;
	// StatementList sl;
	// Exp e;
	public void visit(MethodDecl n) {
		System.out.print("  public ");
		n.t.accept(this);
		System.out.print(" ");
		n.i.accept(this);
		System.out.print(" (");
		for (int i = 0; i < n.fl.size(); i++) {
			n.fl.elementAt(i).accept(this);
			if (i + 1 < n.fl.size()) {
				System.out.print(", ");
			}
		}
		System.out.println(") { ");
		for (int i = 0; i < n.vl.size(); i++) {
			System.out.print("    ");
			n.vl.elementAt(i).accept(this);
			System.out.println("");
		}
		for (int i = 0; i < n.sl.size(); i++) {
			System.out.print("    ");
			n.sl.elementAt(i).accept(this);
			if (i < n.sl.size()) {
				System.out.println("");
			}
		}
		System.out.print("    return ");
		n.e.accept(this);
		System.out.println(";");
		System.out.print("  }");
	}

	// Type t;
	// Identifier i;
	public void visit(Formal n) {
		n.t.accept(this);
		System.out.print(" ");
		n.i.accept(this);
	}

	public void visit(IntArrayType n) {
		System.out.print("int []");
	}

	public void visit(BooleanType n) {
		System.out.print("boolean");
	}

	public void visit(IntegerType n) {
		System.out.print("int");
	}

	// String s;
	public void visit(IdentifierType n) {
		System.out.print(n.s);
	}

	// StatementList sl;
	public void visit(Block n) {
		System.out.println("{ ");
		for (int i = 0; i < n.sl.size(); i++) {
			System.out.print("      ");
			n.sl.elementAt(i).accept(this);
			System.out.println();
		}
		System.out.print("    } ");
	}

	// Exp e;
	// Statement s1,s2;
	public void visit(If n) {
		System.out.print("if (");
		n.e.accept(this);
		System.out.println(") ");
		System.out.print("    ");
		n.s1.accept(this);
		System.out.println();
		System.out.print("    else ");
		n.s2.accept(this);
	}

	// Exp e;
	// Statement s;
	public void visit(While n) {
		System.out.print("while (");
		n.e.accept(this);
		System.out.print(") ");
		n.s.accept(this);
	}

	// Exp e;
	public void visit(Print n) {
		System.out.print("System.out.println(");
		n.e.accept(this);
		System.out.print(");");
	}

	// Identifier i;
	// Exp e;
	public void visit(Assign n) {
		n.i.accept(this);
		System.out.print(" = ");
		n.e.accept(this);
		System.out.print(";");
	}

	// Identifier i;
	// Exp e1,e2;
	public void visit(ArrayAssign n) {
		n.i.accept(this);
		System.out.print("[");
		n.e1.accept(this);
		System.out.print("] = ");
		n.e2.accept(this);
		System.out.print(";");
	}

	// Exp e1,e2;
	public void visit(And n) {
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" && ");
		n.e2.accept(this);
		System.out.print(")");
	}

	// Exp e1,e2;
	public void visit(LessThan n) {
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" < ");
		n.e2.accept(this);
		System.out.print(")");
	}

	// Exp e1,e2;
	public void visit(Plus n) {
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" + ");
		n.e2.accept(this);
		System.out.print(")");
	}

	// Exp e1,e2;
	public void visit(Minus n) {
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" - ");
		n.e2.accept(this);
		System.out.print(")");
	}

	// Exp e1,e2;
	public void visit(Times n) {
		System.out.print("(");
		n.e1.accept(this);
		System.out.print(" * ");
		n.e2.accept(this);
		System.out.print(")");
	}

	// Exp e1,e2;
	public void visit(ArrayLookup n) {
		n.e1.accept(this);
		System.out.print("[");
		n.e2.accept(this);
		System.out.print("]");
	}

	// Exp e;
	public void visit(ArrayLength n) {
		n.e.accept(this);
		System.out.print(".length");
	}

	// Exp e;
	// Identifier i;
	// ExpList el;
	public void visit(Call n) {
		n.e.accept(this);
		System.out.print(".");
		n.i.accept(this);
		System.out.print("(");
		for (int i = 0; i < n.el.size(); i++) {
			n.el.elementAt(i).accept(this);
			if (i + 1 < n.el.size()) {
				System.out.print(", ");
			}
		}
		System.out.print(")");
	}

	// int i;
	public void visit(IntegerLiteral n) {
		System.out.print(n.i);

		// testing a way to get the position of errors...
		// System.out.print(" _LINE:" + n.position.line + "_ ");
		// System.out.print(" _COLUMN:" + n.position.column + "_ ");
	}

	public void visit(True n) {
		System.out.print("true");
	}

	public void visit(False n) {
		System.out.print("false");
	}

	// String s;
	public void visit(IdentifierExp n) {
		System.out.print(n.s);
	}

	public void visit(This n) {
		System.out.print("this");
	}

	// Exp e;
	public void visit(NewArray n) {
		System.out.print("new int [");
		n.e.accept(this);
		System.out.print("]");
	}

	// Identifier i;
	public void visit(NewObject n) {
		System.out.print("new ");
		System.out.print(n.i.s);
		System.out.print("()");
	}

	// Exp e;
	public void visit(Not n) {
		System.out.print("!");
		n.e.accept(this);
	}

	// String s;
	public void visit(Identifier n) {
		System.out.print(n.s);
	}
}
