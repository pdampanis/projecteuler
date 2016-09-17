
public class Problem5 {
	
	
	public static boolean even(int num){
		
		for(int i = 1; i <= 20; i++){
			if(num % i == 0) ;
			else return false;
		}
		return true;
		
	}

	public static void main(String[] args) {
		
		for(int i = 1; i <= 1000000000; i++){
			if(even(i))
				System.out.println(i);
		}
		
	}

}
