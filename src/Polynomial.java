public class Polynomial extends OrderedLinkedList<Monomial>{

	private OrderedLinkedList<Monomial> monomialsList;
	
		public Polynomial() {
			monomialsList = new OrderedLinkedList<>();

		}
		
		public void add(int coefficient, int degree) {
			Monomial newMonomial = new Monomial(coefficient, degree);
			super.insert(newMonomial);	
			
			
		}
		
		public Polynomial derivative() {
			Monomial newMonomial;
			int coefficient;
			int degree;
			Polynomial derivativeFunction = new Polynomial();
			
			for (int i = 0; i < this.getSize(); i++) {
		        newMonomial = this.get(i);
		        coefficient = newMonomial.getCoefficient();
		        degree = newMonomial.getDegree();

		        if (degree > 0) {
		            int newCoefficient = coefficient * degree;
		            int newDegree = degree - 1;

		            derivativeFunction.add(newCoefficient, newDegree);
		        } 
			}
			return derivativeFunction;

		}
		
		public double eval(double z) {
			Monomial newMonomial;
			int coefficient;
			int degree;
			double derivResult = 0.0;
			
			for (int i = 0; i < this.getSize(); i++) {
				newMonomial = this.get(i);
		        coefficient = newMonomial.getCoefficient();
		        degree = newMonomial.getDegree();
				derivResult += coefficient * Math.pow(z,  degree);

			}
			return derivResult;
        }
		
		public String toString() {
			Monomial newMonomial;
			int coefficient;
			int degree;
			String result;
			boolean first;
			result  = "";
			first = true;
			
			for (int i = 0; i < this.getSize(); i++) {
				newMonomial = this.get(i); 
		        coefficient = newMonomial.getCoefficient();
		        degree = newMonomial.getDegree();

	            if (coefficient != 0) {
	            	if(!first) {
	            		if (coefficient > 0) {
	            			result += " + ";
	            		} else {
	            			result += " - ";
	            		}
	            	} else if (coefficient < 0) {
	            		result += " - ";
	            	}
	            	result += Math.abs(coefficient);

	            	if (degree >= 0) {
	            		result += "*x^" + degree;
	            		
	            	}
	            	first = false;
	            }
			}
			return result;
		}
		
		public double solve(double x0, double e, int T) throws SolutionNotFound {
			double xi = x0;
			int i = 0;

			while (i < T) {
			    double fxi = eval(xi);
			    double fxiDeriv = derivative().eval(xi);
			    

			    if (fxiDeriv == 0) {
			        throw new SolutionNotFound("divide by zero error");
			    }
			    double nextxi = xi - fxi / fxiDeriv;

			    if (Math.abs(nextxi - xi) < e) {
			        return nextxi; 
			    }
			    xi = nextxi;
			    i++;
			}
			throw new SolutionNotFound("maximum iteration exceeded");

		}

}
