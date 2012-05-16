class IntArraySequence {
    public static void main(String[] args) 
    {
    	System.out.println(new Test().Run());
    }
}

class Test 
{
	int[] myarray;
	int start;
	int end;
	boolean test;
    public int Run()
    {		
    	test = false;
    	start = 0;
    	end = 99;
    	//this evaluates correctly:
    	myarray = seq(start:end);
    	
    	//use this line to cause a type mismatch:
    	//myarray = seq(start:test);    	
    	return 0;
    }
}