
public class Problem10 {
	
	int number;
	boolean flag;
	
	Problem10(){
		this.number = 0;
		this.flag = true;
	}
	
	public static int[] apart(int number){
		int k = 1;
		int x = number;
		while((x /= 10)!= 0) k++;
		int[] y = new int[k];
		x = number;
		/*
		for(int i = 0; i < k; i++){
			y[i] = x % 10;
			x /= 10;
		}
		*/
		for(int i = k-1; i >= 0; i--){
			y[i] = x % 10;
			x /= 10;
		}
		return y;
	}
	public static void swap(int i, int j, int[] arr) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
		}
	
	public static Problem10[] rotate(int num){
		
		int [] number = apart(num);
		
		Problem10[] p = new Problem10[number.length];
		
		int i = 0;
		for(i = 0; i < number.length; i++)
			p[i] = new Problem10();
		
		p[0].number = num;
		
		//rotate
		int n = 0;
		for(i = 0; i < number.length - 1; i++){
			int temp = number[i];
			number[i] = number[i+1];
			number[i+1] = temp;
		
			n = 0;
			int j = number.length;
			for(int k = 0; k < number.length; k++){
				n += number[k] * Math.pow(10, j-1);
				j--;
			}
			if(n == p[i].number) break;
			p[i+1].number = n;
		}
		return p;
	}
		
	public static void main(String[] args) {
		
		int n = 1000000;
		boolean[] a = new boolean[1000000];
		for(int i = 0; i < 1000000; i++)
			a[i] = true;
		
		
		for(int i = 2; i <= Math.sqrt(n-1); i++){
			if(a[i] == true){
				for(int j = (i*i); j <= n-1; j+=i)
					a[j] = false;
			}
		}
		
		long sum = 0;
		for(int i = 2; i<=n-1; i++){

			if(a[i] == true) sum += i;
		}
		System.out.println(sum);
			
		int j =0;
		int i = 0;
		for(i = 2; (i <= n-1) && (j != 10001); i++){
			if(a[i] == true) j++;
		}
		//System.out.println(i);
		int[] fp = new int[100];
		long num = 600851475143L;
		j = 0;
		for(i = 2; i<=n-1; i++){
			if(a[i] == true){
				if(num % i == 0){ fp[j] = i; j++;}
			}
		}
		
		for(i = 0; i<100; i++)
			System.out.print(fp[i]+" ");
		
		int[] primes = new int[78498];
		j = 0;
		for(i = 2; (i <= n-1) && (j < 78498) ; i++){
			if(a[i] == true){ primes[j] = i; j++;}
		}
		
		
		Problem10[] p = new Problem10[78500];
		
		for(i = 0; i < 78498; i++)
			p[i] = new Problem10();
		
		for(i = 0; i < 78498; i++)
			p[i].number = primes[i];
		
		System.out.println();
		for(i = 0; i<100; i++)
			System.out.print(primes[i]+" ");
		
		/*
		Problem10[] pr = rotate(11);
		System.out.println();
		for(i = 0; i < pr.length; i++)
			System.out.println(pr[i].number);
		*/
		System.out.println();
		int m,c = 0,t = 0;
		int circular = 4;
		for(i = 4; i < 170; i++){
			Problem10[] pro = rotate(primes[i]);
			//System.out.println(pro.length);
			/*
			t = 0;
			int l = pro.length - 1;
			for(m = 0; m < pro.length/2; m++){
				if (pro[m].number == pro[l--].number)
					t++;
			}
			if(t == pro.length/2) circular++;
			*/
			c = 0;
			for(j = 0; j < pro.length; j++){
				System.out.print(pro[j].number + " ");
				for(int k = i ; k < 170; k++){
					if(pro[j].number == primes[k]) c++;
				}
			}
			if(c == pro.length) { circular++; System.out.println(circular); }
			System.out.println();
		}
		
		System.out.println("\n"+circular);
		/*
		System.out.println();
		boolean flag = true;	
		int circular = 4;
		for(i = 4; i < 78498; i++){
			j = i+1;
			flag = true;
			while((flag) && (apart(primes[j]).length == apart(primes[i]).length)){
				System.out.println(primes[i]+ " "+ primes[j]);
				if(kark(primes[i], primes[j])) {circular++; System.out.println(" "+circular); flag = false;}
				j++;
				if(j == primes.length) break;
			}
		 }
		
			
		System.out.println("\n Circular Primes: "+ circular);
 */
 }
}