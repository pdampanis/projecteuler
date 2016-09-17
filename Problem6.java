
public class Problem6 {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i <= 100; i++){
			sum += i*i;
		}
		
		int sum2 = 0;
		for(int i = 1; i < 101; i++) sum2 += i;
		
		System.out.println(sum2*sum2 - sum);
		System.out.println(sum2*sum2 + " "+sum);

	}

}
