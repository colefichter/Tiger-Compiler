package tree;
import temp.Temp;
import temp.Label;
//Evaluate an expression and discard the result (Functions as a conversion operator from Ex to Nx).
public class EXPX extends Stm {
  public Exp exp; 
  public EXPX(Exp e) {exp=e;}
  public ExpList kids() {return new ExpList(exp,null);}
  public Stm build(ExpList kids) {
    return new EXPX(kids.head);
  }
}

