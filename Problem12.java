
public class Problem12 {

	public static int triangle(int n){
		return (n*(n + 1) / 2);
	}
	
	public static void main(String[] args) {
		
		int n = 10001;//000
		int[] t = new int[n];
		
		for(int i = 1; i < n; i++){
			t[i] = triangle(i);
		}

		int div = 0;
		for(int i = 1; i < t.length; i++){
			for(int j = 1; j <= t[i]; j++){
				if(t[i] % j == 0) div++;
			}
			if(div > 500){
				System.out.println(div+" "+t[i]);
				break;
			}
			div = 0;
		}
		//16362060*/
		//50005000

	
	}

}
