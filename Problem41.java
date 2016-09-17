import java.util.Arrays;

public class Problem41 {
	
	public static boolean isPdig(String s){
		int k = 1;
		for(int i = 0; i < s.length(); i++){
			if( !Character.toString(s.charAt(i)).equals(Integer.toString(k++)))
				return false;
		}
		return true;
	}
	
	public static String sortString(String s){
		char[] array = s.toCharArray();
		Arrays.sort(array);
		String sorted = String.valueOf(array);
		
		return sorted;
	}
	
	public static void main(String[] args) {
		
		long now = System.currentTimeMillis();
		
		int n = 10000000;
		boolean[] a = new boolean[n];
		for(int i = 0; i < n; i++)
			a[i] = true;
		
		for(int i = 2; i <= Math.sqrt(n-1); i++){
			if(a[i] == true){
				for(int j = (i*i); j <= n-1; j+=i)
					a[j] = false;
			}
		}
		
		int count = 0;
		for(int i = 2; i<=n-1; i++){
			if(a[i] == true) count++;
		}
		
		int[] primes = new int[count];
		int i,j = 0;
		for(i = 2; (i <= n-1) ; i++){
			if(a[i] == true){ primes[j++] = i; }
		}
		
		int max = 0;
		String s = "";
		for(i = 0; i < count; i++){
			s = Integer.toString(primes[i]);
			if( s.length() < 10 && isPdig(sortString(s)) ){
				if( primes[i] > max) max = primes[i];
			}
		}
		
		System.out.println("Max is: "+max);
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
	}

}
