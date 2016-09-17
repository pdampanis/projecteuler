import java.math.BigInteger;


public class Problem56 {

	public static BigInteger pow(int b, int e){
		BigInteger r = BigInteger.ONE;
		for(int i = 1; e >= i; i++)
			r = r.multiply(BigInteger.valueOf(b));
		return r;
	}
	
	public static long sum(String s){
		long sum = 0;
		for(int i = 0; i < s.length(); i++)
			sum += Character.getNumericValue(s.charAt(i));
		return sum;
	}
	
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		
		long[][] l = new long[100][100];
		String[][] s = new String[100][100];
		BigInteger[][] b = new BigInteger[100][100];
		for(int i = 1; i < 100; i++){
			for(int j = 1; j < 100; j++){
				b[i][j] = pow(i,j);
				s[i][j] = b[i][j].toString();
				l[i][j] = sum(s[i][j]);
			}
		}
		
		long max = 0;
		for(int i = 1; i < 100; i++){
			for(int j = 1; j < 100; j++){
				if(l[i][j] > max) max =l[i][j];
			}
		}
		System.out.println("Max is: "+ max);
		System.out.println("Completed in " + (System.currentTimeMillis() - now) / 1000.0 + " second(s).");
		
	}
}
