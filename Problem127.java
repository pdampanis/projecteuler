
public class Problem127 {

	
	public static int binary_search(int A[], long key, int imin, int imax)
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
	
	public static boolean isPrime(int[] a, long number){
		if(binary_search(a, number, 0, a.length - 1) != -1)
			return true;
		return false;
	}
	
	public static long rad(int[] p, int number){
		int prime = p[0];
		long l = p.length;
		int i = 1, count = 0;
		long g = 1, prev = 1;
		while((number != 1) && (i < l) ){
			
			if(number % prime == 0){
				if(prev != prime){ 
					g *= prime;
					count++;
				}
				number /= prime;
				prev = prime;
			}
			else
				prime = p[i++];
			
			if(number == 1 && count == 1)
				return -1;
		}
		return g;
	}
	
	public static long gcd(long a, long b){
		if (b == 0)
			return a;
		else
       return gcd(b, a % b);
	}
	
	public static boolean judge(int[] primes, int i, int j, int c){
		if( ( (gcd(i,j) == 1) &&  (gcd(i,c) == 1) && (gcd(j,c) == 1) ) 
				&& ( ( rad(primes, (i*j*c)) != -1 ) && (rad(primes, (i*j*c)) < c)) )
			return true;
		return false;
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
		System.out.println(primes.length + " " + primes[primes.length - 1]);
		
		//for c < 1000 - i < 501 - j + i < 1000
		long sum = 0;
		for(i = 1; i < 60001; i++){
			for(j = i + 1; j + i < 120000; j++){
				int c = i + j;
				//System.out.println(i + " " + j + " " + c );
				//if(c >= 1000) break;
				if(  judge(primes, i, j, c) ){
					//System.out.println(i + " " + j + " " + c );
					//System.out.print(" -> TRUE");
					//System.out.println();
					sum += c;
					//System.out.println(sum);
				}
			}
		}
		System.out.println("Sum is " + sum);
	    System.out.println("Time " + (System.currentTimeMillis() - now) / 1000.0 + " second(s).");

		
	}

}
