
public class Problem49 {
	
	
	public static void find(String[] perms,int[] primes){
		
		int[] numbers = new int[perms.length];
		for(int i = 0; i < numbers.length; i++){
			int sum = 0; int k = 3;
			for(int j = 0; j < 4; j++){
				if(perms[i] != null)
					sum += Character.getNumericValue(perms[i].charAt(j)) * Math.pow(10, k--);
				
			}
			numbers[i] = sum;
		}
		
		int[] possible = new int[24];
		int k = 0;
		for(int i = 0; i < numbers.length; i++){
			for(int j = 0; j < primes.length; j++){
				if(numbers[i] == primes[j]){
					possible[k++] = numbers[i];
					break;
				}
			}
		}
		
		int m = 0;
		for(int i = 0; i < possible.length; i++)
			if(possible[i] != 0) m++; 

		
		int[] exact = new int[m];
		for(int i = 0; i < m; i++){
			exact[i] = possible[i];
		}
		
		int[] minus = new int[exact.length];
		m = 0;
		for(int i = 0; i < exact.length; i++){
			minus[m++] = Math.abs(exact[0] - exact[i]);
		}
		
		for(int i = 0; i < minus.length; i++){
			for(int j = i + 1; j < minus.length; j++){
				if(Math.abs(minus[i] - minus[j]) == minus[i])
					System.out.println(minus[i]+" "+minus[j]+
							" ~ "+exact[0]+" "+exact[i]+" "+exact[j]);
			}
			
		}
		
	}
	
	public static int fact(int a){
		int g = 1;
		for(int i = 0; i < a; i++){
			g *= (i + 1);
		}
		return g;
	}
	
	public static int[] apart(int number){
	      int k = 1;
	      int x = number;
	      while((x /= 10)!= 0) k++;
	      int[] y = new int[k];
	      x = number;
	      for(int i = k - 1; i >= 0; i--){
	         y[i] = x % 10;
	         x /= 10;
	      }
	      return y;
	   }
	
	public static String intToString(int[] a){
		String temp = "";
		for(int i = 0; i < a.length; i++)
			temp += Integer.toString(a[i]);
		return temp;
	}
	
	public static int findIndexK(int[] a){
		int k = 0, c = 0;
		int index = -1;;
		for(k = 0; k < (a.length - 1); k++){
			if(a[k] < a[k+1])
				index = k;
			else 
				c++;
		}
		
		if(c == a.length - 1) return -1;
		return index;
	}
	
	public static void swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static int[] findNextPerm(int[] a, int indexK){
		int i = 0,indexL = -1;
		for(i = indexK + 1; i < a.length; i++){
			if(a[indexK] < a[i])
				indexL = i;
		}
		swap(a, indexK, indexL);
		
		if( (indexK + 1 == indexL) && (indexL == a.length - 1) ) return a;
		else{
			int j = 0;
			int[] temparr = new int[a.length - (indexK + 1)];
			
			for(i = a.length - 1; i >= (indexK + 1); i--)
				temparr[j++] = a[i];
			
			j = 0;
			for(i = indexK + 1; i < a.length; i++)
				a[i] =temparr[j++];
			
			return a;
		}
		
	}
	
	public static String[] findPerms(int[] a){
		int indexK = findIndexK(a);
		int g = fact(a.length);
    	String[] perms = new String[g];
    	perms[0] = intToString(a);
    	int countIndex = 1;
    	while(indexK != -1){
    		int []perm = findNextPerm(a, indexK);
    		perms[countIndex++] = intToString(perm);
    		a = perm;
    		indexK = findIndexK(perm);
    	}
    	return perms;
	}
	
	/////////MAIN
	public static void main(String[] args){
		
		long now = System.currentTimeMillis();
		
		int n = 100000;
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
		
		int c = 0;
		for(i = 0; i < primes.length; i++){
			if((primes[i] >= 1000) && (primes[i] <= 9999)){
				c++;
			}
		}
		int[] p = new int[c];
		j = 0;
		for(i = 0; i < primes.length; i++){
			if((primes[i] >= 1000) && (primes[i] <= 9999)){
				p[j++] = primes[i];
			}
		}

		for(i = 0; i < p.length; i++){
			int[] tmp = apart(p[i]);
			String[] perms = findPerms(tmp);
			find(perms,p);
		}
		
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");

		
	}
}
