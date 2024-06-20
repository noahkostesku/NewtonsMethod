import java.util.Arrays;

public class NewtonHiddenTest {
		
	private static final String DIVIDE = "divide by zero error";
	private static final String ITER = "maximum iteration exceeded";


	// HIDDEN OLL TESTS 

	public static boolean hiddenTestOLL00() { 

		OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();

		for (int i = 0; i < 100; i++) { 
			oll.insert(i);
		}

		boolean result = true;
		for (int i = 0; i< 100; i++) { 
			result = result && (i == 100-oll.get(i)-1);
		}
		return result;


	}

	public static boolean hiddenTestOLL01() { 

		OrderedLinkedList<Integer> oll = new OrderedLinkedList<>();

		int[] data = { 86, 57, 30, 9, 9001, 42, 0, 10, 100, 1000, 4 };

		for (int i : data) { 
			oll.insert(i);
		}

		Arrays.sort(data);

		boolean result = true;
		for (int i = 0; i < oll.getSize(); i++) { 
			result = result && (oll.get(i) == data[data.length-i-1]);
		}
		return result;
	}


	// HIDDEN POLY TESTS 
	public static boolean hiddenTest00() {
		Polynomial p = new Polynomial();
		p.add(-27,794);
		p.add(-57,1);
		p.add(12,770);
		p.add(78,102);
		p.add(6,871);
		p.add(-95,99);
		p.add(-98,512);
		p.add(100,166);
		p.add(65,893);
		p.add(76,125);
		p.add(55,200);
		p.add(10,628);
		p.add(73,166);
		p.add(6,852);
		p.add(41,703);
		p.add(32,402);
		p.add(-7,221);
		p.add(33,492);
		p.add(-45,457);
		p.add(73,85);
		double result = 0;
		try {
			result = p.solve(-2,1e-6,1000);
			//final double SOLN = -1.0015135709907999;
			double eval = p.eval(result);
			return Math.abs(eval) < 1e-3;
		} catch (SolutionNotFound s) {
			return false;
		}
	}

	public static boolean hiddenTest01() {
		Polynomial p = new Polynomial();
		p.add(43,1000);
		p.add(93,283);
		p.add(-76,210);
		p.add(-53,289);
		p.add(-34,536);
		p.add(97,816);
		p.add(-71,849);
		p.add(54,950);
		p.add(81,80);
		p.add(20,290);
		p.add(-95,491);
		p.add(-77,217);
		p.add(-52,99);
		p.add(31,188);
		p.add(78,191);
		p.add(-68,62);
		p.add(-24,213);
		p.add(-64,494);
		p.add(44,126);
		p.add(26,202);
		double result = 0;
		try {
			result = p.solve(-1,1e-6,1000);
			//			final double SOLN = 					-0.9692006666837935;
			double eval = p.eval(result);
			return Math.abs(eval) < 1e-3;
		} catch (SolutionNotFound s) {
			return false;

		}
	}

	public static boolean hiddenTest02() {
		Polynomial p = new Polynomial();
		p.add(-52,613);
		p.add(-65,4);
		p.add(-50,182);
		p.add(-24,609);
		p.add(-42,31);
		p.add(8,400);
		p.add(-67,414);
		p.add(73,443);
		p.add(1,290);
		p.add(-2,230);
		p.add(-33,803);
		p.add(100,642);
		p.add(-14,264);
		p.add(-6,409);
		p.add(-59,9);
		p.add(-62,806);
		p.add(7,106);
		p.add(10,737);
		p.add(-20,103);
		p.add(-85,262);
		double result = 0;
		try {
			result = p.solve(2,1e-6,1000);
			//final double SOLN = 					2.8637387662252015E-6;
			double eval = p.eval(result);
			return Math.abs(eval) < 1e-3;

		} catch (SolutionNotFound s) {
			return false;
		}
	}


	public static boolean hiddenTest03() { 
		Polynomial p = new Polynomial();

		p.add(-2,2);
		p.add(-1,1);


		String out = p.toString();
		return out.equals("-2*x^2 - 1*x^1");
	}

	public static boolean hiddenTest04() { 
		Polynomial p = new Polynomial();
		return "".equals(p.toString());
	}

	public static boolean hiddenTest05() { 
		Polynomial p = new Polynomial();

		p.add(10,0);
		return "".equals(p.derivative().toString());
	}

	public static boolean hiddenTest06() {
		Polynomial p = new Polynomial();

		p.add(3000,0);

		try {
			p.solve(0, 1, 1000);
			return false;
		} catch (SolutionNotFound snf) { 
			return (snf.getMessage().equals(DIVIDE));
		}
	}

	public static boolean hiddenTest07() { 
		Polynomial p = new Polynomial();
		p.add(1,3);
		p.add(1,2);
		p.add(1,0);

		try {
			p.solve(0, 1, 1000);
			return false;
		} catch (SolutionNotFound snf) { 
		    return (snf.getMessage().equals(DIVIDE));
		}
	}
	
	public static void main(String[] args) {



		System.out.println( "Test 1 " + (hiddenTestOLL00() ? "passed" : "failed" ));
		System.out.println( "Test 2 " + (hiddenTestOLL01() ? "passed" : "failed" ));

		System.out.println( "Test 3 " + (hiddenTest00() ? "passed" : "failed" ));
		System.out.println( "Test 4 " + (hiddenTest01() ? "passed" : "failed" ));
		System.out.println( "Test 5" + (hiddenTest02() ? " passed" : "failed" ));
		System.out.println( "Test 6 " + (hiddenTest04() ? "passed" : "failed" ));
		System.out.println( "Test 7 " + (hiddenTest05() ? "passed" : "failed" ));
		System.out.println( "Test 8 " + (hiddenTest06() ? "passed" : "failed" ));
		System.out.println( "Test 9 " + (hiddenTest07() ? "passed" : "failed" ));

	}

}
