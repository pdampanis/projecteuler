import java.math.BigInteger;

public class Problem20 {

	public static BigInteger fact(BigInteger n){
		if(n.compareTo(BigInteger.ZERO) == 0) return BigInteger.ONE;
		return n.multiply(fact(n.subtract(BigInteger.ONE)));
	}
	
	public static void sumOfDigits(BigInteger num){
		int sum = 0;
		while(num.compareTo(BigInteger.ZERO) != 0){
			sum += (num.remainder(BigInteger.valueOf(10))).intValue();
			num = num.divide(BigInteger.valueOf(10));
		}
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		sumOfDigits(fact(BigInteger.valueOf(100)));
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
	}
}
