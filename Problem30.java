
public class Problem30 {

	public static int[] apart(int number){
		int k = 1;
		int x = number;
		while((x /= 10)!= 0) k++;
		int[] y = new int[k];
		x = number;
		for(int i = 0; i < k; i++){
			y[i] = x % 10;
			x /= 10;
		}
		return y;
	}
	
	public static boolean fifth(int number){
		int[] y = apart(number);
		int sum = 0;
		for(int i = 0; i < y.length; i++){
			sum += Math.pow(y[i], 5);
		}
		
		if(sum == number) return true;
		else return false;
	}
	
	
	public static void main(String[] args) {
		
		int sum = 0;
		for(int i = 2; i <= 6*Math.pow(9, 5); i++){
			if(fifth(i)) sum += i;
		}
		System.out.println(sum);

	}

}
