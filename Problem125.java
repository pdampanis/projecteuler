import java.math.BigInteger;


public class Problem125 {

	public static boolean isPalindrome(String s){
		int i = 0, j = s.length() - 1;
		while( i <= j ){
			if(s.charAt(i++) == s.charAt(j--)) ;
			else 
				return false;
		}
		return true;
	}
	
	
	public static boolean seqSearch(long a[], long key){
		for(int i = 0; i < a.length; i++){
			if(key == a[i]) return true;
		}
		return false;
	}
	
	
	public static BigInteger sum(){
		long[] s = new long[200];
		long sum = 0; 
		int countp = 0;
		BigInteger psums = BigInteger.ZERO;
		for(int i = 1; i <= 10000; i++){
			int j = i;
			int count = 0; 
			while(  j <= 10000 ){
				sum += j*j;
				count++;
				if( (count > 1) && isPalindrome(Long.toString(sum)) && sum < Math.pow(10, 8)
						&& !seqSearch(s, sum)){ 
					psums = psums.add(BigInteger.valueOf(sum));
					s[countp++] = sum;
				}

				j++;
			}
			sum = 0;
		}
	return psums;
	}
	
	
	
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		System.out.println(sum());
		System.out.println("Time " + (System.currentTimeMillis() - now) / 1000.0 + " second(s).");
		
	}

}
