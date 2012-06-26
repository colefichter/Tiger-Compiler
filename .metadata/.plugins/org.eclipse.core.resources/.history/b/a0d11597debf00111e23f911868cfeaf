package tree;
import temp.Temp;
import temp.Label;
public class CALL extends Exp {
  public Exp func;
  public ExpList args;
  public CALL(Exp f, ExpList a) {func=f; args=a;}
  public ExpList kids() {return new ExpList(func,args);}
  public Exp build(ExpList kids) {
    return new CALL(kids.head,kids.tail);
  }
  
}

