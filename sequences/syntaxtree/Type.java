package syntaxtree;import visitor.BuildSymbolTableVisitor;import visitor.InterpreterVisitor;import visitor.Visitor;import visitor.TypeVisitor;public abstract class Type {    public abstract void accept(Visitor v);  public abstract Type accept(TypeVisitor v);    public abstract Type accept(BuildSymbolTableVisitor v);  public abstract Object accept(InterpreterVisitor v);  public Position position = null;  public abstract String toString();}