package syntaxtree;import visitor.InterpreterVisitor;import visitor.Visitor;import visitor.TypeVisitor;public class And extends Exp {  public Exp e1,e2;    public And(Exp ae1, Exp ae2, Position p) {     e1=ae1; e2=ae2; position=p;  }  public void accept(Visitor v) {    v.visit(this);  }  public Type accept(TypeVisitor v) {    return v.visit(this);  }    public Object accept(InterpreterVisitor v) {	  return v.visit(this);  }}