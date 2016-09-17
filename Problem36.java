public class Problem36 {

	public static boolean isPalindrome(String s){
		int i = 0, j = s.length() - 1;
		while( i <= j ){
			if(s.charAt(i++) == s.charAt(j--)) ;
			else 
				return false;
		}
		return true;
	}
	
	public static String toBinary(int number){
		String s = "";
		while(number != 0){
			s += Integer.toString((number % 2));
			number /= 2;
		}
		String s2 = "";
		for(int i = s.length() - 1; i >= 0; i--)
			s2 += s.charAt(i);
		return s2;
	}
	
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		int sum = 0;
		for(int i = 1; i < 1000000; i++){
			if(isPalindrome(Integer.toString(i)) && isPalindrome(toBinary(i)) )
				sum += i;
		}
		System.out.println(sum);
		System.out.println("Completed in " + (System.currentTimeMillis() - now) / 1000.0 + " second(s).");
	}

}
