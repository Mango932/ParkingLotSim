/**
 * This class provides an implementation of a triangular probabilistic
 * distribution. A simple mathematical explanation of this probability
 * distribution is available on Wikipedia at:
 * https://en.wikipedia.org/wiki/Triangular_distribution
 * 
 * @author Mehrdad Sabetzadeh, University of Ottawa
 *
 */
public class TriangularDistribution {

	/**
	 * a, c, b are the three parameters on the x axis of
	 * https://en.wikipedia.org/wiki/File:Triangular_distribution_PMF.png
	 */
	int a, c, b;

	/**
	 * Constructor for TriangularDistribution. You need to verify that the following
	 * condition holds: a >= 0 AND a < c AND c < b
	 * 
	 * @param a is the lower limit of the distribution
	 * @param c is the mode
	 * @param b is the upper limit of the distribution
	 */
	public TriangularDistribution(int a, int c, int b) {
		if (a < c && c < b) {
			this.a = a;
			this.c = c;
			this.b = b;
		} else {
		
			throw new IllegalArgumentException("Invalid parameters: a <= c <= b and a < b");
	
		}
	}

	/**
	 * @param x is a point on the x axis
	 * @return the probability density at point x
	 */
	public Rational pdf(int x) {
		if (x > b) {
			throw new IllegalArgumentException("x must be less or equal to b");
		}
		if (a >= b) {
			throw new IllegalArgumentException("a must be less than b");
		}
		if (c <= a || c >= b) {
			throw new IllegalArgumentException("c must be between a and b");
		}

		if (x < a)
			return Rational.zero;

		if (x >= a && x <= c)
			return new Rational(2 * (x - a), (b - a) * (c - a));

		if (x > c && x <= b)
			return new Rational(2 * (b - x), (b - a) * (b - c));

		return Rational.zero;
	}
}