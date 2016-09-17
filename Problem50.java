
public class Problem50 {

	public static void main(String[] args) {
		
		long now = System.currentTimeMillis();
		int n = 1000009;
		boolean[] a = new boolean[n];
		for(int i = 0; i < n; i++)
			a[i] = true;
		
		for(int i = 2; i <= Math.sqrt(n-1); i++){
			if(a[i] == true){
				for(int j = (i*i); j <= n-1; j+=i)
					a[j] = false;
			}
		}
		
		int countp = 0;
		for(int i = 2; i<=n-1; i++){
			if(a[i] == true) countp++;
		}
		
		int[] primes = new int[countp];
		int i,j = 0;
		for(i = 2; (i <= n-1) ; i++){
			if(a[i] == true) primes[j++] = i; 
		}
		
		int k,sum = 0;
		int items = 0;
		int maxN = 0,max = 0;
		for(i = 162; primes[i] < 1000000; i++){
			k = 0;
			j = k;
			while(sum < primes[i]){
				//System.out.print(primes[i]+" --> "+primes[j]+" ");
				sum += primes[j++];
				items++;
				if(sum > primes[i]){
					sum = 0;
					k++;
					j = k;
					items = 0;
				}
				
			}
			//System.out.println();
			//System.out.println(sum+" "+primes[i]);
			if(sum == primes[i] && items > 1){
				if(items > max){ max = items; maxN = primes[i]; }
				//System.out.println(items+" "+primes[i]);
			}
			sum = 0;
			items = 0;
		}
		System.out.println();
		System.out.println(max+" "+maxN);
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
			

	}

}
