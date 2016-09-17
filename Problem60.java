
public class Problem60 {
	
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
	
	public static boolean isPrime(long a){
		   if(a == 2){
		      return true;
		   }else if(a <= 1 || a % 2 == 0){
		      return false;
		   }
		   long max = (long)Math.sqrt(a);
		   for(long n= 3; n <= max; n+= 2){
		      if(a % n == 0){ return false; }
		   }
		   return true;
		}
	
	public static boolean find(int[] p, int a, int b, int c, int d, int e){
		int[] comb = {a,b,c,d,e};
		for(int i = 0; i < comb.length - 1; i++){
			for(int j = i+1; j < comb.length; j++){
				String s1 = Integer.toString(comb[i]) + Integer.toString(comb[j]);
				String s2 = Integer.toString(comb[j]) + Integer.toString(comb[i]);
				if(isPrime(p, StringtoInt(s1)) && isPrime(p, StringtoInt(s2))) ;
				else 
					return false;
			}
		}
		return true;
	}
	
	public static boolean find(int[] p, int a, int b, int c, int d){
		int[] comb = {a,b,c,d};
		for(int i = 0; i < comb.length - 1; i++){
			for(int j = i+1; j < comb.length; j++){
				String s1 = Integer.toString(comb[i]) + Integer.toString(comb[j]);
				String s2 = Integer.toString(comb[j]) + Integer.toString(comb[i]);
				if(isPrime(StringtoInt(s1)) && isPrime(StringtoInt(s2))) ;
				else 
					return false;
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) {
		long now = System.currentTimeMillis();
		int n = 20000000;
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
		
		System.out.println(primes.length+" "+primes[primes.length-1]+" "+primes[primes.length-2] );
		//168 length of n = 1000 last prime 997
		/*
		int c = 0;
		for(i = 0; i < 303 - 4; i++){
			for(j = i+1; j < 303 - 3; j++){
				for(int k = j+1; k < 303 - 2; k++){
					for(int l = k+1; l < 303 - 1; l++){
						for(int m = l+1; m < 303; m++){
							if (find(primes,primes[i],primes[j],primes[k],primes[l],primes[m]))
								System.out.println(primes[i]+primes[j]+primes[k]+primes[l]+primes[m]);
							//else
								//System.out.println("FALSE "+ primes[i]+" "+primes[j]+" "+primes[k]+" "+primes[l]+" "+primes[m]);
								
						}
					}
				}
			}
			System.out.println(primes[i]);
			System.out.println("Time " + (System.currentTimeMillis() - now) / 1000.0 + " second(s).");

		}
		*/
		//System.out.println(c);
		
		for(i = 0; i < 303 - 3; i++){
			for(j = i+1; j < 303 - 2; j++){
				for(int k = j+1; k < 303 - 1; k++){
					for(int l = k+1; l < 303; l++){
						if (find(primes,primes[i],primes[j],primes[k],primes[l]))
							System.out.println(primes[i]+" "+primes[j]+" "+primes[k]+" "+primes[l]);
					}
				}
			}
		}
		

		
	}

}


