class NewObject {
    public static void main(String[] args) 
    {
	System.out.println(new C().testing());
    }
}

class C 
{
    public int testing() 
    {
	return 123;
    }
}
