class And {
    public static void main(String[] args) 
    {
	if (false && false) 
	    System.out.println(0);
	else if (false && true)
	    System.out.println(1);
	else if (true && false)
	    System.out.println(2);
	else
	    System.out.println(3);
    }
}
