package tree;
import temp.Temp;
import temp.Label;
//Represents a symbolic constant (corresponding to an assembly language label).
public class NAME extends Exp {
  public Label label;
  public NAME(Label l) {label=l;}
  public ExpList kids() {return null;}
  public Exp build(ExpList kids) {return this;}
}

