import java.math.BigInteger;

public class Problem25 {
	
	public static void fib(){
		BigInteger[] b = new BigInteger[5000];
		b[1] = BigInteger.valueOf(1);
		b[2] = BigInteger.valueOf(1);
		
		for(int i = 3; i < 5000; i++){
			b[i] = b[i-1].add(b[i-2]);
			if(countDigits(b[i]) == 1000) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public static int countDigits(BigInteger num){
		int count = 0;
		while(num.compareTo(BigInteger.ZERO) != 0){
			count++;
			num = num.divide(BigInteger.valueOf(10));
		}
		return count;
	}
	
	public static void main(String[] args) {	
		long now = System.currentTimeMillis();
		fib();
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
	}
}
