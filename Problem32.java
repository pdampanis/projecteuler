import java.util.*;
public class Problem32 {
	
	public static boolean isPdig(String s){
		return s.equals("123456789");
		/*int k = 1;
		for(int i = 0; i < s.length(); i++){
			if( !Character.toString(s.charAt(i)).equals(Integer.toString(k++)))
				return false;
		}
		return true;*/
	}
	
	public static String sortString(String s){
		char[] array = s.toCharArray();
		Arrays.sort(array);
		String sorted = String.valueOf(array);
		
		return sorted;
	}
	
	public static void main(String[] args) {
		
		long now = System.currentTimeMillis();
		String s = "";
		int[] nums = new int[9];
		int k = 0;
		int sum = 0;
		for(int i = 1; i < 50; i++){
			for(int j = 100; j < 2000; j++){
				s = Integer.toString(i) + Integer.toString(j) 
						 + Integer.toString(i*j);
				if(s.length() == 9 && isPdig(sortString(s))) {
					//System.out.println(i+" x "+j+" = "+i*j);
					nums[k++] = i*j;
					sum += i*j;
				}
			}
		}
		
		for(int i = 0; i < nums.length; i++){
			for(int j = i+1; j < nums.length; j++){
				if(nums[i] == nums[j])  sum -= nums[j];
			}
		}
		System.out.println("Sum is: "+sum);
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
	}

}
