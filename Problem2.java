
public class Problem2 {

	public static void main(String[] args) {
		int n1 = 1;
		int n2 = 2;
		int n3;
		int sum = 2;
		
		while(true){
				n3 = n1 + n2;
				if(n3 > 4000000) break;
				n1 = n2;
				n2 = n3;
				if(n3 % 2 == 0) sum += n3;
		}
		System.out.println(sum);
	}
}
