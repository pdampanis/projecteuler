
public class Problem34 {

	public static int fact(int n){
		if (n == 0) return 1;
		return n * fact(n-1);
	}
	
	public static boolean curious(int number){
		int k = 1;
		int x = number;
		while((x /= 10)!= 0) k++;
		int[] y = new int[k];
		x = number;
		for(int i = 0; i < k; i++){
			y[i] = x % 10;
			x /= 10;
		}
		int sum = 0;
		for(int i = 0; i < k; i++)
			sum += fact(y[i]);
		if (sum == number) return true;
		else return false;
	}
	
	public static void main(String[] args) {
		int i;
		int sum = 0;
		
		for(i = 3; i <= 10000000; i++){
			if(curious(i))  sum += i;
		}
		
		System.out.println(sum);
	}

}
