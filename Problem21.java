
public class Problem21 {

	public static int d(int number){
		int sum = 0;
		for(int i = 1; i < number; i++){
			if((number % i) == 0) sum += i;
		}
		return sum;
	}
	
	public static boolean isAmicable(int number){
		int b = d(number);
		if((d(b) == number) && (number != b))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		
		long now = System.currentTimeMillis();
		int sum = 0;
		for(int i = 1; i < 10000; i++){
			if(isAmicable(i)) sum += i;
		}
		System.out.println(sum);
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
	}
}
