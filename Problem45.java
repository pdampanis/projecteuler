
public class Problem45 {

	public static long triangle(long n){
		return (n*(n + 1) / 2);
	}
	
	public static boolean isP(long num){
		double a = (Math.pow((24*num + 1), 0.5) + 1) / 6;
		if(a == Math.floor(a)) return true;
		else return false;
	}
	
	public static boolean isH(long n, long number){
		for(int i = 143; i <= n; i++){
			if( (i*(2*i - 1)) == number)
				return true;
			}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		long now = System.currentTimeMillis();
		int count = 0;
		
		outerloop:
		for(long i = 285; i < 100000; i++){
			if(isP(triangle(i)) && isH(i,triangle(i)))
				count++;
			
			if(count == 2) {
				System.out.println(triangle(i));
				break outerloop;
			}
		}
		
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");

	}

}
