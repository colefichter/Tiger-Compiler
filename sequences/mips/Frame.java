package mips;

import temp.Label;
import util.BoolList;
import frame.Access;
import frame.AccessList;

public class Frame extends frame.Frame {

	public Access allocLocal(boolean escape) {
		//TODO
		return null;
	}
	
	public Frame newFrame(Label name, BoolList formals) {
		mips.Frame f = new mips.Frame();
		//TODO: set members...
		
		return f;
	}
}
