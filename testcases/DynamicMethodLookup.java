class DynamicMethodLookup {
    public static void main(String[] args) 
    {
	System.out.println(new Test().testMethods());
    }
}

class Test 
{
    public int testMethods()
    {
	// This follows the example of Figure 14.3
	A a;
	B b;
	C c;
	D d;
	B b2;
	B b3;
	a = new A();
	b = new B();
	c = new C();
	d = new D();
	System.out.println(a.f());
	System.out.println(b.f());
	System.out.println(b.g());
	System.out.println(c.f());
	System.out.println(c.g());
	System.out.println(d.f());
	System.out.println(d.g());
	b2 = c;
	b3 = d;
	System.out.println(b2.f());
	System.out.println(b2.g());
	System.out.println(b3.f());
	System.out.println(b3.g());
	return 0;
    }
}

class A
{
    public int f()
    {
	return 1;
    }
}

class B extends A
{
    public int g()
    {
	return 2;
    }
}

class C extends B
{
    public int g()
    {
	return 3;
    }
}

class D extends C
{
    public int f()
    {
	return 4;
    }
}
