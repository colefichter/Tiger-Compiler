package mips;

import frame.Access;
import temp.*;

///Represents a formal or local that will be stored in the register identified by <temp>.
public class InReg extends Access {
	Temp temp;
	
	public InReg(Temp t) {
		this.temp = t;
	}	
	
	public tree.Exp exp(tree.Exp framePtr)
	{
		//TODO: ???
		return null;
	}
}
