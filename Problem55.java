import java.math.BigInteger;

public class Problem55 {

	public static boolean isPalindrome(String s){
		int i = 0, j = s.length() - 1;
		while( (s.charAt(i++) == s.charAt(j--)) && (i <= j) );
		return (i > j);
	}
	
	public static BigInteger pow(int b, BigInteger e){
		BigInteger r = BigInteger.ONE;
		for(int i = 1; (e.compareTo(BigInteger.valueOf(i)) >= 0); i++)
			r = r.multiply(BigInteger.valueOf(b));
		return r;
	}
	
	public static BigInteger reverse(String s){
		//reverse the number as a String and make it a number again
		String str = "";
		for(int i = s.length() - 1; i >= 0; i--)
			str += s.charAt(i);
		
		BigInteger l = BigInteger.valueOf(str.length() - 1);
    	BigInteger sum = BigInteger.ZERO;
    	for(int i = 0; i < str.length(); i++){
    		sum = sum.add((pow(10, l).multiply(BigInteger.valueOf(Character.getNumericValue(str.charAt(i))))));
    		l = l.subtract(BigInteger.valueOf(1));
    	}
		return sum;
	}
	
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		
		int j = 0;
		int countL = 0;
		for(int i = 10; i < 10000; i++){
			BigInteger temp = BigInteger.ZERO;
			temp = temp.add(BigInteger.valueOf(i));
			temp = temp.add(reverse(Integer.toString(i)));
			for(j = 1; j < 50; j++){
				if(isPalindrome(temp.toString())) break;
				temp = temp.add(reverse(temp.toString()));
			}
			if(j == 50)countL++;
		}
		
		System.out.println("Lychrel numbers: "+countL);
		System.out.println("Completed in " + (System.currentTimeMillis() - now) / 1000.0 + " second(s).");
	}
}
