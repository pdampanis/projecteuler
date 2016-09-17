import java.math.BigInteger;


public class Problem16 {

	public static void solve(){
		
		BigInteger num = BigInteger.valueOf(2).pow(1000);
		int sum = 0;
		while(num.compareTo(BigInteger.ZERO) != 0){
			sum += (num.remainder(BigInteger.valueOf(10))).intValue();
			num = num.divide(BigInteger.valueOf(10));
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		
		solve();
		
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
	}

}
