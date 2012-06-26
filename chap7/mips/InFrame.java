package mips;

import frame.Access;

///Represents a formal or local that is in a memory location at <offset> from the frame pointer.
public class InFrame extends Access {
	int offset;
	
	public InFrame(int offset) {
		this.offset = offset;
	}
	
	public tree.Exp exp(tree.Exp framePtr)
	{
		//TODO: ???
		return null;
	}
}
