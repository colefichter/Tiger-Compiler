
//CF: this is not part of the original syntaxtree package.

package syntaxtree;

public class Position {
	public int line = 0;
	public int column = 0;
	
	public Position(int theLine, int theColumn) {
		line = theLine;
		column = theColumn;
	}
}