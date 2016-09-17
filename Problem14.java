
public class Problem14 {

	
	public static void main(String[] args) {
		
		long n;
		int n1 = 2;
		int n2 = -1;
		int i = 0, max = 0;
		
		while(n1 < 1000000){
			i = 1;
			n = n1;
			while(n!=1){
				if(n % 2 == 0) n = n/2;
				else n = 3*n+1;;
				i++;
			}
			if(i > max){ n2 = n1; max = i; }
			n1++;
		}
		System.out.println(n2+" "+max);	
		}	
	}
