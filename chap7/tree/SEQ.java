package tree;
import temp.Temp;
import temp.Label;
public class SEQ extends Stm {
  public Stm left, right;
  public SEQ(Stm l, Stm r) { left=l; right=r; }
  public ExpList kids() {throw new Error("kids() not applicable to SEQ");}
  public Stm build(ExpList kids) {throw new Error("build() not applicable to SEQ");}
}

