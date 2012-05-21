package tree;
import temp.Temp;
import temp.Label;
public class JUMP extends Stm {
  public Exp exp;
  public temp.LabelList targets;
  public JUMP(Exp e, temp.LabelList t) {exp=e; targets=t;}
  public JUMP(temp.Label target) {
      this(new NAME(target), new temp.LabelList(target,null));
  }
  public ExpList kids() {return new ExpList(exp,null);}
  public Stm build(ExpList kids) {
    return new JUMP(kids.head,targets);
  }
}

