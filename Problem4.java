
public class Problem4 {

	
	public static boolean palindrome(int number){
		int[] y = new int[6];
		for(int i = 0; i < 6; i++){
			y[i] = number % 10;
			number = number / 10;
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
			for(int j = i; j <= 999; j++){
				x = i * j;
				if(palindrome(x) && x > maxPal) maxPal = x;
			}
		}
		System.out.println(maxPal);
	}
}
