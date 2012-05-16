class RunIterator{	
	public static void main(String[] a){
		System.out.println(new Iterator().Run());		
    }
}

class Iterator {
	int[] number;
	public int Run()
	{
		number = new int[5];
		
		number[0] = 0;
		number[1] = 1;
		number[2] = 2;
		number[3] = 3;
		number[4] = 4;
		
		number.each() {
			System.out.println("TESTING");
		}
		
		return 999;
	}
}

