import java.math.BigInteger;


public class Problem63 {

	public static long countDigits(BigInteger b){
		String s = b.toString();
		return s.length();
	}
	
	public static void main(String[] args) {
		
		long count = 0;
		for(int base = 1; base <= 100; base++){
			for(int exp = 1; exp <= 100; exp++){
				BigInteger b = BigInteger.valueOf(base).pow(exp);
				if(exp == countDigits(b)){
					//System.out.println(base + "^" + exp);
					count++;
					//System.out.println(b);
				}
			}
		}
		
		System.out.println("count is : " + count);
		
	}

}
