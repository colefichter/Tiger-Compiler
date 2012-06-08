package frame;

import mips.LinkedList;
import temp.Temp;
import temp.Label;
import util.BoolList;

public abstract class Frame {
	public Label name;
	public AccessList formals;
	abstract public Access allocLocal(boolean escape);	
	abstract public Frame newFrame(Label name, BoolList formals);
	
    public abstract int wordSize();
    public abstract Temp framePointer();
    public abstract String tempMap(Temp temp);
}
