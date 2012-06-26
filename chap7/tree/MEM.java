package tree;
import temp.Temp;
import temp.Label;
//The contents of wordSize bytes of memory starting at a given address (e). The constant wordSize is defined in the Frame module.
//When MEM is used as the left child of a MOVE, it means "store", but anywhere else means "fetch".
public class MEM extends Exp {
  public Exp exp;
  public MEM(Exp e) {exp=e;}
  public ExpList kids() {return new ExpList(exp,null);}
  public Exp build(ExpList kids) {
    return new MEM(kids.head);
  }
}

