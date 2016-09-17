
public class Problem46 {

	public static boolean isInteger(double a){
		return (a == Math.floor(a));
	}
	
	public static void main(String[] args) {
		
		long now = System.currentTimeMillis();
		int n = 10000;
		boolean[] a = new boolean[n];
		for(int i = 0; i < n; i++)
			a[i] = true;
		
		for(int i = 2; i <= Math.sqrt(n-1); i++){
			if(a[i] == true){
				for(int j = (i*i); j <= n-1; j+=i)
					a[j] = false;
			}
		}
		
		int countodc = 0;
		int countp = 0;
		for(int i = 2; i<=n-1; i++){
			if(a[i] == true) countp++;
			else if(a[i] == false && (i % 2 == 1)) countodc++;
		}
		
		double[] primes = new double[countp];
		double[] oddcomp = new double[countodc];
		int i,k= 0,j = 0;
		for(i = 2; (i <= n-1) ; i++){
			if(a[i] == true){ primes[j++] = i; }
			else if(a[i] == false && (i % 2 == 1)) oddcomp[k++] = i;
		}
		
		boolean flag = false;
		for(i = 0; i < oddcomp.length; i++){
			for(j = 0; (j < primes.length && oddcomp[i] > primes[j]); j++){
				
				if(isInteger(Math.sqrt( (oddcomp[i] - primes[j])/2 ))){
					flag = false;
					break;
				}
				else flag = true;
			}
			if(flag) { System.out.println("Smallest: "+oddcomp[i]); break;}
			
		}
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
	
	}
}
