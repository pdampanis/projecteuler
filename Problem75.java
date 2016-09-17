
public class Problem75 {
	
	public static boolean isPythagorean(long a, long b, long c){
		if( Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2) )
			return true;
		return false;
	}

	public static void main(String[] args) {
		
		int count = 0;
		for(long a = 3; a < 10; a++){
			for(long b = a + 1; b < 15; b++){
				for(long c = b + 1; a+b+c <= 30; c++){
					System.out.println("a: " + a + " b: " + b + " c: " + c);
					if(isPythagorean(a, b, c)){
						count++;
						System.out.println(a+b+c + " count : " + count);
					}
				}
			}
		}
		System.out.println(count);
		
		
		
	}

}
