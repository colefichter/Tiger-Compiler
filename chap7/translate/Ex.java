package translate;

import tree.Stm;
import temp.*;

///An ordinary expression that yields a single value.
public class Ex extends Exp{
	tree.Exp exp;
	Ex(tree.Exp e) { exp = e; }
	public tree.Exp unEx() { return exp; }
	tree.Stm unNx() { 
		return new tree.EXPX(exp); //this is not actually useful in mini-java!
	}	
	//This method is useful for implementing conditionals (eg: less than comparison). See http://homepages.ius.edu/rwisman/C431/html/Chapter7.htm
	tree.Stm unCx(Label t, Label f) {
		if (exp instanceof tree.CONST) {
			tree.CONST c = (tree.CONST) exp;
			if (c.value == 1) {
				return new tree.JUMP(t);
			}
			else {
				return new tree.JUMP(f);
			}
		}
		
		return new tree.CJUMP(tree.CJUMP.NE, exp, new tree.CONST(0), t, f);
	}
}
