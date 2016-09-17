
public class Problem134 {

	public static long pairConnection(long p1, long p2){
		String s = Long.toString(p1);
		String front = Long.toString(1);
		long i = 2;
		String number = front + s;
		//int count = 0;
		while( (Long.parseLong(number) % p2) != 0 ){
			front = Long.toString(i++);
			number = front + s;
			//count++;
		}
		//System.out.println(count);
		return Long.parseLong(number);
	}
	
	public static void main(String[] args) {
		
		int n = 1000005;
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
		
		System.out.println(primes.length + " last prime " + primes[primes.length - 2] + " " + primes[primes.length - 1]);
		
		long sum = 0;
		i = 2;
		while(primes[i] <= 1000000){
			sum += pairConnection(primes[i], primes[i+1]);
			System.out.println(primes[i]);
			i++;
		}
		
		System.out.println("Sum is : " + sum);
		
		
	} 

}
