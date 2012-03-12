class SimpleArray {
    public static void main(String[] a){
	System.out.println(new ArrayTest().test(3));
    }
}

class ArrayTest {

    public int test(int num){
	int i;
	int[] intArray;
	intArray = new int[num];
	System.out.println(intArray.length);
	i = 0;
	System.out.println(111);
	while (i < intArray.length) {
	    System.out.println(i + 1);
	    intArray[i] = i + 1;
	    i = i + 1;
	}
	System.out.println(222);
	i = 0;
	while (i < intArray.length) {
	    System.out.println(intArray[i]);
	    i = i + 1;
	}
	System.out.println(333);
	return intArray.length;
    }

}
