import java.util.Arrays;

public class Problem52 {

	public static String sortString(String s){
		char[] array = s.toCharArray();
		Arrays.sort(array);
		String sorted = String.valueOf(array);
		
		return sorted;
	}
	
	public static boolean isPermuted(int a){
		String s = sortString(Integer.toString(a));
		for(int i = 2; i <= 6; i++){
			if( s.equals(sortString(Integer.toString(i*a))) )
				;
			else
				return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		
		long now = System.currentTimeMillis();
		
		for(int i = 10; i < 1000000; i++){
			if(isPermuted(i)){
				System.out.println(i);
				break;
			}
		}
		
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
	}
}
