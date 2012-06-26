package tree;
import temp.Temp;
import temp.Label;

//A procedure call applys a function (f) to a list of arguments (args).
//The subexpression f must be evaluated before the list of args, which are evaluated from left to right.
public class CALL extends Exp {
  public Exp func;
  public ExpList args;
  public CALL(Exp f, ExpList a) {func=f; args=a;}
  public ExpList kids() {return new ExpList(func,args);}
  public Exp build(ExpList kids) {
    return new CALL(kids.head,kids.tail);
  }
  
}

