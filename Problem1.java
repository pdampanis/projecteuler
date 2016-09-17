
public class Problem1 {

	/**
	 * @param args
	 */
	
	public static boolean palindrome(int number){
		int[] y = new int[6];
		for(int i = 0; i < 6; i++){
			
			y[i] = number % 10;
			number = number / 10;
			//System.out.println(y[i]+" "+i+" "+number);
		}
		int j = 5;
		for(int i = 0; i < 3; i++){
			if (y[i] == y[j--]);
			else return false;
		}
		return true;
	}
	
	
	
	
	public static void main(String[] args) {

		int x;
		int maxPal = 0;
		for(int i = 100; i <= 999; i++){
			for(int j = 100; j <= 999; j++){
				x = i * j;
				//System.out.println(x);
				if(palindrome(x) && x > maxPal) maxPal = x;
			}
		}
		//if(palindrome(y)) System.out.println(y+ " is palindrome");
		System.out.println(maxPal);
		
	}

}
