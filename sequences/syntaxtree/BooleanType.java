package syntaxtree;import visitor.BuildSymbolTableVisitor;import visitor.InterpreterVisitor;import visitor.Visitor;import visitor.TypeVisitor;public class BooleanType extends Type {	public BooleanType() {}	public BooleanType(Position p){		position=p;	}	  public void accept(Visitor v) {    v.visit(this);  }  public Type accept(TypeVisitor v) {    return v.visit(this);  }    public Type accept(BuildSymbolTableVisitor v){	  return new BooleanType();  }    public String toString() {  	  return "boolean";  }    public Object accept(InterpreterVisitor v) {	  return v.visit(this);  }}