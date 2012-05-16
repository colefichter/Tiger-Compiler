package frame;

import temp.Temp;
import temp.Label;
import util.BoolList;

public abstract class Frame {
	public Label name;
	public AccessList formals;
	abstract public Access allocLocal(boolean escape);	
	abstract public Frame newFrame(Label name, BoolList formals);
	
	//more stuff later on...
}
