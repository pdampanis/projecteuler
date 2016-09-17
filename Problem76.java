
public class Problem76 {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 0;
		int count = 0, count2 = 0;
		int sum = 0;
		boolean flag = true, flag2 = true;
		while(a != 1){
			
			a--;
			b++;
			System.out.println(a+" "+b);
			count++;
			if(b > 1 && flag2) count += (b - 1);
			if( (a - 1) < (b + 1)){
				flag2 = false;
				System.out.println(count);
				if(flag){ sum += count; flag = false;}
				else {
						count2++;
				}
				//System.out.println(sum);
				a = b ;
				b = 0;
				count = 0;
			}
		}
		System.out.println(sum+(count2*count2));

	}

}
