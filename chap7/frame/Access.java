package frame;


///Describes formals or locals that may be in the frame or registers.
public abstract class Access {
	
	///See top of p 144.
	public abstract tree.Exp exp(tree.Exp framePtr);
		
	//TODO?
}
