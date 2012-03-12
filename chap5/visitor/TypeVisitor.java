package visitor;

import syntaxtree.*;

public interface TypeVisitor {
  public Type visit(Program n);
  public Type visit(MainClass n);
  public Type visit(ClassDeclSimple n);
  public Type visit(ClassDeclExtends n);
  public Type visit(VarDecl n);
  public Type visit(MethodDecl n);
  public Type visit(Formal n);
  public Type visit(IntArrayType n);
  public Type visit(BooleanType n);
  public Type visit(IntegerType n);
  public Type visit(IdentifierType n);
  public Type visit(Block n);
  public Type visit(If n);
  public Type visit(While n);
  public Type visit(Print n);
  public Type visit(Assign n);
  public Type visit(ArrayAssign n);
  public Type visit(And n);
  public Type visit(LessThan n);
  public Type visit(Plus n);
  public Type visit(Minus n);
  public Type visit(Times n);
  public Type visit(ArrayLookup n);
  public Type visit(ArrayLength n);
  public Type visit(Call n);
  public Type visit(IntegerLiteral n);
  public Type visit(True n);
  public Type visit(False n);
  public Type visit(IdentifierExp n);
  public Type visit(This n);
  public Type visit(NewArray n);
  public Type visit(NewObject n);
  public Type visit(Not n);
  public Type visit(Identifier n);
}
