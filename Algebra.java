// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	     // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2 < 0) {
			for(int i = x2; i < 0 ; i++)
			{
				x1--;
			}
		}
 		else{
			for(int i = 0; i < x2; i++){
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2 < 0)
		{
			for(int i = x2; i < 0; i++)
			{
				x1++;
			}
		}
		else
		{
			for(int i = 0; i < x2; i++){
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int result = 0;
		int times = x2;
		if(times < 0)
		{
			times = minus(0,times);
		}
		for(int i = 0; i < times; i++)
		{
			if(x2 < 0) {
				result = minus(result,x1);
			}
			else
			{
				result = plus(result,x1);
			}
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int result = 1;
		for(int i = 0; i < n; i++)
		{
			result = times(x,result);
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int result = 0;
		int abs = x1;
		int abs2 = 0;
		if(abs < 0)
		{
			abs = minus(0,x1);
		}
		while(abs2 <= abs)
		{
			result++;
			abs2 = times(x2,result);
			if(abs2 < 0) {
				abs2 = minus(0,abs2);
			}
		}
		result--;
		if(x1 < 0 && x2 > 0 || x1 > 0 && x2 < 0)
		{
			return minus(0,result);
		}
		return result;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		return minus(x1,times(div(x1,x2),x2));
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int result = 0;
		while(times(result,result) <= x)
		{
			result++;
		}
		return --result;
	}	  	  
}