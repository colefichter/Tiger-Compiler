package translate;

import tree.Stm;
import temp.*;

///A conditional expression that jumps to either t or f.
public abstract class Cx extends Exp{
	tree.Exp unEx() {
		Temp r = new Temp();
		Label t = new Label();
		Label f = new Label();
		
		return new tree.ESEQ(
				new tree.SEQ(new tree.MOVE(new tree.TEMP(r), new tree.CONST(1)),
					new tree.SEQ(unCx(t, f),
							new tree.SEQ(new tree.LABEL(f),
									new tree.SEQ(new tree.MOVE(new tree.TEMP(r),new tree.CONST(0)),
												new tree.LABEL(t)
												)
										)
								)
							),
				new tree.TEMP(r)
		);
	}
	
	abstract tree.Stm unCx(Label t, Label f);
	
	tree.Stm unNx() {
		//TODO ???
		return null;
	}
}
