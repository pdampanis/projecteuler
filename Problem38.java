import java.util.*;
public class Problem38 {

	public static boolean isPdig(String s){
		return s.equals("123456789");
	}
	
	public static String sortString(String s){
		char[] array = s.toCharArray();
		Arrays.sort(array);
		String sorted = String.valueOf(array);
		
		return sorted;
	}
	
	public static void main(String[] args) {
		
		long now = System.currentTimeMillis();
		long max = 0;
		long number = 0;
		String s = "";
		for(int i = 1; i < 10000; i++){
			for(int j = 1; s.length() <= 8; j++){
				s += Integer.toString(i*j);
			}
			if(s.length() == 9 && isPdig(sortString(s))){
				int l = s.length() - 1;
				for(int k = 0; k < s.length() ; k++){
					long n = Character.getNumericValue(s.charAt(k));
					number += n * Math.pow(10, l--);
				}
				if(number > max) max = number;
			}
			number = 0;
			s = "";
			
		}
		System.out.println("Max is: "+max);
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
	}
}
