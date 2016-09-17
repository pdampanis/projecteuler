
public class Problem37 {

	public static int binary_search(int A[], int key, int imin, int imax)
	{
	  // test if array is empty
	  if (imax < imin)
	    // set is empty, so return value showing not found
	    return -1;
	  else
	    {
	      // calculate midpoint to cut set in half
	      int imid = (imin + imax) / 2;
	 
	      // three-way comparison
	      if (A[imid] > key)
	        // key is in lower subset
	        return binary_search(A, key, imin, imid-1);
	      else if (A[imid] < key)
	        // key is in upper subset
	        return binary_search(A, key, imid+1, imax);
	      else
	        // key has been found
	        return imid;
	    }
	}
	
	public static int StringtoInt(String s){
		int j = 0, sum = 0;
		for(int i = s.length() - 1; i >= 0; i--)
			sum += Character.getNumericValue(s.charAt(j++)) * Math.pow(10, i);
		return sum;
	}
	
	
	public static boolean isPrime(int[] a,int number){
		if(binary_search(a, number, 0, a.length - 1) != -1)
			return true;
		return false;
	}
	
	public static boolean isTruncatable(int[] a, int number){
		String s = Integer.toString(number);
		
		//left
		for(int i = 1; i < s.length(); i++){
			if(isPrime(a, StringtoInt(s.substring(i))) );
			else
				return false;
		}
		
		//right
		for(int i = s.length() - 1; i > 0; i--){
			if(isPrime(a, StringtoInt(s.substring(0,i))) );
			else
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		
		int n = 1000000;
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
		
		int sum = 0, c = 0;
		for(i = 4; i < primes.length; i++){
			if(isTruncatable(primes, primes[i])){
				c++;
				sum += primes[i];
			}
		}
		System.out.println(sum+" "+c);

		System.out.println("Completed in " + (System.currentTimeMillis() - now) / 1000.0 + " second(s).");
		

	}

}
