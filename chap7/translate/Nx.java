package translate;

import temp.*;

///An expression that does not yield a value. Thus, a statement, essentially.
public class Nx extends Exp{
	tree.Stm stm;
	Nx(tree.Stm s) { stm=s; }
	tree.Exp unEx() {
		throw new UnsupportedOperationException("This method should never be called. See top of page 143 for details.");
	}
	tree.Stm unNx() { return stm; }
	tree.Stm unCx(Label t, Label f) {
		throw new UnsupportedOperationException("This method should never be called. See top of page 143 for details.");
	}	
}
