package frame;

public abstract class AccessList {
	public Access head;
	public Access tail;
	//TODO - constructor? public AccessList(Access h, Access, t)
	public AccessList(Access h, Access t) {
		head = h;
		tail = t;
	}
}
