package tree;
import temp.Temp;
import temp.Label;
public class EXPSTM extends Stm {
  public Exp exp; 
  public EXPSTM(Exp e) {exp=e;}
  public ExpList kids() {return new ExpList(exp,null);}
  public Stm build(ExpList kids) {
    return new EXPSTM(kids.head);
  }
}

