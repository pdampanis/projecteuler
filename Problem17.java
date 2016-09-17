
public class Problem17 {

	
	public static int f(int x){
		if(x < 30) return 20;
		int y = x - 30;
		int z = y/10;
		
		return x - (z + 1)*9;
	}
	
	
	public static int numLength(int number, String[] s){
		int k = 1;
		int x = number;
		while((x /= 10)!= 0) k++;
		int[] y = new int[k];
		x = number;
		for(int i = k - 1; i >= 0; i--){
			y[i] = x % 10;
			x /= 10;
		}
		String str = "";
		if(k > 3){
			str = "onethousand";
			return str.length();
		}
		
		if(k == 3){
			if((y[1] == 0) && (0 == y[2])){
				str = s[y[0]]+"hundred";
			}
			else if(y[1] <= 1){
				str = s[y[0]]+"hundred"+"and";
				if(y[1] == 0) str += s[y[2]];
				else str += s[10+y[2]];
			}
			else if(y[1] >= 2){
				str = s[y[0]]+"hundred"+"and"+s[f(y[1]*10)]+s[y[2]];
			}
		}
		else if(k == 2){
			if(y[0] == 1){
				if(y[1] == 0){
					str = s[10];
				}
				else{
					str = s[10+y[1]];
				}
			}
			else if(y[0] >= 2){
				str = s[f(y[0]*10)] + s[y[1]]; 
			}
			
		}
		else if(k == 1){
			str = s[y[0]];
		}
		
	return str.length();
		
	}
	
	public static void main(String[] args) {
		
		String[] s = {"","one","two","three","four","five", "six","seven","eight",
				"nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen",
				"seventeen","eighteen","nineteen","twenty","thirty","forty","fifty","sixty",
				"seventy","eighty","ninety"};

		
		long now = System.currentTimeMillis();
		int sum = 0;
		for(int i = 1; i <= 1000; i++)
			sum += numLength(i,s);
			
		System.out.println("sum is "+sum);
		System.out.println("Completed in " + (System.currentTimeMillis() - now) + "ms.");
		
	}

}
