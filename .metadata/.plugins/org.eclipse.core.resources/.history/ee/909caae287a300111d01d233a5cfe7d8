package visitor;

import syntaxtree.*;
import symbol.*;

public interface InterpreterVisitor {
  public Object visit(Program n);
  public Object visit(MainClass n);
  public Object visit(ClassDeclSimple n);
  public Object visit(ClassDeclExtends n);
  public Object visit(VarDecl n);
  public Object visit(MethodDecl n);
  public Object visit(Formal n);
  public Object visit(IntArrayType n);
  public Object visit(BooleanType n);
  public Object visit(IntegerType n);
  public Object visit(IdentifierType n);
  public Object visit(Block n);
  public Object visit(If n);
  public Object visit(While n);
  public Object visit(Print n);
  public Object visit(Assign n);
  public Object visit(ArrayAssign n);
  public Object visit(And n);
  public Object visit(LessThan n);
  public Object visit(Plus n);
  public Object visit(Minus n);
  public Object visit(Times n);
  public Object visit(ArrayLookup n);
  public Object visit(ArrayLength n);
  public Object visit(Call n);
  public int visit(IntegerLiteral n);
  public boolean visit(True n);
  public boolean visit(False n);
  public Symbol visit(IdentifierExp n);
  public Symbol visit(This n);
  public int[] visit(NewArray n);
  
  public Object visit(SeqExp n);
  
  public ClassSymbol visit(NewObject n);
  public Object visit(Not n);
  public Object visit(Identifier n);
}
