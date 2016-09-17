
public class Problem27 {
	
	public static int formula(int n, int a, int b){
		return (n*n + a*n + b);
	}
	
	public static boolean search(int[] p, int n){
		for(int i = 0; i < p.length; i++){
			if(p[i] == n) return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
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
		
		System.out.println(primes.length + " "+ primes[primes.length - 1]);
		System.out.println(search(primes,formula(1,-79,1601)));
		
		int max = 0;
		int product = 1;
		for(i = -999; i <= 999; i++){
			for(j = -999; j <= 999; j++){
				int countp = 0;
				for(int k = 0; countp < 78498; k++){
					if(formula(k,i,j) < 0) break;
					if(search(primes,formula(k,i,j))) countp++;
					else break;
				}
				if(countp > max){ product = i*j; max = countp; }
			}
		}
		
		System.out.println(product);
		
	}

}
